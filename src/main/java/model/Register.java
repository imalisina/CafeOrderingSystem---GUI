package model;

import java.security.NoSuchAlgorithmException;

import System.Encryptor;
import System.FileHandler;

public class Register extends Updater {

    // Define system instances
    private FileHandler fileHandler = new FileHandler();
    private Encryptor encryptor = new Encryptor();

    // Define register operation variables
    private String customerUsername;
    private String customerEmail;
    private String customerFullName;
    private String customerPassword;

    /*
     * Method name : setUsername
     * Parameters : String customerUsername
     * Description : a method to update the username value - setter
     */
    public void setUsername(String customerUsername) {
        this.customerUsername = customerUsername;
        updateViews();
    }

    /*
     * Method name : setEmail
     * Parameters : String customerEmail
     * Description : a method to update the email value - setter
     */
    public void setEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        updateViews();
    }

    /*
     * Method name : setName
     * Parameters : String customerFullName
     * Description : a method to update the name value - setter
     */
    public void setName(String customerFullName) {
        this.customerFullName = customerFullName;
        updateViews();
    }

    /*
     * Method name : setPassword
     * Parameters : String customerPassword
     * Description : a method to update the password value - setter
     */
    public void setPassword(String customerPassword) {
        this.customerPassword = customerPassword;
        updateViews();
    }

    /*
     * Method name : register
     * Parameters : None
     * Description : Default constructor
     */
    public void register() {

    }

    /*
     * Method name : getName
     * Parameters : None
     * Description : a method to retrieve the username value - getter
     */
    public String getName() {
        return customerFullName;
    }

    /*
     * Method name : getUsername
     * Parameters : None
     * Description : a method to retrieve the username value - getter
     */
    public String getUsername() {
        return customerUsername;
    }

    /*
     * Method name : getEmail
     * Parameters : None
     * Description : a method to retrieve the email value - getter
     */
    public String getEmail() {
        return customerEmail;
    }

    /*
     * Method name : getPassword
     * Parameters : None
     * Description : a method to retrieve the password value - getter
     */
    public String getPassword() {
        return customerPassword;
    }

    /*
     * Method name : authenticate
     * Parameters : String customerFullName, String customerUsername, String customerEmail, String customerPassword
     * Description : a method to perform authentication and validation process
     */
    public boolean authenticate(String customerFullName, String customerUsername, String customerEmail, String customerPassword)
            throws NoSuchAlgorithmException {
        if (!customerFullName.isEmpty() && !customerUsername.isEmpty() && !customerEmail.isEmpty()
                && (!customerPassword.isEmpty() && customerPassword.length() >= 8)) {
            String encryptedPassword = encryptor.encryptionHandler(customerPassword);
            fileHandler.writeOnFile(customerUsername, encryptedPassword);
            return true;
        } else {
            return false;
        }
    }
}