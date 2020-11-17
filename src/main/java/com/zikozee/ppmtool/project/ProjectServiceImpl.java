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
        }catch (DataIntegrityViolationException e){
            throw new ProjectIdException("Project Id '" + StringUtils.trimAllWhitespace(projectDTO.getProjectIdentifier()).toUpperCase() + "' already exist");
        }catch (Exception e){
            throw new ProjectException("An Error Occurred: "  + e.getMessage());
        }
    }

}
