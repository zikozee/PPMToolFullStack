package com.zikozee.ppmtool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ProjectExceptionResponse {

    private String projectIdentifier; // this is what will show up in the exception as field

}
