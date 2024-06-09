package com.icodeap.ecommerce.infrastructure.dto;

import com.icodeap.ecommerce.domain.models.User;
import com.icodeap.ecommerce.domain.models.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    String username;
    @NotBlank (message = "Nombre es requerido")
    String firstName;
    @NotBlank (message = "Apellido es requerido")
    String lastName;
    @Email(message = "Debe ingresar un email valido")
    String email;
    @NotBlank (message = "Dirección es requerido")
    String address;
    @NotBlank (message = "Celular es requerido")
    String cellphone;
    @NotBlank (message = "Clave es requerido")
    String password;

    public User userDtoToUser(){
        return new User(null,this.getEmail(),this.getFirstName(), this.getLastName(),this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}
