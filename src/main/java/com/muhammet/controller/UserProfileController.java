package com.muhammet.controller;

import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {
    private Scanner scanner;
    private UserProfileService userProfileService;
    public UserProfileController(){
        scanner = new Scanner(System.in);
        userProfileService = new UserProfileService();
    }
    public void register(){
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("***********   REGISTER PAGE    ***********");
        System.out.println("******************************************");
        System.out.println();
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
            }else{
                userProfileService.save(UserProfile.builder().username(username).password(password).build());
                System.out.println("KULLANICI BASARI İLE KAYIT EDİLDİ.");
            }
        }else {
            System.out.println("Sifreler uyusmamaktadır.");
        }

    }

}
