package com.company;

import java.io.File;

public class Filesearch {

    private static void goDeep(File f, String name_file, int[] flag) {
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                File f1 = new File(files[i] + "\\" + name_file);
                if (f1.exists()) {
                    flag[0] = 1;
                    return;
                } else
                    goDeep(files[i], name_file, flag);
            }
        }
    }

    public static boolean start(String a){
        boolean flag = search(a);
        if (flag) return true;
        else return false;
    }

    private static boolean search(String a) {
        int flag[] = {0, 0};
        String sub[] = a.split(" ");
        if (sub[1].equals("-r")) {
            if (sub[2].equals("-d")) {
                File f = new File(sub[3]);
                goShallow(f, sub[4], flag);
                if (flag[0] == 0)
                goDeep(f, sub[4], flag);
            }
        } else if (sub[1].equals("-d")) {
            File f = new File(sub[2]);
            goShallow(f, sub[3], flag);
        }
        else goBriefly(sub[1], flag);
        if (flag[0] == 1)
        return true;
        else return false;
    }

    private static void goShallow(File f, String name_file, int flag[]) {
        File f1 = new File(f + "\\" + name_file);
        if (f1.exists())
            flag[0] = 1;
        else return;
    }

    private static void goBriefly(String name_file, int flag[]) {
        File f1 = new File(name_file);
        if (f1.exists())
            flag[0] = 1;
        else return;
    }
}