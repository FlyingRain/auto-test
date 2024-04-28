package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.tools.FileUploadFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
public class FileUploadFacadeImpl implements FileUploadFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(FileUploadFacadeImpl.class);

    @Override
    public CommonResult<String> upload(InputStream fileInputStream, FormDataContentDisposition fileMetaData) {
        String fileName = fileMetaData.getFileName();
        fileName = URLDecoder.decode(URLDecoder.decode(fileName, StandardCharsets.UTF_8),StandardCharsets.UTF_8);
        logger.info("start to update file:[{}]", fileName);
        String filePath = System.getProperty("user.dir");
        File dic = new File(filePath + File.separator + "uploads");
        if(!dic.exists()){
            dic.mkdirs();
        }
        File f = new File(filePath + File.separator + "uploads" + File.separator + fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.error("create file failed!", e);
                return CommonResult.fail("500", e.getMessage());
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(f)) {

            byte[] temp = new byte[1024];
            while (fileInputStream.read(temp) > 0) {
                outputStream.write(temp);
            }
            outputStream.flush();
            filePath = f.getAbsolutePath();
        } catch (Exception e) {
            logger.error("upload file failed!", e);
            CommonResult.fail("500", e.getMessage());
        }

        return CommonResult.success(filePath);
    }
}
