package System;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    // Attribute
    private final String HASHING_ALGORITHM = "SHA-256";

    /*
     * Method Name : encryptionHandler()
     * Parameters : password
     * Description : method to hash passwords
     */
    public String encryptionHandler(String password) throws NoSuchAlgorithmException {
        // Create a message digest
        // Specify the hashing algorithm for passwords
        MessageDigest algorithm = MessageDigest.getInstance(HASHING_ALGORITHM);

        // Convert the password to an array of byte
        byte[] passwordBytes = algorithm.digest(password.getBytes());

        // Switch the byte[] to BigInteger
        BigInteger convertedBytes = new BigInteger(1, passwordBytes);

        return convertedBytes.toString(16);
    }
}