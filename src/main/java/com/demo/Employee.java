package com.demo;
import java.util.Scanner;

public abstract class Employee {
    private String password, adminName;
    Scanner sc = new Scanner(System.in);
    Employee(String password, String adminName) {
        this.password = password;
        this.adminName = adminName;
    }

    Employee() {

    }

    // Setter

    void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setAdminName() {
        System.out.print("Nhap ten admin: ");
        adminName = sc.nextLine();
    }

    void setPassword() {
        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
    }

    void setInfo() {
        System.out.print("Nhap ten admin: ");
        adminName = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
    }

    // Getter

    String getPassword() {
        return password;
    }

    String getAdminName() {
        return adminName;
    }

    @Override
    public String toString() {
        return adminName + "/" + password;
    }

    abstract long salary();
}
