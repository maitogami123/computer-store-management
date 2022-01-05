package com.demo;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ProductList implements FileControl {
    Product productList[] = new Product[0];
    Product filteredList[] = new Product[0];
    FilterAndSort filterSort = new FilterAndSort();
    Scanner sc = new Scanner(System.in);
    int lines = 0;

    ProductList() {

    }

    public void readFile() {
        try {
            File file = new File("management\\src\\main\\java\\com\\demo\\database\\products.txt");
            Scanner reader = new Scanner(file);

            // How many item ?
            while (reader.hasNextLine()) {
                lines++;
                reader.nextLine();
            }
            reader.close();

            // Write data
            productList = new Product[lines];
            reader = new Scanner(file);
            int index = 0;
            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                String[] arrOfStr = temp.split("/");
                productList[index] = new Product(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3], arrOfStr[4], Long.parseLong(arrOfStr[5]));
                index++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void writeFile() {
        try {
            FileWriter outputFile = new FileWriter("management\\src\\main\\java\\com\\demo\\database\\products.txt");
            BufferedWriter buff = new BufferedWriter(outputFile);
            for (int i = 0; i < productList.length; i++) {
                buff.write(productList[i].toString() + "\n");
            }
            buff.close();
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void addItem() {
        productList = Arrays.copyOf(productList, productList.length + 1);
        productList[productList.length - 1] = new Product();
        int isExist;
        do {
            isExist = 0;
            System.out.print("Nhap Id: ");
            productList[productList.length - 1].setProductId(sc.nextLine());
            for (int i = 0; i < productList.length - 1; i++) {
                if (productList[productList.length - 1].getProductId().equals(productList[i].getProductId())) {
                    System.out.println("ID da ton tai!");
                    isExist = 1;
                }
            }
        } while (isExist == 1);
        productList[productList.length - 1].setInfo();
    }

    public void deleteItem() {
        int userInput;
        System.out.print("Nhap hang muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = userInput; i < productList.length - 1; i++) {
            productList[i] = productList[i + 1];
        }
        productList = Arrays.copyOf(productList, productList.length - 1);
    }

    public void modifyItem() {
        int userInput;
        System.out.print("Nhap mat hang muon chinh sua (STT): ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        productList[userInput].modifyItem();
    }

    void saveBeforeExit() {
        int userInput;
        System.out.println("Ban co muuon luu cac thay doi hay khong ?");
        System.out.println("Nhap 1 de luu");
        System.out.println("Nhap 2 de khong luu");
        do {
            System.out.print("Nhap lua chon: ");
            userInput = Integer.parseInt(sc.nextLine());
            if (userInput != 1 && userInput != 2) {
                System.out.println("Du lieu nhap vao khong hop le!");
            }
        } while (userInput != 1 && userInput != 2);

        if (userInput == 1) {
            writeFile();
            System.out.println("Da luu thanh cong!");
        } else {
            System.out.println("Mot mat thi dung co kim :))");
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

    void printListDetails(String userInput, Product productList[]) {
        System.out.printf("%-8s%-18s%-18s%-18s%-32s%s\n", "STT", "ID", "Loai hang", "hang", "Ten", "Gia");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < productList.length; i++)
            if (productList[i].getProductId().equalsIgnoreCase(userInput)) {
                System.out.printf("%-8s%-18s%-18s%-18s%-32s%d\n",
                        i + 1,
                        productList[i].getProductId(),
                        productList[i].getType(),
                        productList[i].getBrand(),
                        productList[i].getName(),
                        productList[i].getPrice());
                System.out.println();
                System.out.println("Chi tiet san pham: " + productList[i].getDescription() + "\n");
                break;
            }
    }

    void printUserMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Hien menu                                               *");
        System.out.println("*   2. Xem mat hang                                            *");
        System.out.println("*   3. Tim kiem san pham                                       *");
        System.out.println("*   4. Xem thong tin chi tiet                                  *");
        System.out.println("*   5. Quan li don hang                                        *");
        System.out.println("*   6. Xem thong tin khuyen mai                                *");
        System.out.println("*   7. Them san pham vao gio hang                              *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void initUser() {
        readFile();
        printUserMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            mainLoop: switch (userInput) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    printUserMenu();
                    break;
                case 2:
                    printList(productList);
                    break;
                case 3:
                    filterSort.init(productList);
                    break mainLoop;
                case 4:
                    System.out.print("Nhap id san pham muon xem chi tiet: ");
                    String subInput = (sc.nextLine());
                    printListDetails(subInput, productList);
                    break;
                case 5:
                    Orders userOrder = new Orders();
                    userOrder.initUser();
                    break mainLoop;
                case 6:
                    NewsAndPromosList promoList = new NewsAndPromosList();
                    promoList.displayPromos();
                    break;
                case 7:
                    Cart newCart = new Cart();
                    newCart.initUser(productList);
                    printUserMenu();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Hien menu                                               *");
        System.out.println("*   2. Xem mat hang                                            *");
        System.out.println("*   3. Them mat hang                                           *");
        System.out.println("*   4. Xoa mat hang                                            *");
        System.out.println("*   5. Chinh sua san pham                                      *");
        System.out.println("*   6. Luu thay doi                                            *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void initAdmin() {
        readFile();
        printMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            mainLoop: switch (userInput) {
                case 0:
                    saveBeforeExit();
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    printMenu();
                    break;
                case 2:
                    printList(productList);
                    break;
                case 3:
                    addItem();
                    writeFile();
                    break;
                case 4:
                    deleteItem();
                    writeFile();
                    break;
                case 5:
                    modifyItem();
                    writeFile();
                    break mainLoop;
                case 6:
                    writeFile();
                    System.out.println("Viet du lieu thanh cong!");
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
