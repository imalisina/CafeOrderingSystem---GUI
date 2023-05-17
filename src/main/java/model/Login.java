package model;

import java.security.NoSuchAlgorithmException;

import System.Encryptor;
import System.FileHandler;

public class Login extends Updater {
    // Define system instances
    private FileHandler fileHandler = new FileHandler();
    private Encryptor encryptor = new Encryptor();

    // Define variables
    private String customerPassword;
    private String customerUsername;

    /*
     * Method name : setUsername
     * Parameters : String customerUsername
     * Description : a setter method to update the username value
     */
    public void setUsername(String customerUsername) {
        this.customerUsername = customerUsername;
        updateViews();
    }

    /*
     * Method name : setPassword
     * Parameters : String customerPassword
     * Description : a setter method to update the password value
     */
    public void setPassword(String customerPassword) {
        this.customerPassword = customerPassword;
        updateViews();
    }

    /*
     * Method name : authenticate
     * Parameters : String customerUsername, String customerPassword
     * Description : method to validate and perform authentication operation
     */
    public boolean authenticate(String customerUsername, String customerPassword) throws NoSuchAlgorithmException {
        String hashedPassword = encryptor.encryptionHandler(customerPassword);
        if (customerUsername.equals(fileHandler.readFromFile("UsernameData"))
                || hashedPassword.equals(fileHandler.readFromFile("PasswordData"))) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Method name : getUsername
     * Parameters : None
     * Description : method to retrieve username value
     */
    public String getUsername() {
        return customerUsername;
    }

    /*
     * Method name : getPassword
     * Parameters : None
     * Description : method to retrieve password value
     */
    public String getPassword() {
        return customerPassword;
    }
}
