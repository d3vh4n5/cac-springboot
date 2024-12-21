package com.example.cacSpringBoot.services;

import com.example.cacSpringBoot.dto.UserDto;
import com.example.cacSpringBoot.dto.request.ReqNameDto;
import com.example.cacSpringBoot.dto.response.SuccessfullyResponseDto;
import com.example.cacSpringBoot.entities.User;
import com.example.cacSpringBoot.exceptions.InvalidJsonException;
import com.example.cacSpringBoot.exceptions.UserNotFoundException;
import com.example.cacSpringBoot.repositories.interfaces.IUserRepository;
import com.example.cacSpringBoot.repositories.UserRepository;
import com.example.cacSpringBoot.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    // Logica de negocio

    //Inyección de dependecias
    // Tiene que ser un componente de Spring para que funcione
    IUserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // Otra forma de hacer la inyección de dependecias es usando @Autowired, pero no es recomendada

    @Override
    public List<UserDto> listUsers() {
        // solicitarle al repo todos los usuarios
        List<User> userList = userRepository.findAllUsers();
        // transformar la lista de User en lista de UserDto
        return userList
                .stream()
                .map(user ->
                        new UserDto( user.getName(), user.getEdad() )
                )
                .toList();
    }

    @Override
    public SuccessfullyResponseDto createUser(UserDto userDto) {
        // Transformar el userDto en User
        User user = new User(userDto.getName(), userDto.getEdad());
        // Llamar repo para guardarlo
        userRepository.saveUser(user);
        // Crear la respuesta
        SuccessfullyResponseDto created = new SuccessfullyResponseDto("Usuario creado correctamente!");
        return created;
    }

    @Override
    public SuccessfullyResponseDto updateUser(String name, UserDto userDto) {
        // encontrar el usuario
            int targetIndex = userRepository.findIndex(name);

            if (targetIndex == -1) throw new UserNotFoundException("Usuario "+name+" no existe en la base de datos");
        // modificarlo
            if (userDto.getEdad() == 0 || userDto.getName() == null) throw new InvalidJsonException("Invalid Body");
            User modifiedUser = new User(userDto.getName(),userDto.getEdad());
        // guardar el usuario modificado
            userRepository.updateUser(targetIndex, modifiedUser);
        // crear respuesta
        return new SuccessfullyResponseDto("Usuario actualizado con éxito");
    }

    @Override
    public UserDto listOneUser(ReqNameDto reqNameDto) {
        Optional<User> userOptional = userRepository.findOne(reqNameDto);

        if (userOptional.isEmpty()) throw new UserNotFoundException("User not found in database");

        User user = userOptional.get();

        return new UserDto(
                user.getName(),
                user.getEdad()
        );
    }


}
