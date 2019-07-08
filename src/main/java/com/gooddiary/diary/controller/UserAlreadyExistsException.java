package com.gooddiary.diary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Email Has Already Registered")
@Getter
@AllArgsConstructor
public class UserAlreadyExistsException extends RuntimeException {
    private BindingResult message;
}
