package com.flyingrain.autotest.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);

    public static List<Class<?>> scanPackages(String packageName) {
        try {
            String packagePath = packageName.replaceAll("\\.", "/");
            List<Class<?>> allClasses = new ArrayList<>();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String classPath = classLoader.getResource(packagePath).getFile();
            File pageDirectory = new File(classPath);
            if (pageDirectory.exists() && pageDirectory.isDirectory()) {
                File[] files = pageDirectory.listFiles();
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile() && fileName.endsWith(".class")) {
                        String className = packageName + "." + fileName.substring(0, fileName.lastIndexOf("."));
                        Class<?> cls = Class.forName(className);
                        allClasses.add(cls);
                    }
                }
            }
            return allClasses;
        } catch (Exception e) {
            logger.error("load service failed!", e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
