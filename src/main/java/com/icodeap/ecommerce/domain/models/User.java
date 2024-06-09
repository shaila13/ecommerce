package com.icodeap.ecommerce.domain.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
     Integer id;
     String userName;
     String firstName;
     String lastName;
     String email;
     String address;
     String cellphone;
     String password;
     UserType userType;
     LocalDateTime dateCreated;


}
