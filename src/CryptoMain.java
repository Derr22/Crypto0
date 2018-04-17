import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;



public class CryptoMain {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String s = "AEsdase12";

        Cipher cipher = Cipher.getInstance("AES");

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(256);
        SecretKey key = kgen.generateKey();

        //--------I DID IT------------------------------------//
        String openKey = HexBin.encode(key.getEncoded());
        System.out.println(openKey);
        System.out.println("\n");
        //----------------------------------------------------//

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(s.getBytes());
        for (byte b : bytes) {
            System.out.print(b);
        }

        System.out.println("\n");

        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decryptCipher.doFinal(bytes);
        for (byte b : decryptedBytes) {
            System.out.print((char) b);
        }
        }
    }
