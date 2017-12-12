package com.web.emailOS.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class ReadFile {
    private static Properties prop = null;

    static {
        prop = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(ReadFile.class.getClassLoader().getResource("file.properties").getPath()));
            prop.load(in);
        } catch(Exception e) {
            System.out.println("读取属性文件异常："+e);
        }
    }

    /**
     * 读取console-sso.properties
     * @param key
     * @return value
     */
    public static String readFile(String key) {
        String value = "";
        try{
//            System.out.println(key+"::>>"+prop.getProperty(key));
            value = prop.getProperty(key);
        } catch(Exception e) {
            System.out.println("读取属性文件异常："+e);
        }
        return value;
    }
}
