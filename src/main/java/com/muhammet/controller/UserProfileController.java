package com.muhammet.controller;

import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {
    private Scanner scanner;
    private UserProfileService userProfileService;
    private TweetController tweetController;
    public UserProfileController(){
        scanner = new Scanner(System.in);
        userProfileService = new UserProfileService();
        tweetController = new TweetController();
    }
    public void register(){
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("***********   REGISTER PAGE    ***********");
        System.out.println("******************************************");
        System.out.println();
        boolean state;
        do{
            System.out.print("Kullanıcı adı.....: ");
            String username = scanner.nextLine();
            System.out.print("Sifre.............: ");
            String password = scanner.nextLine();
            System.out.print("Sifre Doğruluma...: ");
            String repassword = scanner.nextLine();
            if(repassword.equals(password)){
                boolean isUsernameExist = userProfileService.existByUsername(username);
                if(isUsernameExist){
                    System.out.println("Bu Kullanıcı adı kullanılmaktadır");
                    state = true;
                }else{
                    userProfileService.save(UserProfile.builder().username(username).password(password).build());
                    System.out.println("KULLANICI BASARI İLE KAYIT EDİLDİ.");
                    state = false;
                }
            }else {
                System.out.println("Sifreler uyusmamaktadır.");
                state = true;
            }
        }while(state);


    }

    public void login(){
        System.out.println("*************************************");
        System.out.println("********    LOGIN PAGE      *********");
        System.out.println("*************************************");
        System.out.println();
        System.out.print("Username.......: ");
        String username = scanner.nextLine();
        System.out.print("Password.......: ");
        String password = scanner.nextLine();
        /**
         * Kullanıcı adı ve şifre doğrulanırken kullanıcıya, şifre yanlıştır bilgisi geçmeyiniz.
         * veya kullanıcı adı bulunmamaktadır. Bu tarz geri bildirimler güvenlik zafiyetidir.
         */
        boolean login = userProfileService.doLogin(username,password);
        if(login){
            System.out.println("GİRİS BASARILI");
            tweetController.userPage(username);
        }else {
            System.out.println("Kullanıcı adı ya da sifre hatalıdır.");
        }
    }
}
