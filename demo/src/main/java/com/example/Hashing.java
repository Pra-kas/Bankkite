package com.example;
import java.security.MessageDigest;;

public class Hashing{
    public static String hashing(String password) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encoded = messageDigest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : encoded) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}