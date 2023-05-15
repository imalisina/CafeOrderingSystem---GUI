package model;

import java.security.NoSuchAlgorithmException;

import System.Encryptor;
import System.FileHandler;

public class Register extends Updater {
    private String name;
    private String username;
    private String email;
    private String password;
    private FileHandler fileHandler = new FileHandler();
    private Encryptor encryptor = new Encryptor();

    public void setName(String name) {
        this.name = name;
        updateViews();
    }

    public void setUsername(String username) {
        this.username = username;
        updateViews();
    }

    public void setEmail(String email) {
        this.email = email;
        updateViews();
    }

    public void setPassword(String password) {
        this.password = password;
        updateViews();
    }

    // Example: Perform registration logic
    public void register() {

    }

    public boolean authenticate(String name, String username, String email, String password) throws NoSuchAlgorithmException {
        if (!name.isEmpty() && !username.isEmpty() && !email.isEmpty() && (!password.isEmpty() && password.length() >= 8) ) {
            String encryptedPassword = encryptor.encryptionHandler(password); 
            fileHandler.writeOnFile(username, encryptedPassword);
            return true;
        } else {
            return false;
        }
    }

    // Example: Getters for name, username, email, and password

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}