package com.example.lx.listfragment;

import android.util.Base64;
import android.util.Base64InputStream;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author
 * @date 2018/3/7
 */

public class DataAlgorthmUtils {

    private static byte[] iv = {1, 2, 3, 4};

    /**
     * @param key    私钥
     * @param string 加密對象
     * @return Base64编码
     */
    public static String stringEncryptByDes(String key, String string) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "DES");
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encodeString = cipher.doFinal(string.getBytes());
            byte[] base64 = Base64.encode(encodeString, Base64.DEFAULT);
            return new String(base64, "UTF-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param key    私钥
     * @param string 解密對象
     * @return String
     */
    public static String stringDecryptByDes(String key, String string) {
        byte[] base64 = Base64.decode(string, Base64.DEFAULT);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "DES");
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            byte[] decryptedData = cipher.doFinal(base64);
            return new String(decryptedData);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | BadPaddingException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return "";
    }

}