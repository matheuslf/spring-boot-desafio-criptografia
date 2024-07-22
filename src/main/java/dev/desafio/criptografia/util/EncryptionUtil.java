package dev.desafio.criptografia.util;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    private static final SecretKey SECRET_KEY = generateKey();

    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128);
            return keyGen.generateKey();
        }   
        catch (Exception ex) {
            throw new RuntimeException("Error generating key for encryption", ex);
        }
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
        catch (Exception ex) {
            throw new RuntimeException("Error encrypting data", ex);
        }
    }
    
    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        }
        catch (Exception ex) {
            throw new RuntimeException("Error decrypting data");
        }
    }

}
