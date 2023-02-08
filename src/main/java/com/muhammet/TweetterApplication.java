package com.muhammet;

import com.muhammet.controller.UserProfileController;

import java.util.Scanner;

public class TweetterApplication {
    public static void main(String[] args) {
        int secim;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("*******************************************");
            System.out.println("*******    TWEET UYGULAMASI          ******");
            System.out.println("*******************************************");
            System.out.println();
            System.out.println("1- Üye Ol");
            System.out.println("2- Giriş Yap");
            System.out.println("3- Tweetleri Gör");
            System.out.println("0- ÇIKIS YAP");
            System.out.print("Seçiniz....: ");
            secim = scanner.nextInt();
            switch (secim){
                case 1: new UserProfileController().register(); break;
                case 2: break;
                case 3: break;

            }
        }while (secim!=0);
        System.out.println("TEKRAR GÖRÜSMEK ÜZERE");

    }
}