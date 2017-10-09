package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = new String();
        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        boolean i = Filesearch.start(path);
        if (i) System.out.println("File exists");
        else System.out.println("File does not exist");

    }
}