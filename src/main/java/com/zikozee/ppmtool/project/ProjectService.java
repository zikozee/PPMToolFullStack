package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.CreateProjectDTO;
import com.zikozee.ppmtool.project.dto.QueryProjectDTO;
import com.zikozee.ppmtool.project.dto.UpdateProjectDTO;

import java.util.List;

public interface ProjectService {

    QueryProjectDTO createProject(CreateProjectDTO createProjectDTO);

    QueryProjectDTO updateProject(UpdateProjectDTO projectDTO);

    QueryProjectDTO findProjectByIdentifier(String projectIdentifier);

    List<QueryProjectDTO> findAllProject();

    String deleteProjectByIdentifier(String projectIdentifier);
}
