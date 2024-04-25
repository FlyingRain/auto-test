package com.flyingrain.autotest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.model.AutoTestAES;
import com.flyingrain.autotest.facade.intf.model.AutoTestEncryptDecrypt;
import com.flyingrain.autotest.facade.intf.tools.EncryptDecryptFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AESAlgorithmFacadeImpl implements EncryptDecryptFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(AESAlgorithmFacadeImpl.class);

    @Override
    public CommonResult<String> decryptAES(AutoTestAES autoTestAES) {
        logger.info("start to decrypt AES:[{}]", autoTestAES);
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(autoTestAES.getKey().getBytes(StandardCharsets.UTF_8), "AES");
            if (StringUtils.hasText(autoTestAES.getIv())) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(autoTestAES.getIv().getBytes(StandardCharsets.UTF_8));
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            }
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(autoTestAES.getEncryptStr()));
            return CommonResult.success(new String(original, StandardCharsets.UTF_8));
        } catch (Exception e) {
            logger.error("decrypt happen error!", e);
        }
        return CommonResult.fail("599", "解密失败");
    }

    @Override
    public CommonResult<String> encryptAES(AutoTestAES autoTestAES) {
        logger.info("start to encrypt aes:[{}]", autoTestAES);
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(autoTestAES.getKey().getBytes(StandardCharsets.UTF_8), "AES");
            if (StringUtils.hasText(autoTestAES.getIv())) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(autoTestAES.getIv().getBytes(StandardCharsets.UTF_8));
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            }
            byte[] original = cipher.doFinal(getOriginString(autoTestAES.getOriginStr()).getBytes(StandardCharsets.UTF_8));
            return CommonResult.success(Base64.getEncoder().encodeToString(original));
        } catch (Exception e) {
            logger.error("encrypt data failed!", e);
            return CommonResult.fail("598", e.getMessage());
        }
    }

    @Override
    public CommonResult<String> base64Encode(AutoTestEncryptDecrypt autoTestEncryptDecrypt) {
        logger.info("base64 encode :[{}]",autoTestEncryptDecrypt);
        Object strObj = autoTestEncryptDecrypt.getOriginStr();
        String originStr = null;
        if (strObj instanceof String) {
            originStr = strObj.toString();
        } else {
            originStr = JSONObject.toJSONString(originStr);
        }
        return CommonResult.success(Base64.getEncoder().encodeToString(originStr.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public CommonResult<String> base64Decode(AutoTestEncryptDecrypt autoTestEncryptDecrypt) {
        logger.info("base64 decode :[{}]",autoTestEncryptDecrypt);

        byte[] data = Base64.getDecoder().decode(autoTestEncryptDecrypt.getEncryptStr());
        return CommonResult.success(new String(data, StandardCharsets.UTF_8));
    }

    @Override
    public CommonResult<String> urlEncode(AutoTestEncryptDecrypt autoTestEncryptDecrypt) {
        logger.info("url encode :[{}]",autoTestEncryptDecrypt);
        Object strObj = autoTestEncryptDecrypt.getOriginStr();
        String originStr = null;
        if (strObj instanceof String) {
            originStr = strObj.toString();
        } else {
            originStr = JSONObject.toJSONString(originStr);
        }
        String encodeStr = URLEncoder.encode(originStr, StandardCharsets.UTF_8);
        return CommonResult.success(encodeStr);
    }

    @Override
    public CommonResult<String> urlDecode(AutoTestEncryptDecrypt autoTestEncryptDecrypt) {
        logger.info("url decode :[{}]",autoTestEncryptDecrypt);

        String decodeStr = URLDecoder.decode(autoTestEncryptDecrypt.getEncryptStr(), StandardCharsets.UTF_8);
        return CommonResult.success(decodeStr);
    }

    private String getOriginString(Object originStr) {
        if (originStr instanceof String) {
            return originStr.toString();
        } else {
            return JSONObject.toJSONString(originStr);
        }
    }
}
