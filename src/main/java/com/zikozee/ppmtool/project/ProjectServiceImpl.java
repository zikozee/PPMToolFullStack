package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.exceptions.ProjectException;
import com.zikozee.ppmtool.exceptions.ProjectIdException;
import com.zikozee.ppmtool.project.dto.ProjectDTO;
import com.zikozee.ppmtool.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDTO saveOrUpdateProject(ProjectDTO projectDTO) {
        try{
            projectDTO.setProjectIdentifier(Utility.toUpperCaseNullable(projectDTO.getProjectIdentifier()));
            Project project = modelMapper.map(projectDTO, Project.class);
            return modelMapper.map(projectRepository.save(project), ProjectDTO.class);
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            throw new ProjectIdException("Project Id '" + StringUtils.trimAllWhitespace(projectDTO.getProjectIdentifier()).toUpperCase() + "' already exist");
        }catch (Exception e){
            throw new ProjectException("An Error Occurred: "  + e.getMessage());
        }
    }

    @Override
    public ProjectDTO findProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(Utility.toUpperCaseNullable(projectIdentifier))
                .orElseThrow(() -> new ProjectIdException("Project with identifier: " + projectIdentifier + " does not exist"));

        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public List<ProjectDTO> findAllProject() {
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        projectRepository.findAll().forEach(project -> projectDTOList.add(modelMapper.map(project, ProjectDTO.class)));
        return  projectDTOList;
    }

}
