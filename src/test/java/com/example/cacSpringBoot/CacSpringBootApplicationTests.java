package com.example.cacSpringBoot;

import com.example.cacSpringBoot.controllers.Controller;
import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;
import com.example.cacSpringBoot.entities.User;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacSpringBootApplicationTests {

	@Autowired // inyecto dependencia
	IUserService userService;

//	@AfterAll
//	@AfterEach
//	@BeforeAll
//	@BeforeEach
	void setup(){}

	@Test
	@DisplayName("Successfully Created User")
	void createUserTest() {
		// Arrange
		UserDto userDto = new UserDto("Juan", 33);
		SuccessfullyResponseDto expectedResult = new SuccessfullyResponseDto("Usuario creado correctamente!");
		// Act
		SuccessfullyResponseDto result = userService.createUser(userDto);
		// Assert
		Assertions.assertEquals(expectedResult.getMessage(), result.getMessage());
		Assertions.assertEquals(expectedResult, result); // no falla por el @Data de los DTO, porque les redefine el equals

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
