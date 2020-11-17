package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDTO saveOrUpdateProject(ProjectDTO projectDTO) {

        Project project = modelMapper.map(projectDTO, Project.class);
        return modelMapper.map(projectRepository.save(project), ProjectDTO.class);
    }

}
