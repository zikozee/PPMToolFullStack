package com.zikozee.ppmtool.domain.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zikozee.ppmtool.domain.backlog.Backlog;
import com.zikozee.ppmtool.domain.backlog.dto.QueryBacklog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryProjectDTO {

    private Long id;

    private String projectName;

    private String projectIdentifier;

    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    private Date createdAt;

    private Date updatedAt;

    private Backlog projectBacklog;
}
