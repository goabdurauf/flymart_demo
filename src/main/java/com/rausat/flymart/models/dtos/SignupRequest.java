package com.rausat.flymart.models.dtos;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;


public class SignupRequest {
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9_]{3,}$",
            message = "Username must be at least 3 characters long and contain only letters, numbers, and underscores"
    )
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and contain at least one lowercase letter, one uppercase letter, one digit, and one special character."
    )
    private String password;
    @NotBlank
    @NotEmpty
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Only letters are allowed"
    )
    private String firstName;
    @NotBlank
    @NotEmpty
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Only letters are allowed"
    )
    private String lastName;
    private MultipartFile image;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
