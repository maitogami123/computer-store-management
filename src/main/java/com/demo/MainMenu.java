package com.demo;

import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    MainMenu() {

    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Thoat chuong trinh                                      *");
        System.out.println("*   1. Vao ung dung voi tu cach khach hang                     *");
        System.out.println("*   2. Vao ung dung voi tu cach admin                          *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void init() {
        printMenu();
        int userInput;
        while( true ) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            mainLoop: switch (userInput) {
                case 0:
                    System.out.println("Thoat ung dung!");
                    return;
                case 1:
                    ProductList pl = new ProductList();
                    pl.initUser();
                    break mainLoop;
                case 2:
                    Authenticate au = new Authenticate();
                    au.verify();
                    break mainLoop;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
