package utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPasword {
    
    /**
     * Método encargado de avaliar o contrasinal dun usuario
     * 
     * @param password -> Constrasinal a avaliar
     * @return -> String co hash do contrasinal
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
