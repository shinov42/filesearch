package com.company;

import java.io.File;

public class Filesearch {

    public static void godeep(File f, String name_file, int[] flag) {
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                File f1 = new File(files[i] + "\\" + name_file);
                if (f1.exists()) {
                    flag[0] = 1;
                    return;
                } else godeep(files[i], name_file, flag);
            }
        }
    }


    public static void parse(String a) {
        //if a contains a string
        int flag[] = {0, 0};
        a = a.substring(5);
        a += ' ';
        String name = new String();
        name = get_str(a, name);
        String path = new String();
        path = get_str(a, name);
        int jj = path.compareTo("");
        if (jj == 0) {
            gobriefly(name, flag);
            if (flag[0] == 1)
                System.out.println("File exists");
            else System.out.println("File does not exist");
        } else {
            int i = path.compareTo("-r");

            if (i == 0) {
                gobriefly(name, flag);
            } else {
                String key = new String();
                key = get_key(a, name, path);
                int ch = key.compareTo("-r");
                if (ch == 0) {
                    File f = new File(path);
                    godeep(f, name, flag);
                    goshallow(f, name, flag);
                } else {
                    File f = new File(path);
                    goshallow(f, name, flag);
                }

            }
            if (flag[0] == 1)
                System.out.println("File exists");
            else System.out.println("File does not exist");

        }
    }


    private static String get_key(String a, String name, String path) {
        String ab = new String();
        int i = a.length() - 5 - name.length() - path.length();
        ab = a.substring(0, i);
        ab = ab.trim();
        return ab;
    }

    private static String get_str(String ab, String name) {
        ab = ab.substring(0, ab.length() - 1 - name.length());
        ab = ab.trim();
        name = "";
        char[] a = ab.toCharArray();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != ' ') {
                name += a[i];
            } else break;

        }
        String name1 = new String();
        for (int i = name.length() - 1; i >= 0; i--)
            name1 += name.charAt(i);
        return name1;
    }

    public static void goshallow(File f, String name_file, int[] flag) {
        File f1 = new File(f + "\\" + name_file);
        if (f1.exists())
            flag[0] = 1;
        else return;
    }

    public static void gobriefly(String name_file, int[] flag) {
        File f1 = new File(name_file);
        if (f1.exists())
            flag[0] = 1;
        else return;
    }
}
