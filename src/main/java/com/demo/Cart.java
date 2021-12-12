package com.demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Calendar;
import java.io.*;

public class Cart {
    Product cartItems[] = new Product[0];
    private int quantity;
    private long price = 0;
    Scanner sc = new Scanner(System.in);

    Cart() {

    }

    int getQuantity() {
        return quantity;
    }

    long getPrice() {
        return price;
    }

    void addItemToCart(Product item) {
        cartItems = Arrays.copyOf(cartItems, cartItems.length + 1);
        cartItems[cartItems.length - 1] = new Product();
        cartItems[cartItems.length - 1] = item;
        price += cartItems[cartItems.length - 1].getPrice();
    }

    void deleteCartItem() {
        int userInput;
        System.out.print("Nhap hang muon xoa: ");
        userInput = Integer.parseInt(sc.nextLine()) - 1;
        price = price - cartItems[userInput].getPrice();
        for (int i = userInput; i < cartItems.length - 1; i++) {
            cartItems[i] = cartItems[i + 1];
        }
        cartItems = Arrays.copyOf(cartItems, cartItems.length - 1);
    }

    void getProduct(Product product[]) {
        String userInput;
        System.out.print("Nhap id san pham muon them vao: ");
        userInput = sc.nextLine();
        for (int i = 0; i < product.length; i++) {
            if (product[i].getProductId().equalsIgnoreCase(userInput)) {
                addItemToCart(product[i]);
                break;
            }
        }
    }

    void printCart() {
        System.out.printf("%-8s%-18s%-18s%-18s%-32s%s\n", "STT", "ID", "Loai hang", "hang", "Ten", "Gia");
        System.out.println(
                "=====================================================================================================================");
        for (int i = 0; i < cartItems.length; i++) {
            System.out.printf("%-8s%-18s%-18s%-18s%-32s%d\n",
                    i + 1,
                    cartItems[i].getProductId(),
                    cartItems[i].getType(),
                    cartItems[i].getBrand(),
                    cartItems[i].getName(),
                    cartItems[i].getPrice());
            System.out.println();
        }
        System.out.println(
                "=====================================================================================================================");
        System.out.printf("%94s%d\n", "Tong: ", getPrice());
    }

    public void writeFile(String name, String date) {
        String fileName = "management\\src\\main\\java\\com\\demo\\database\\orders\\" + name + "_" + date + ".txt";
        try {
            FileWriter outputFile = new FileWriter(fileName);
            BufferedWriter buff = new BufferedWriter(outputFile);
            for (int i = 0; i < cartItems.length; i++) {
                buff.write(cartItems[i].toString() + "\n");
            }
            buff.close();
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void writeFile(Customer customer) {
        try {
            FileWriter outputFile = new FileWriter("management\\src\\main\\java\\com\\demo\\database\\customers.txt", true);
            BufferedWriter buff = new BufferedWriter(outputFile);
            buff.write(customer.toString() + "\n");
            buff.close();
            outputFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    void checkOut() {
        System.out.println("Vui long nhap thong tin khach hang!");
        Customer customer = new Customer();
        customer.setInfo();
        new Revenue(getPrice());
        System.out.println("Cam on quy khach da mua hang!");
        Calendar calendar = Calendar.getInstance();
        String date = "" + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.MONTH) + " "
                + calendar.get(Calendar.YEAR) + "_" + calendar.get(Calendar.HOUR_OF_DAY) + "-"
                + calendar.get(Calendar.MINUTE);
        writeFile(customer.getCustomnerName(), date);
        writeFile(customer);
        cartItems = new Product[0];
        price = 0;
    }

    void printCartMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Hien menu                                               *");
        System.out.println("*   2. Them san pham vao gio hang                              *");
        System.out.println("*   3. Xoa san pham khoi gio hang                              *");
        System.out.println("*   4. Xem thong tin gio hang                                  *");
        System.out.println("*   5. Check out*                                              *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    void initUser(Product productList[]) {
        printCartMenu();
        int userInput;
        while (true) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    return;
                case 1:
                    printCartMenu();
                    break;
                case 2:
                    getProduct(productList);
                    printCart();
                    break;
                case 3:
                    deleteCartItem();
                    printCart();
                    break;
                case 4:
                    printCart();
                    break;
                case 5:
                    checkOut();
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
