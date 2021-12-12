package com.demo;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class NewsAndPromosList implements FileControl {
    NewsAndPromos[] newsList = new NewsAndPromos[0];
    Scanner sc = new Scanner(System.in);
    int lines = 0;

    NewsAndPromosList() {

    }

    public void readFile() {
        try {
            File file = new File("management\\src\\main\\java\\com\\demo\\database\\promotions.txt");
            Scanner reader = new Scanner(file);

            // How many item ?
            while (reader.hasNextLine()) {
                lines++;
                reader.nextLine();
            }
            reader.close();
            // Write data
            newsList = new NewsAndPromos[lines];
            reader = new Scanner(file);
            int index = 0;
            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                String[] arrOfStr = temp.split("/");
                newsList[index] = new NewsAndPromos(arrOfStr[0], arrOfStr[1], arrOfStr[2]);
                index++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void writeFile() {
        try {
            FileWriter outputFile = new FileWriter("management\\src\\main\\java\\com\\demo\\database\\promotions.txt");
            BufferedWriter buff = new BufferedWriter(outputFile);
            for (int i = 0; i < newsList.length; i++) {
                buff.write(newsList[i].toString() + "\n");
            }
            buff.close();
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void addItem() {
        newsList = Arrays.copyOf(newsList, newsList.length + 1);
        newsList[newsList.length - 1] = new NewsAndPromos();
        int isExist;
        do {
            isExist = 0;
            System.out.println("Exist:" + isExist);
            System.out.print("Nhap Id: ");
            newsList[newsList.length - 1].setPromoId(sc.nextLine());
            for (int i = 0; i < newsList.length - 1; i++) {
                if (newsList[newsList.length - 1].getPromoId().equals(newsList[i].getPromoId())) {
                    System.out.println("ID da ton tai!");
                    isExist = 1;
                }
            }
        } while (isExist == 1);
        newsList[newsList.length - 1].setInfo();
    }

    public void deleteItem() {
        int userInput;
        System.out.print("Nhap khuyen mai muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = userInput; i < newsList.length - 1; i++) {
            newsList[i] = newsList[i + 1];
        }
        newsList = Arrays.copyOf(newsList, newsList.length - 1);
    }

    public void modifyItem() {
        int userInput;
        System.out.print("Nhap stt khuyen mai muon chinh sua : ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        newsList[userInput].modifyItem();
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

    void printList(NewsAndPromos newsList[]) {
        System.out.printf("%-8s%-8s%-32s%s\n", "STT", "ID", "Tieu de", "Noi dung");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < newsList.length; i++) {
            System.out.printf("%-8s%-8s%-32s%s\n",
                    i + 1,
                    newsList[i].getPromoId(),
                    newsList[i].getHeading(),
                    newsList[i].getContent());
            System.out.println();
        }
    }

    // Display Promos for user
    void displayPromos() {
        readFile();
        printList(newsList);
    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Hien thi menu                                           *");
        System.out.println("*   2. Xoa khuyen mai                                          *");
        System.out.println("*   3. Chinh sua khuyen mai                                    *");
        System.out.println("*   4. Luu thay doi                                            *");
        System.out.println("*   5. Them khuyen mai                                         *");
        System.out.println("*   6. Xem tat ca cac khuyen mai                               *");
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
                    deleteItem();
                    writeFile();
                    break;
                case 3:
                    modifyItem();
                    writeFile();
                    break mainLoop;
                case 4:
                    writeFile();
                    System.out.println("Luu du lieu thanh cong!");
                    break;
                case 5:
                    addItem();
                    writeFile();
                    break;
                case 6:
                    printList(newsList);
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
