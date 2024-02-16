package com.newpiece.infrastructure.dto;

import com.newpiece.domain.User;
import com.newpiece.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private String username;
    @NotBlank(message = "Nombre es requerido")
    private String firstName;
    @NotBlank (message = "Apellido es requerido")
    private String lastName;
    @Email(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank (message = "Dirección es requerido")
    private String address;
    @NotBlank (message = "Celular es requerido")
    private String cellphone;
    @NotBlank (message = "Clave es requerido")
    private String password;

    public User userDtoToUser(){
        return new User(null,this.getEmail(),this.getFirstName(), this.getLastName(),this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }

}
