package com.demo;

import java.io.*;
import java.util.Scanner;

public class Revenue {
    static long revenue = 0;
    Revenue(long checkout) {
        revenue += checkout;
    }

    Revenue() {

    }


    void readFile() {
        try {
            File folder = new File("management\\src\\main\\java\\com\\demo\\database\\orders");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        Scanner reader = new Scanner(file);
                        while (reader.hasNextLine()) {
                            String temp = reader.nextLine();
                            String[] arrOfStr = temp.split("/");
                            revenue += Long.parseLong(arrOfStr[5]);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }
                }
            }
        } finally {

        }
    }

    long getRevenue() {
        return revenue;
    }
}
