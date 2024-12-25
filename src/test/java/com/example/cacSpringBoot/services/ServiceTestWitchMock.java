package com.example.cacSpringBoot.services;

import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.entities.User;
import com.example.cacSpringBoot.repositories.interfaces.IUserRepository;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTestWitchMock {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Test de listar usuarios con mock")
    void listarUsuarios(){
        // Arrange
        List<User> userListReturn = new ArrayList<>();
        userListReturn.add(new User("Carlitos Testy", 33));
        userListReturn.add(new User("María Mistake", 24));
        userListReturn.add(new User("Leonardo Pifió", 63));

        List<UserDto> expectedList = new ArrayList<>();
        expectedList.add(new UserDto("Carlitos Testy", 33));
        expectedList.add(new UserDto("María Mistake", 24));
        expectedList.add(new UserDto("Leonardo Pifió", 63));
        // Act
        when(userRepository.findAllUsers()).thenReturn(userListReturn);

        List<UserDto> resultList = userService.listUsers();

        // Assert
        Assertions.assertAll(()->{
            Assertions.assertEquals(expectedList.size(), resultList.size());
            Assertions.assertEquals(expectedList.get(0), resultList.get(0));
        });

    }
}
