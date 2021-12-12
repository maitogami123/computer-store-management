package com.demo;

import java.util.Scanner;

public class Authenticate {
    AdminList al = new AdminList();
    Scanner sc = new Scanner(System.in);
    
    Authenticate() {

    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Dang nhap voi tu cach admin                             *");
        System.out.println("*   2. Dang nhap voi tu cach seller                            *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void init() {
        printMenu();
        int userInput;
        String username, password;
        while( true ) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Quay ve");
                    return;
                case 1:
                    System.out.print("Nhap tai khoan: ");
                    username = sc.nextLine();
                    System.out.print("Nhap mat khau: ");
                    password = sc.nextLine();
                    al.verifyAdmin(username, password);
                    break;
                case 2:
                    System.out.print("Nhap tai khoan: ");
                    username = sc.nextLine();
                    System.out.print("Nhap mat khau: ");
                    password = sc.nextLine();
                    al.verifySeller(username, password);
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
