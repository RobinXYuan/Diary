package com.gooddiary.diary.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
public class NewUserRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
