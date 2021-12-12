package com.demo;

import java.util.Scanner;
import java.util.Arrays;

public class FilterAndSort {
    Scanner sc = new Scanner(System.in);

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Tim theo gia san pham tang dan                          *");
        System.out.println("*   2. Tim theo gia san pham giam dan                          *");
        System.out.println("*   3. Tim kiem san pham theo ten                              *");
        System.out.println("*   4. Hien menu                                               *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void init(Product[] productList) {
        printMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    printList(sortArrayAccending(sortList(productList)));
                    break;
                case 2:
                    printList(sortArrayDescending(sortList(productList)));
                    break;
                case 3:
                    printList(filterList(productList));
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void printList(Product productList[]) {
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
            System.out.println();
        }
    }

    Product[] filterList(Product productList[]) {
        Product filteredList[] = new Product[0];
        String userInput;
        System.out.print("Nhap ten san pham can tim: ");
        userInput = sc.nextLine();
        if (userInput.equalsIgnoreCase("Monitor") || userInput.equalsIgnoreCase("man hinh")) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].getType().equalsIgnoreCase("Monitor")) {
                    filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                    filteredList[filteredList.length - 1] = productList[i];
                }
            }
        }
        if (userInput.equalsIgnoreCase("ban phim") || userInput.equalsIgnoreCase("Keyboard")) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].getType().equalsIgnoreCase("Keyboard")) {
                    filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                    filteredList[filteredList.length - 1] = productList[i];
                }
            }
        }
        if (userInput.equalsIgnoreCase("chuot may tinh") || userInput.equalsIgnoreCase("Mouse")) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].getType().equalsIgnoreCase("Mouse")) {
                    filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                    filteredList[filteredList.length - 1] = productList[i];
                }
            }
        }
        if (userInput.equalsIgnoreCase("May tinh xach tay") || userInput.equalsIgnoreCase("Laptop")) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].getType().equalsIgnoreCase("Laptop")) {
                    filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                    filteredList[filteredList.length - 1] = productList[i];
                }
            }
        }
        if (userInput.equalsIgnoreCase("Case May tinh") || userInput.equalsIgnoreCase("CasePC")) {
            for (int i = 0; i < productList.length; i++) {
                if (productList[i].getType().equalsIgnoreCase("CasePC")) {
                    filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                    filteredList[filteredList.length - 1] = productList[i];
                }
            }
        }
        return filteredList;
    }

    Product[] sortList(Product[] productList) {
        Product filteredList[] = new Product[0];
        Long userInput;
        System.out.print("Nhap gia pham can tim: ");
        userInput = Long.parseLong(sc.nextLine());
        for (int i = 0; i < productList.length; i++) {
            if (productList[i].getPrice() <= userInput) {
                filteredList = Arrays.copyOf(filteredList, filteredList.length + 1);
                filteredList[filteredList.length - 1] = productList[i];
            }
        }
        return filteredList;
    }

    Product[] sortArrayAccending(Product[] productList) {
        Product temp = new Product();
        for (int i = 0; i < productList.length; i++) {
            for (int j = i + 1; j < productList.length; j++) {
                if (productList[i].getPrice() > productList[j].getPrice()) {
                    temp = productList[i];
                    productList[i] = productList[j];
                    productList[j] = temp;
                }
            }
        }
        return productList;
    }

    Product[] sortArrayDescending(Product[] productList) {
        Product temp = new Product();
        for (int i = 0; i < productList.length; i++) {
            for (int j = i + 1; j < productList.length; j++) {
                if (productList[i].getPrice() < productList[j].getPrice()) {
                    temp = productList[i];
                    productList[i] = productList[j];
                    productList[j] = temp;
                }
            }
        }
        return productList;
    }
}
