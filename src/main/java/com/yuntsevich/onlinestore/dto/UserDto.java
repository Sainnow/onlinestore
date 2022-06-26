package com.yuntsevich.onlinestore.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yuntsevich.onlinestore.model.enums.Status;
import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String username;

    private String phone;

    private String password;

    private String email;

    private String gender;

    private Status status;

}
