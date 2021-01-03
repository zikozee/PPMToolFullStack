package com.zikozee.ppmtool.domain.backlog.dto;

import com.zikozee.ppmtool.base.BaseDTO;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryBacklog extends BaseDTO {

    private Integer ptSequence = 0;
    private String projectIdentifier;
//    private Project project; this will be ignored
}