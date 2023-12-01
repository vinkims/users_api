package com.kigen.Users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class EUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "id")
    private Integer id;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Role is mandatory")
    @Column(name = "role")
    private String role;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + '}';
    }
}
