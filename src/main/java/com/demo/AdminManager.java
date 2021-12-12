package com.demo;

import java.util.Scanner;

public class AdminManager extends Employee {
    private long salaryPerDay = 450000;
    private long bonus = 0;
    Scanner sc = new Scanner(System.in);

    AdminManager() {

    }

    @Override
    long salary() {
        System.out.print("Nhap so ngay lam: ");
        int workingDay = Integer.parseInt(sc.nextLine());
        Revenue rev = new Revenue();
        rev.readFile();
        if (rev.getRevenue() >= 1000000000) {
            bonus = (long) (rev.getRevenue() * 0.1);
        }
        return bonus + salaryPerDay * workingDay;
    }

    void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Hien thi menu                                           *");
        System.out.println("*   2. Quan ly san pham                                        *");
        System.out.println("*   3. Quan ly thong tin khuyen mai                            *");
        System.out.println("*   4. Quan ly hoa don                                         *");
        System.out.println("*   5. Quan ly nhan vien                                       *");
        System.out.println("*   6. Tinh luong                                              *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void init() {
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
                    printMenu();
                    break mainLoop;
                case 2:
                    ProductList pl = new ProductList();
                    pl.initAdmin();
                    break mainLoop;
                case 3:
                    NewsAndPromosList promoList = new NewsAndPromosList();
                    promoList.initAdmin();
                    break mainLoop;
                case 4:
                    Orders orderManage = new Orders();
                    orderManage.initAdmin();
                    break mainLoop;
                case 5:
                    AdminList al = new AdminList();
                    al.init();
                    break mainLoop;
                case 6:
                    System.out.println("Luong thang nay la: " + salary());
                    break mainLoop;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
