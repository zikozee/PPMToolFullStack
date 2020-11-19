package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.exceptions.ProjectException;
import com.zikozee.ppmtool.exceptions.ProjectIdException;
import com.zikozee.ppmtool.project.dto.CreateProjectDTO;
import com.zikozee.ppmtool.project.dto.QueryProjectDTO;
import com.zikozee.ppmtool.project.dto.UpdateProjectDTO;
import com.zikozee.ppmtool.utility.PatchMapper;
import com.zikozee.ppmtool.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public QueryProjectDTO createProject(CreateProjectDTO createProjectDTO) {
        try{
            createProjectDTO.setProjectIdentifier(Utility.toUpperCaseNullable(createProjectDTO.getProjectIdentifier()));
            Project project = modelMapper.map(createProjectDTO, Project.class);
            return modelMapper.map(projectRepository.save(project), QueryProjectDTO.class);
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            throw new ProjectIdException("Project Id '" + Utility.toUpperCaseNullable(createProjectDTO.getProjectIdentifier()) + "' already exist");
        }catch (Exception e){
            throw new ProjectException("An Error Occurred: "  + e.getMessage());
        }
    }

    @Override
    public QueryProjectDTO updateProject(UpdateProjectDTO updateProjectDTO) {
        String projectIdentifier = Utility.toUpperCaseNullable(updateProjectDTO.getProjectIdentifier());
        updateProjectDTO.setProjectIdentifier(projectIdentifier);
        Project project = findByProjectIdentifier(projectIdentifier);

        project = PatchMapper.of(() -> updateProjectDTO).map(project).get();
        Project project1;
        try {
             project1 = projectRepository.save(project);
        }catch (JpaSystemException e){
            throw new ProjectException("project identifier '" + projectIdentifier + "' does not match serial ID '" + project.getId() + "'");
        }
        return modelMapper.map(project1, QueryProjectDTO.class);
    }

    @Override
    public QueryProjectDTO findProjectByIdentifier(String projectIdentifier) {
        Project project = findByProjectIdentifier(projectIdentifier);
        return modelMapper.map(project, QueryProjectDTO.class);
    }

    private Project findByProjectIdentifier(String projectIdentifier){
        return projectRepository.findByProjectIdentifier(Utility.toUpperCaseNullable(projectIdentifier))
                .orElseThrow(() -> new ProjectIdException("Project with identifier: '" + projectIdentifier + "' does not exist"));
    }

    @Override
    public List<QueryProjectDTO> findAllProject() {
        List<QueryProjectDTO> projectDTOList = new ArrayList<>();
        projectRepository.findAll().forEach(project -> projectDTOList.add(modelMapper.map(project, QueryProjectDTO.class)));
        return  projectDTOList;
    }

    @Override
    public String deleteProjectByIdentifier(String projectIdentifier) {
        Project project = findByProjectIdentifier(projectIdentifier);
        if(project != null){
            projectRepository.delete(project);
        }

        return "Project with identifier: '" + projectIdentifier + "' has been deleted";
    }

}
