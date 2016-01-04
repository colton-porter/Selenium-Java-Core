package com.orasi.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Adam on 1/3/2016.
 */
public class FileSystem {

    public static void DeleteFile(String Path){

        File f1=new File(Path);
        RandomAccessFile raf= null;
        try {
            raf = new RandomAccessFile(f1,"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f1.delete();

    }

}
