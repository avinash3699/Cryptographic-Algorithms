// https://www.youtube.com/watch?v=JtbKh_12ctg
// https://www.youtube.com/watch?v=na5rapg1XsI

public class CaesarCipher
{
    
    private static String encrypt(String plainText, int shiftValue){
        
        String cipherText = "";
        
        for(int index = 0; index < plainText.length(); index++){
            
            char currChar = plainText.charAt(index);
            if(currChar != ' '){
                
                char firstAlpha;
                if(Character.isUpperCase(currChar))
                    firstAlpha = 'A';
                else 
                    firstAlpha = 'a';
                
                int originalAlphaPosition = currChar - firstAlpha;
                int newAlphaPosition = (originalAlphaPosition + shiftValue) % 26;
                
                char encryptedAlpha = (char)(firstAlpha + newAlphaPosition);
                
                cipherText += encryptedAlpha;
                
            }
            else 
                cipherText += ' ';
        }
        
        return cipherText;
        
    }
    
    private static String decrypt(String cipherText, int shiftValue){
        return encrypt(cipherText, shiftValue);
    }
    
    public static void main(String[] args) {

	String plainText = "aBcDeFgHiJKLMNOPQRSTUVW xyz";

	String encrypted = encrypt(plainText, 3);
	String decrypted = decrypt(encrypted, 26 - 3);

	System.out.println("Plain Text: " + plainText);
	System.out.println("Encrypted Text: " + encrypted);
	System.out.println("Decrypted Text: " + decrypted);

    }
}
