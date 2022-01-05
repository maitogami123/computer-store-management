package com.demo;

import java.util.Scanner;

public class Authenticate {
    AdminList al = new AdminList();
    Scanner sc = new Scanner(System.in);
    
    Authenticate() {

    }

    void verify() {
        String username, password;
        System.out.print("Nhap tai khoan: ");
        username = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
        al.verifyUser(username, password);
    }
}
