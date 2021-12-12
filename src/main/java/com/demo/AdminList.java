package com.demo;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class AdminList implements FileControl {
    Seller sellerList[] = new Seller[0];
    AdminManager adminManagerList[] = new AdminManager[0];
    Scanner sc = new Scanner(System.in);

    AdminList() {

    }

    public void readFile() {
        try {
            File file = new File("management\\src\\main\\java\\com\\demo\\database\\users.txt");
            Scanner reader = new Scanner(file);

            // Write data

            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                String[] arrOfStr = temp.split("/");
                if (arrOfStr[0].equalsIgnoreCase("seller")) {
                    sellerList = Arrays.copyOf(sellerList, sellerList.length + 1);
                    sellerList[sellerList.length - 1] = new Seller();
                    sellerList[sellerList.length - 1].setAdminName(arrOfStr[1]);
                    sellerList[sellerList.length - 1].setPassword(arrOfStr[2]);
                } else {
                    adminManagerList = Arrays.copyOf(adminManagerList, adminManagerList.length + 1);
                    adminManagerList[adminManagerList.length - 1] = new AdminManager();
                    adminManagerList[adminManagerList.length - 1].setAdminName(arrOfStr[1]);
                    adminManagerList[adminManagerList.length - 1].setPassword(arrOfStr[2]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void writeFile() {
        try {
            FileWriter outputFile = new FileWriter("management\\src\\main\\java\\com\\demo\\database\\users.txt");
            BufferedWriter buff = new BufferedWriter(outputFile);
            for (int i = 0; i < sellerList.length; i++) {
                buff.write("seller/" + sellerList[i].toString() + "\n");
            }
            for (int i = 0; i < adminManagerList.length; i++) {
                buff.write("admin/" + adminManagerList[i].toString() + "\n");
            }
            buff.close();
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    void addAdminMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Them quan ly admin                                      *");
        System.out.println("*   2. Them nhan vien ban hang                                 *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void addSeller() {
        sellerList = Arrays.copyOf(sellerList, sellerList.length + 1);
        sellerList[sellerList.length - 1] = new Seller();
        sellerList[sellerList.length - 1].setInfo();
    }

    void addAdminManager() {
        adminManagerList = Arrays.copyOf(adminManagerList, adminManagerList.length + 1);
        adminManagerList[adminManagerList.length - 1] = new AdminManager();
        adminManagerList[adminManagerList.length - 1].setInfo();
    }

    public void addItem() {
        addAdminMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Quay ve");
                    return;
                case 1:
                    addSeller();
                    break;
                case 2:
                    addAdminManager();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void deleteAdminMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Xoa quan ly admin                                       *");
        System.out.println("*   2. Xoa nhan vien ban hang                                  *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void deleteSeller() {
        int userInput;
        System.out.print("Nhap stt nhan vien muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = userInput; i < sellerList.length - 1; i++) {
            sellerList[i] = sellerList[i + 1];
        }
        sellerList = Arrays.copyOf(sellerList, sellerList.length - 1);
    }

    void deleteAdminManager() {
        int userInput;
        System.out.print("Nhap stt nhan vien muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = userInput; i < adminManagerList.length - 1; i++) {
            adminManagerList[i] = adminManagerList[i + 1];
        }
        adminManagerList = Arrays.copyOf(adminManagerList, adminManagerList.length - 1);
    }

    void printList(Seller sellerList[]) {
        System.out.printf("%-18s%-18s%s\n", "STT", "Tai khoan", "Mat khau");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < sellerList.length; i++) {
            System.out.printf("%-18s%-18s%s\n",
                    i + 1,
                    sellerList[i].getAdminName(),
                    sellerList[i].getPassword());
            System.out.println();
        }
    }

    void printList(AdminManager adminManagerList[]) {
        System.out.printf("%-18s%-18s%s\n", "STT", "Tai khoan", "Mat khau");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < adminManagerList.length; i++) {
            System.out.printf("%-18s%-18s%s\n",
                    i + 1,
                    adminManagerList[i].getAdminName(),
                    adminManagerList[i].getPassword());
            System.out.println();
        }
    }

    public void deleteItem() {
        deleteAdminMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Quay ve");
                    return;
                case 1:
                    printList(sellerList);
                    deleteSeller();
                    break;
                case 2:
                    printList(adminManagerList);
                    deleteAdminManager();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void modifyMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Chinh sua tai khoan                                     *");
        System.out.println("*   2. Chinh sua mat khau                                      *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    public void modifyItem() {
        int userInput, adminNumber;
        System.out.println("Nhap role cua nhan vien: ");
        System.out.print("seller | admin: ");
        String role = sc.nextLine();
        if (role.equalsIgnoreCase("seller")) {
            printList(sellerList);
            do {
                System.out.print("Nhap stt nhan vien muon chinh sua: ");
                adminNumber = Integer.parseInt(sc.nextLine());
                if (adminNumber <= 0 && adminNumber >= sellerList.length) {
                    System.out.println("Nhan vien nhap vao khong hop le, vui long nhap lai!");
                }
            } while (adminNumber <= 0 && adminNumber >= sellerList.length);
            modifyMenu();
            while (true) {
                System.out.println("Nhap lua chon: ");
                userInput = Integer.parseInt(sc.nextLine());
                switch (userInput) {
                    case 0:
                        System.out.println("Quay lai!\n");
                        return;
                    case 1:
                        sellerList[adminNumber - 1].setAdminName();
                        break;
                    case 2:
                        sellerList[adminNumber - 1].setPassword();
                        break;
                    default:
                        System.out.println("Du lieu nhap vao khong hop le!");
                        break;
                }
            }
        } else if (role.equalsIgnoreCase("admin")) {
            printList(adminManagerList);
            do {
                System.out.print("Nhap stt nhan vien muon chinh sua: ");
                adminNumber = Integer.parseInt(sc.nextLine());
                if (adminNumber <= 0 && adminNumber >= adminManagerList.length) {
                    System.out.println("Nhan vien nhap vao khong hop le, vui long nhap lai!");
                }
            } while (adminNumber <= 0 && adminNumber >= adminManagerList.length);
            modifyMenu();
            while (true) {
                System.out.println("Nhap lua chon: ");
                userInput = Integer.parseInt(sc.nextLine());
                switch (userInput) {
                    case 0:
                        System.out.println("Quay lai!\n");
                        return;
                    case 1:
                        adminManagerList[adminNumber - 1].setAdminName();
                        break;
                    case 2:
                        adminManagerList[adminNumber - 1].setPassword();
                        break;
                    default:
                        System.out.println("Du lieu nhap vao khong hop le!");
                        break;
                }
            }
        } else {
            System.out.println("Du lieu nhap vao khong hop le!");
        }
    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Xem danh sach nhan vien                                 *");
        System.out.println("*   2. Them nhan vien                                          *");
        System.out.println("*   3. Chinh sua nhan vien                                     *");
        System.out.println("*   4. Xoa nhan vien                                           *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void init() {
        readFile();
        printMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            mainLoop: switch (userInput) {
                case 0:
                    System.out.println("Quay ve");
                    return;
                case 1:
                    printList(adminManagerList);
                    printList(sellerList);
                    break;
                case 2:
                    addItem();
                    writeFile();
                    break mainLoop;
                case 3:
                    modifyItem();
                    writeFile();
                    break mainLoop;
                case 4:
                    deleteItem();
                    writeFile();
                    break mainLoop;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void verifyAdmin(String username, String password) {
        readFile();
        Boolean isVerified = false;
        for (int i = 0; i < adminManagerList.length; i++) {
            if (adminManagerList[i].getAdminName().equals(username)
                    && adminManagerList[i].getPassword().equals(password)) {
                isVerified = true;
                break;
            }
        }
        if (isVerified) {
            AdminManager am = new AdminManager();
            am.init();
        } else {
            System.out.println("Tai khoan hoac mat khau sai!");
        }
    }

    void verifySeller(String username, String password) {
        readFile();
        Boolean isVerified = false;
        for (int i = 0; i < sellerList.length; i++) {
            if (sellerList[i].getAdminName().equals(username) && sellerList[i].getPassword().equals(password)) {
                isVerified = true;
                break;
            }
        }
        if (isVerified) {
            Seller sl = new Seller();
            sl.init();
        } else {
            System.out.println("Tai khoan hoac mat khau sai!");
        }
    }

}
