package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = new String();
        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        Filesearch.parse(path);
    }
}

