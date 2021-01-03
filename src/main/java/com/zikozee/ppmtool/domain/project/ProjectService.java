package com.zikozee.ppmtool.domain.project;

import com.zikozee.ppmtool.domain.project.dto.CreateProjectDTO;
import com.zikozee.ppmtool.domain.project.dto.QueryProjectDTO;
import com.zikozee.ppmtool.domain.project.dto.UpdateProjectDTO;

import java.util.List;

public interface ProjectService {

    QueryProjectDTO createProject(CreateProjectDTO createProjectDTO);

    QueryProjectDTO updateProject(UpdateProjectDTO projectDTO);

    QueryProjectDTO findProjectByIdentifier(String projectIdentifier);

    List<QueryProjectDTO> findAllProject();

    String deleteProjectByIdentifier(String projectIdentifier);
}
