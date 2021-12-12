package com.demo;

import java.io.*;
import java.util.Scanner;

public class Orders {
    Scanner sc = new Scanner(System.in);

    Orders() {

    }

    void readFile() {
        try {
            File folder = new File("management\\src\\main\\java\\com\\demo\\database\\orders");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Product orderItem[] = new Product[0];
                    int lines = 0;
                    try {
                        Scanner reader = new Scanner(file);

                        // How many item ?
                        while (reader.hasNextLine()) {
                            lines++;
                            reader.nextLine();
                        }
                        reader.close();

                        // Write data
                        orderItem = new Product[lines];
                        reader = new Scanner(file);
                        int index = 0;
                        while (reader.hasNextLine()) {
                            String temp = reader.nextLine();
                            String[] arrOfStr = temp.split("/");
                            orderItem[index] = new Product(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3],
                                    arrOfStr[4], Long.parseLong(arrOfStr[5]));
                            index++;
                        }
                        reader.close();
                        System.out.println(file.getName() + "\n");
                        printList(orderItem);
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }
                }
            }
        } finally {

        }
    }

    void readFile(String nameToSearch) {
        try {
            File folder = new File("management\\src\\main\\java\\com\\demo\\database\\orders");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Product orderItem[] = new Product[0];
                    int lines = 0;
                    String arrOfStrFile[] = file.getName().split("_");
                    if (arrOfStrFile[0].equalsIgnoreCase(nameToSearch)) {
                        try {
                            Scanner reader = new Scanner(file);

                            // How many item ?
                            while (reader.hasNextLine()) {
                                lines++;
                                reader.nextLine();
                            }
                            reader.close();

                            // Write data
                            orderItem = new Product[lines];
                            reader = new Scanner(file);
                            int index = 0;
                            while (reader.hasNextLine()) {
                                String temp = reader.nextLine();
                                String[] arrOfStr = temp.split("/");
                                orderItem[index] = new Product(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3],
                                        arrOfStr[4], Long.parseLong(arrOfStr[5]));
                                index++;
                            }
                            reader.close();
                            System.out.println(file.getName() + "\n");
                            printList(orderItem);
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                        }
                    }
                }
            }
        } finally {
            // System.out.println("An error occurred.");
        }
    }

    void printList(Product productList[]) {
        long price = 0;
        System.out.printf("%-8s%-18s%-18s%-18s%-32s%s\n", "STT", "ID", "Loai hang", "hang", "Ten", "Gia");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < productList.length; i++) {
            System.out.printf("%-8s%-18s%-18s%-18s%-32s%d\n",
                    i + 1,
                    productList[i].getProductId(),
                    productList[i].getType(),
                    productList[i].getBrand(),
                    productList[i].getName(),
                    productList[i].getPrice());
            price += productList[i].getPrice();
            System.out.println();
        }
        System.out.println(
                "=====================================================================================================================");
        System.out.printf("%94s%d\n", "Tong: ", price);
    }

    void deleteOrder() {
        System.out.println("Nhap order muon xoa: ");
        System.out.print("Dinh dang <ten>_<ngay tao don>_<gio tao don>:  ");
        String order = (sc.nextLine() + ".txt");
        File folder = new File("src\\main\\java\\com\\demo\\database\\orders");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (file.getName().equalsIgnoreCase(order)) {
                    if (file.delete()) {
                        System.out.println("Delete order " + file.getName());
                        break;
                    }
                }
            }
        }
    }

    void printUserMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Xem cac don dat hang                                    *");
        System.out.println("*   2. Huy don dat hang                                        *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void printAdminMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Xem dat hang theo ten                                   *");
        System.out.println("*   2. Xem tat ca cac don da dat hang                          *");
        System.out.println("*   3. Xoa don dat hang                                        *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void initUser() {
        printUserMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    System.out.print("Nhap ho va ten: ");
                    String name = sc.nextLine();
                    readFile(name);
                    break;
                case 2:
                    deleteOrder();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void initAdmin() {
        printAdminMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    System.out.print("Nhap ho va ten: ");
                    String name = sc.nextLine();
                    readFile(name);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    deleteOrder();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

}
