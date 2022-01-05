package com.demo;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class AdminList implements FileControl {
    Employee employeeList[] = new Employee[0];
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
                    employeeList = Arrays.copyOf(employeeList, employeeList.length + 1);
                    employeeList[employeeList.length - 1] = new Seller();
                    employeeList[employeeList.length - 1].setAdminName(arrOfStr[1]);
                    employeeList[employeeList.length - 1].setPassword(arrOfStr[2]);
                } else {
                    employeeList = Arrays.copyOf(employeeList, employeeList.length + 1);
                    employeeList[employeeList.length - 1] = new AdminManager();
                    employeeList[employeeList.length - 1].setAdminName(arrOfStr[1]);
                    employeeList[employeeList.length - 1].setPassword(arrOfStr[2]);
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
            for (int i = 0; i < employeeList.length; i++) {
                buff.write(employeeList[i].toString() + "\n");
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
        employeeList = Arrays.copyOf(employeeList, employeeList.length + 1);
        employeeList[employeeList.length - 1] = new Seller();
        employeeList[employeeList.length - 1].setInfo();
    }

    void addAdminManager() {
        employeeList = Arrays.copyOf(employeeList, employeeList.length + 1);
        employeeList[employeeList.length - 1] = new AdminManager();
        employeeList[employeeList.length - 1].setInfo();
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
                    addAdminManager();
                    break;
                case 2:
                    addSeller();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }

    void deleteAdmin() {
        int userInput;
        System.out.print("Nhap stt nhan vien muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        for (int i = userInput; i < employeeList.length - 1; i++) {
            employeeList[i] = employeeList[i + 1];
        }
        employeeList = Arrays.copyOf(employeeList, employeeList.length - 1);
    }

    void printList() {
        System.out.printf("%-18s%-18s%-18s%s\n", "STT","Vai tro", "Tai khoan", "Mat khau");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < employeeList.length; i++) {
            String arrOfStr[] = employeeList[i].toString().split("/");
            System.out.printf("%-18s%-18s%-18s%s\n",
                    i + 1,
                    arrOfStr[0],
                    employeeList[i].getAdminName(),
                    employeeList[i].getPassword());
            System.out.println();
        }
    }

    public void deleteItem() {
        printList();
        deleteAdmin();
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
            int userInput;
            System.out.print("Nhap stt nhan user muon chinh sua: ");
            int index = Integer.parseInt(sc.nextLine());
            if (index < employeeList.length) {
                modifyMenu();
                while (true) {
                    System.out.println("Nhap lua chon: ");
                    userInput = Integer.parseInt(sc.nextLine());
                    switch (userInput) {
                        case 0:
                            System.out.println("Quay lai!\n");
                            return;
                        case 1:
                            employeeList[index - 1].setAdminName();
                            break;
                        case 2:
                            employeeList[index - 1].setPassword();
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
                    printList();
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

    void verifyUser(String username, String password) {
        readFile();
        Boolean isVerified = false;
        int index = 0;
        for (; index < employeeList.length; index++) {
            if (employeeList[index].getAdminName().equals(username) && employeeList[index].getPassword().equals(password)) {
                isVerified = true;
                break;
            }
        }
        if (isVerified) {
            String arrOfStr[] = employeeList[index].toString().split("/");
            if (arrOfStr[0].equalsIgnoreCase("admin")) {
                AdminManager adm = new AdminManager();
                adm.init();
            } else if (arrOfStr[0].equalsIgnoreCase("seller")){
                Seller sl = new Seller();
                sl.init();
            } else {
                System.out.println("Có lỗi xảy ra! Vui lòng đăng nhập lại.");
            }
        } else {
            System.out.println("Tai khoan hoac mat khau sai!");
        }
    }

    // Verify data

    Boolean usernameAvailable(String username) {
        readFile();
        for(int i = 0; i < employeeList.length; i++) {
            if (username.equalsIgnoreCase(employeeList[i].getAdminName())) {
                return false;
            }
        }
        return true;
    }
}
