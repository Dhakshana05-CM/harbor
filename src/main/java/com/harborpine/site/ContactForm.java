package com.harborpine.site;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @NotBlank(message = "Enter your name.")
    @Size(max = 80, message = "Keep your name under 80 characters.")
    private String name;

    @NotBlank(message = "Enter your email address.")
    @Email(message = "Enter a valid email address, like name@company.com.")
    private String email;

    @NotBlank(message = "Tell us a little about what you need.")
    @Size(min = 10, max = 2000, message = "Write between 10 and 2000 characters.")
    private String message;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
