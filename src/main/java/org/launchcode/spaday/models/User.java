package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {

    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 15, message = "Username must be between 5 to 15 characters.")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @NotBlank(message = "Verify Password is required.")
    private String verify;

    public User(){
    }

    public User(String username, String email, String password, String verify) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getPassword() {
        return password;
    }

    public String getVerify() {
        return verify;
    }

    public Boolean checkPasswords(){
        return Objects.equals(password, verify);
    }
}
