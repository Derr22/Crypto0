import sun.misc.HexDumpEncoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoMain {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String s = "AEsdase12";

        Cipher cipher = Cipher.getInstance("AES");

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(256);
        SecretKey key = kgen.generateKey();
        String openkey=key.getEncoded().toString();
//        char[] openkey  = key.getEncoded();
        //byte[] openKey =key.getEncoded();
        System.out.println(openkey);

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(s.getBytes());
        for (byte b : bytes) {
            System.out.print(b);
        }

        System.out.println("\n");

        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decryptCipher.doFinal(bytes);
        for(byte b: decryptedBytes){
            System.out.print((char) b);
        }
    }
}