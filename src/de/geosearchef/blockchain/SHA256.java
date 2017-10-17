package de.geosearchef.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Geosearchef on 17.10.2017.
 */
public class SHA256 {

    private static MessageDigest digest;
    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] hash(byte[] data) {
        return digest.digest(data);
    }
}
