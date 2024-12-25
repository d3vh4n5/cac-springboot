package com.example.cacSpringBoot.services.interfaces;

import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.dto.response.HelloDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;

import java.util.List;

public interface IUserService {
    public List<UserDto> listUsers();
    public SuccessfullyResponseDto createUser(UserDto userDto);
    public SuccessfullyResponseDto updateUser(String name, UserDto userDto);
    public UserDto listOneUser (ReqNameDto reqNameDto);
    public HelloDto saludar(String name);
}
