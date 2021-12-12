package com.demo;
import java.util.Scanner;

public class Product {
    private String name, description, brand, type, productId;
    private long price;
    Scanner sc = new Scanner(System.in);

    Product(String productId, String type, String brand, String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.type = type;
        this.productId = productId;
        this.price = price;
    }

    Product() {

    }

    // Setter

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setInfo() {
        System.out.print("Nhap loai hang: ");
        type = sc.nextLine();
        System.out.print("Nhap hang san xuat: ");
        brand = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        name = sc.nextLine();
        System.out.print("Nhap thong tin san pham: ");
        description = sc.nextLine();
        System.out.print("Nhap gia san pham: ");
        price = Long.parseLong(sc.nextLine());
    }

    // Getter

    public String getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }

    // Function

    @Override
    public String toString() {
        return (productId + "/" + type + "/" + brand + "/" + name + "/" + description + "/" + price);
    }

    public void modifyMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   1. Loai san pham                                           *");
        System.out.println("*   2. Hang san xuat                                           *");
        System.out.println("*   3. Ten san pham                                            *");
        System.out.println("*   4. Thong tin                                               *");
        System.out.println("*   5. Gia                                                     *");
        System.out.println("*   6. Quay lai                                                *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
    }

    public void modifyItem() {
        modifyMenu();
        int userInput;
        while( true ) {
            System.out.print("\nNhap chuong trinh muon thuc hien: ");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 1: 
                    System.out.print("Nhap loai san pham: ");
                    setType(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap loai hang san xuat: ");
                    setBrand(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ten san pham: ");
                    setName(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap thong tin san pham: ");
                    setDescription(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap gia san pham: ");
                    setPrice(Long.parseLong(sc.nextLine()));
                    break;
                case 6:
                    System.out.println("Tro ve chuong trinh chinh");
                    return;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
