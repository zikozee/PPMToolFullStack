package com.zikozee.ppmtool.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MapValidationErrorServiceImpl implements MapValidationErrorService {
    @Override
    public ResponseEntity<?> MapValidationService(BindingResult result) {
        if(result.hasErrors()){
            log.info("error: " + result.hasErrors());
            Map<String, String> errorMap = new HashMap<>();
                for(FieldError error: result.getFieldErrors())
                    errorMap.put(error.getField(), error.getDefaultMessage());

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
