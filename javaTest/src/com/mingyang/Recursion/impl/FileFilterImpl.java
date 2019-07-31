package com.mingyang.Recursion.impl;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()){
            return true;
        }

        return pathname.getName().toLowerCase().endsWith(".docx");
    }
}
