// https://www.youtube.com/watch?v=Ic4BzVggNY

public class VigenereCipher {

    private static String encrypt(String plainText, String key){

        key = key.toUpperCase();
        String cipherText = "";

        for(int index = 0; index < plainText.length(); index++){

            char currChar = Character.toUpperCase(plainText.charAt(index));
            if( (currChar >= 'A') && (currChar <= 'Z') ){
                
                int originalAlphaPosition = currChar - 'A';
                int newAlphaPosition = (originalAlphaPosition + (key.charAt(index) - 'A')) % 26;
                
                char encryptedAlpha = (char)('A' + newAlphaPosition);
                
                cipherText += encryptedAlpha;
            }
            else
                cipherText += currChar;

        }

        return cipherText;

    }

    private static String decrypt(String cipherText, String key){
        
        key = key.toUpperCase();
        String plainText = "";

        for(int index = 0; index < cipherText.length(); index++){

            char currChar = Character.toUpperCase(cipherText.charAt(index));
            if( (currChar >= 'A') && (currChar <= 'Z') ){
                plainText += (char)((currChar - key.charAt(index) + 26) % 26 + 'A');
            }
            else
                plainText += currChar;

        }

        return plainText;

    }

    public static void main(String[] args) {

        String key = "AVINASH";

        String plainText = "watashiwaavinashdesu";

        key = key.repeat((plainText.length() / key.length()) + 1);

        String encrypted = encrypt(plainText, key);
		String decrypted = decrypt(encrypted, key);

        System.out.println("Plain Text: " + plainText);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
        
    }

}