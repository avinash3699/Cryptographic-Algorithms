import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES {
    
    public static void main(String[] args) {
        
        try{
            // generating the secret key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();

            // getting the DES cipher instance 
            Cipher DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // initializing the DES cipher with ENCRYPT_MODE for 'encryption'
            DESCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // converting the plain text to byte format
            byte[] plainText = "This is a Secret Information".getBytes();

            System.out.println("Plain Text: " + new String(plainText));

            byte[] encryptedText = DESCipher.doFinal(plainText);

            // System.out.println("Encrypted Text: " + new String(encryptedText));

            // initializing the DES cipher with DECRYPT_MODE for 'decryption'
            DESCipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedText = DESCipher.doFinal(encryptedText);

            System.out.println("Decrypted Text: " + new String(decryptedText));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}