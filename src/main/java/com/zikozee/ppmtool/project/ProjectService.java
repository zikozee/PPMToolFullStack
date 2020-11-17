package com.zikozee.ppmtool.project;

import com.zikozee.ppmtool.project.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO saveOrUpdateProject(ProjectDTO projectDTO);
}
