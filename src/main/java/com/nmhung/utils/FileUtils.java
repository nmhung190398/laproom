package com.nmhung.utils;

import com.nmhung.config.FileConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    public static FileInputStream readFile(String pathname) throws FileNotFoundException {
        String filePath = pathname;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        return inStream;
    }
    public static boolean writeFile(){
        return false;
    }
    public static String getFullPathname(String name){
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
        return FileConfig.PATHNAME_SAVE + "\\" + name + "-" + dateFormat.format(new Date()) + FileConfig.MIME_EXCEL;
    }

}
