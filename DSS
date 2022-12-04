import java.security.*;
import java.util.*;

public class DigitalSignatureStandard {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String msg = sc.nextLine();
        // key pair gen
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // private key, signature gen
        PrivateKey privateKey = keyPair.getPrivate();
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);

        byte[] msgInBytes = msg.getBytes();
        sign.update(msgInBytes);
        byte[] signature = sign.sign();
        System.out.println("Signature for the message is: " + new String(signature));
        sc.close();
    }
}
