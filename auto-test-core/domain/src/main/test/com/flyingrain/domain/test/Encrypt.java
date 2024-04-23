package com.flyingrain.domain.test;

import org.testng.annotations.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Encrypt {

    @Test
    public void testAES() throws Exception {
        String content = "原始报文洞的阿斯顿发阿斯顿发生阿萨德分公司癖好【熊 屁USD法时代 管理会计三个地方回家结婚可根据啦设定了拉屎绝代风华 阿斯顿发";

        String secretStr = "Q+9TS2Mm816XtuXkLNYW+DW7pr4adyNQvgBtE/NMP16JQHzQ8c2EIRXtzM7h7RG6slWt5O8Jbv29LLbqTb31pAXDNCKKc5aEwgOLAqM9mnB62BmsLhqSDjdgUjDB+JhkPUNAYQJDFNJtohGgnYoM4B8pAxgTvsllYTja5GYTY/bQv+dUl3QaXPHiFOq0FFZaG0zHmbngm7qtpP0dx2WZs3lCzBb8UaUqpzlDTufXZNCjgdlKokaaNifLmXLwj3ZAjdevMmfohhPjntOURlEMu2PvJH0HQPbfe5PvaFUIXeIjj2bO7sVVmzrI7SCI8zOeAHrVRDoIl5GO4oqEvY663rCGI+Vh2Rd2vcUNgPFKF12LaseIlD/7mCX/H4Oe7SzgG4Zq8d18p/A2mdgjPlZbA+WXxQMrHGgrLMKPLc8hyppmsW0eoSvfDFSGE8FNYl1HQLUoxEK1w9w4Vz6sdhwAVoo3uqOtT3w4+fdQW47SjVIMDcTK8D14aDRdQdqhoDQMydYXj9MY88OTc3H21HDN8LJcJxmumxtmOsSm5MS296dTAlpqT1he/k47qDhTSFnINppkKYAjPB337+WrGp9JNA==";
        String password = "AXEkkFX4sKtR95bW";
        String originStr = decrypt(secretStr, password, password);
        System.out.println(originStr);


    }

    @Test
    public void testDe() throws Exception {
        String encryptedData = "Q+9TS2Mm816XtuXkLNYW+DW7pr4adyNQvgBtE/NMP16JQHzQ8c2EIRXtzM7h7RG6slWt5O8Jbv29LLbqTb31pAXDNCKKc5aEwgOLAqM9mnB62BmsLhqSDjdgUjDB+JhkPUNAYQJDFNJtohGgnYoM4B8pAxgTvsllYTja5GYTY/bQv+dUl3QaXPHiFOq0FFZaG0zHmbngm7qtpP0dx2WZs3lCzBb8UaUqpzlDTufXZNCjgdlKokaaNifLmXLwj3ZAjdevMmfohhPjntOURlEMu2PvJH0HQPbfe5PvaFUIXeIjj2bO7sVVmzrI7SCI8zOeAHrVRDoIl5GO4oqEvY663rCGI+Vh2Rd2vcUNgPFKF12LaseIlD/7mCX/H4Oe7SzgG4Zq8d18p/A2mdgjPlZbA+WXxQMrHGgrLMKPLc8hyppmsW0eoSvfDFSGE8FNYl1HQLUoxEK1w9w4Vz6sdhwAVoo3uqOtT3w4+fdQW47SjVIMDcTK8D14aDRdQdqhoDQMydYXj9MY88OTc3H21HDN8LJcJxmumxtmOsSm5MS296dTAlpqT1he/k47qDhTSFnINppkKYAjPB337+WrGp9JNA==";
        String password = "AXEkkFX4sKtR95bW";
        byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedValue);

        String decryptedData = new String(decryptedBytes, "UTF-8");
        System.out.println(decryptedData);
    }


    public String decrypt(String encrypted, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(original, StandardCharsets.UTF_8);
    }

    public String encrypt(String encrypted, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] original = cipher.doFinal(encrypted.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(original);
    }


    @Test
    public void testEncode() throws Exception {
        String password = "AXEkkFX4sKtR95bW";
        String originStr = "嘻嘻哈哈";
        String encryptStr = encrypt(originStr, password, password);
        System.out.println(encryptStr);
        String result = decrypt(encryptStr, password, password);
        System.out.println(result);
    }
}
