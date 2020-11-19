package com.zikozee.ppmtool.project.dto;

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

    private Date startDate;

    private Date endDate;

    private Date createdAt;

    private Date updatedAt;
}
