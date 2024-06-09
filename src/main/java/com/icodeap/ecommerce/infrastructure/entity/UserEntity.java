package com.icodeap.ecommerce.infrastructure.entity;

import com.icodeap.ecommerce.domain.models.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
     String userName;
     String firstName;
     String lastName;
     String email;
     String address;
     String cellphone;
     String password;
    @Enumerated(EnumType.STRING)
     UserType userType;
     LocalDateTime dateCreated;

}
