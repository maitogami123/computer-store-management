package com.demo;
import java.util.Scanner;

public class NewsAndPromos {
    private String heading, content, promoId;
    Scanner sc = new Scanner(System.in);
    NewsAndPromos( String promoId, String heading, String content) {
        this.heading = heading;
        this.content = content;
        this.promoId = promoId;
    }

    NewsAndPromos() {

    }

    // Setter

    void setHeading(String heading) {
        this.heading = heading;
    }

    void setContent(String content) {
        this.content = content;
    }

    void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    void setInfo() {
        System.out.print("Nhap tieu de: ");
        heading = sc.nextLine();
        System.out.print("Nhap noi dung: ");
        content = sc.nextLine();
    }

    // Getter

    String getHeading() {
        return heading;
    }

    String getContent() {
        return content;
    }

    String getPromoId() {
        return promoId;
    }

    @Override
    public String toString() {
        return promoId + "/" + heading + "/" + content;
    }

    public void modifyMenu() {
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("*   0. Quay lai                                                *");
        System.out.println("*   1. Chinh sua tieu de                                       *");
        System.out.println("*   2. Chinh sua noi dung                                      *");
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
                case 0:
                    System.out.println("Tro ve chuong trinh chinh");
                    return;
                case 1: 
                    System.out.print("Nhap tieu de: ");
                    setHeading(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap noi dung: ");
                    setContent(sc.nextLine());
                    break;
                default:
                    System.out.println("Du lieu nhap vao khong hop le hoac tinh nang dang phat trien!");
                    break;
            }
        }
    }
}
