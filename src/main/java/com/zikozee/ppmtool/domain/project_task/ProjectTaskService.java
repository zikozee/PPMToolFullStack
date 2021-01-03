package com.zikozee.ppmtool.domain.project_task;

import com.zikozee.ppmtool.domain.project_task.dto.CreateProjectTaskDTO;
import com.zikozee.ppmtool.domain.project_task.dto.ProjectTaskDTO;

public interface ProjectTaskService {

    ProjectTaskDTO addProjectTask(String projectIdentifier, CreateProjectTaskDTO createProjectTaskDTO);
}
