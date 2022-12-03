import java.util.Scanner;

public class RailFenceCipher {
    
    private static String encrypt(String plainText, int depth){
        
        int row = 0, col = 0;
        int R = depth, C = plainText.length();
        boolean directionDown = false;
        
        char[][] matrix = new char[R][C];
        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                matrix[r][c] = '*';
        
        // constructing the rail fence matrix
        for(int index = 0; index < plainText.length(); index++){
            
            matrix[row][col++] = plainText.charAt(index);

            if( (row == 0) || (row == R-1) )
                directionDown = !directionDown;
                
            if(directionDown) row++;
            else row--;
                
        }
        
        //  constructing the cipher text from the matrix
        String cipherText = "";
        for(row= 0; row < R; row++){
            for(col = 0; col < C; col++){
                if(matrix[row][col] != '*')
                    cipherText += matrix[row][col];
            }
        }
        
        return cipherText;
        
    }
    
    private static String decrypt(String cipherText, int depth){
        
        int row = 0, col = 0;
        int R = depth, C = cipherText.length();
        boolean directionDown = false;
        
        char[][] matrix = new char[R][C];
        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                matrix[r][c] = '*';
                
        for(int index = 0; index < cipherText.length(); index++){
            
            matrix[row][col++] = '-';

            if( (row == 0) || (row == R-1) )
                directionDown = !directionDown;
                
            if(directionDown) row++;
            else row--;
                
        }
        
        int ind = 0;
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(matrix[r][c] == '-')
                    matrix[r][c] = cipherText.charAt(ind++);
            }
        }
        
        String decryptedText = "";
        
        row = 0; col = 0; directionDown = false;
        for(int index = 0; index < cipherText.length(); index++){
            
            if(matrix[row][col] != '*')
                decryptedText += matrix[row][col++];
            
            if( (row == 0) || (row == R-1) )
                directionDown = !directionDown;
                
            if(directionDown) row++;
            else row--;
            
        }
        
        return decryptedText;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the plain text: ");
        String plainText = sc.nextLine();
        System.out.print("Enter key(depth): ");
        int depth = sc.nextInt();
        
        String encryptedText = encrypt(plainText, depth);
        String decryptedText = decrypt(encryptedText, depth);
        
        System.out.println("Plain Text: " + plainText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}