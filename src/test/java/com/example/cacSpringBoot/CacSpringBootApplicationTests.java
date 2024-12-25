package com.example.cacSpringBoot;

import com.example.cacSpringBoot.controllers.Controller;
import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacSpringBootApplicationTests {

	@Autowired
	IUserService userService;

//	@AfterAll
//	@AfterEach
//	@BeforeAll
//	@BeforeEach
	void setup(){

	}

	@Test
	@DisplayName("Prueba la correcta creación de un user")
	void createUserTest() {
		// Arrange
		String name = "Juan";
		int age = 44;
		String expectedResult = "Usuario creado correctamente!";
		// Act
		SuccessfullyResponseDto result = userService.createUser(new UserDto(name, age));
		// Assert
		Assertions.assertEquals(expectedResult, result.getMessage());
	}

	/*  Pruebas Unitarias:

	 * Fast
	 * Independent
	 * Repeatable (ej, usar el to date en lugar de una hora fija)
	 * Self Validating -> Tiene que dar un resultado claro
	 * Timely -> Oportuno, las pruebas deben realizarse lo antes posible y antas de que el codigo llegue a producción
	 */

	/*
	* assertAll
	* assertEquals(3, 8)
	* assertNotEquals(3, 5)
	* assertTrue(true)
	* assertFalse
	* assertNull
	* assertNotNull
	* assertNotSame(obj1, obj2)
	* assertThrows
	* */


}
