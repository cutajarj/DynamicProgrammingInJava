package com.cutajarjames.dynamicprogramming.recursion;

import java.io.File;

public class FileSearch {
    public boolean search(File file, String filename) {
        System.out.println("checking: " + file);
        if (file.getName().equals(filename)) {
            System.out.println("Found " + filename + " in " + file);
            return true;
        }
        if (file.isFile()) return false;
        for (File f : file.listFiles()) {
            boolean found = search(f, filename);
            if (found) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        new FileSearch().search(new File("c:/tools"), "gawk.sh");
    }
}
