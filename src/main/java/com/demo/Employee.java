package com.demo;
import java.util.Scanner;

public abstract class Employee {
    private String password, adminName;
    AdminList al = new AdminList();
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
        String userInput;
        do {
            System.out.print("Nhap ten admin: ");
            userInput = sc.nextLine();
            if (al.usernameAvailable(userInput)) {
                adminName = userInput;
            } else {
                System.out.println("Tai khoan da ton tai!");
            }
        } while(!al.usernameAvailable(userInput));
    }

    void setPassword() {
        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
    }

    void setInfo() {
        setAdminName();
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
