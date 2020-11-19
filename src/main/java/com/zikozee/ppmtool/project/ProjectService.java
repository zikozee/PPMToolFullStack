package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO saveOrUpdateProject(ProjectDTO projectDTO);

    ProjectDTO findProjectByIdentifier(String projectIdentifier);

    List<ProjectDTO> findAllProject();

    String deleteProjectByIdentifier(String projectIdentifier);
}
