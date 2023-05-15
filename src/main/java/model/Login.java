package model;

import java.security.NoSuchAlgorithmException;

import System.Encryptor;
import System.FileHandler;

public class Login extends Updater {
    private String username;
    private String password;

    private FileHandler fileHandler = new FileHandler();
    private Encryptor encryptor = new Encryptor();

    public void setUsername(String username) {
        this.username = username;
        updateViews();
    }

    public void setPassword(String password) {
        this.password = password;
        updateViews();
    }

    // Example: Perform login authentication logic
    public boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
        String hashedPassword = encryptor.encryptionHandler(password);
        System.out.println(hashedPassword);
        if (username.equals(fileHandler.readFromFile("UsernameData")) 
            || hashedPassword.equals(fileHandler.readFromFile("PasswordData"))) {
            System.out.println("yes");
            return true;
        } else {
            System.out.println("no");
            return false;
        }
    }

    // Example: Getters for username and password

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
