package com.example.icare.exception;

import com.example.icare.constant.MessageConstant;
import com.example.icare.dto.api.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BusinessRuntimeException.class)
    public ResponseEntity<ResponseDTO> handleBusinessRuntimeException(HttpServletRequest request, BusinessRuntimeException ex) {
        LOGGER.error("Request url: {}",request.getRequestURI(), ex);
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(MessageConstant.STATUS_500);
        response.setErrorCode(ex.getErrorCode());
        response.setMessage(ex.getMessage());
        return ResponseEntity.ok().body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGlobalException(HttpServletRequest request, Exception ex) {
        LOGGER.error("Request method: {}, url: {}, exception {}",request.getMethod(), request.getRequestURI(), ex);
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(MessageConstant.STATUS_500);
        response.setMessage(MessageConstant.MESSAGE_ERR_001);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        LOGGER.error("Request method: {}, url: {}, exception {}",request.getMethod(), request.getRequestURI(), ex);
        HashMap<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, replacement) -> existing, HashMap::new));

        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(MessageConstant.STATUS_500);
        response.setErrorCode(MessageConstant.CODE_ERR_002);
        response.setMessage(MessageConstant.MESSAGE_ERR_002);
        response.setData(errors);
        return ResponseEntity.badRequest().body(response);
    }

}
