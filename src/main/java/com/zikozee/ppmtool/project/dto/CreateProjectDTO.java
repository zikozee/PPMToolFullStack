package com.zikozee.ppmtool.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProjectDTO {

    private Long id;

    @NotBlank(message = "Project Name is required")
    private String projectName;

    @NotBlank(message = "Project Identifier Name is required")
    @Size(min = 4, max= 5, message = "Please use 4 to 5 characters")
    private String projectIdentifier;

    @NotEmpty(message = "Project description is required")
    private String description;

    @NotNull(message = "enter a valid start date")
    @JsonFormat(pattern = "yyyy-mm-dd")  // remember it returns time buh we are truncating it
    private Date startDate;

    @NotNull(message = "enter a valid end date")
    @JsonFormat(pattern = "yyyy-mm-dd")  // remember it returns time buh we are truncating it
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd")  // remember it returns time buh we are truncating it
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-mm-dd")  // remember it returns time buh we are truncating it
    private Date updatedAt;
}
