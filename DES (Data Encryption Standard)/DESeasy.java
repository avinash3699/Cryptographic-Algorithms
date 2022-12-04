import javax.crypto.*;

public class DES {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] text = "Message".getBytes();
        byte[] encryptedText = cipher.doFinal(text);
        System.out.println("Encrpted Text is: " + new String(encryptedText));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedText = cipher.doFinal(encryptedText);
        System.out.println("Decrypted Text: " + new String(decryptedText));
    }
}
