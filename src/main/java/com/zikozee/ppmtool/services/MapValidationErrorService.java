package com.zikozee.ppmtool.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationErrorService {

    ResponseEntity<?> MapValidationService(BindingResult result);
}
