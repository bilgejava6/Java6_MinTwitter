package com.muhammet.controller;

import com.muhammet.repository.entity.Comment;
import com.muhammet.repository.entity.Tweet;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.repository.view.VwTweet;
import com.muhammet.repository.view.VwUserProfile;
import com.muhammet.service.*;

import java.util.Map;
import java.util.Scanner;

public class TweetController {
    private Scanner scanner;
    private UserProfile userProfile;
    private TweetService tweetService;
    private LikeListService likeListService;
    private FollowService followService;
    private CommentService commentService;
    private UserProfileService userProfileService;
    public TweetController(){
        this.commentService = new CommentService();
        this.followService = new FollowService();
        this.tweetService = new TweetService();
        this.likeListService = new LikeListService();
        this.userProfileService = new UserProfileService();

    }

    private  int secim(){
        this.scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String ifade(){
        this.scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Bir kullanının akışı şeklinde yapıyoruz. Bu nedenle login olan kullanıcının id si üzerinden
     * işlem yapacağız.
     * @param username
     */
    public void userPage(String username){
        this.userProfile = userProfileService.findByUsername(username).get();
        System.out.println("****************************");
        System.out.println("****     USER PAGE       ***");
        System.out.println("****************************");
        int secim;
        do{
            System.out.println("");
            System.out.println("1- Tweet Oluştur");
            System.out.println("2- Tüm Tweetleri Gör");
            System.out.println("3- Profil Düzenle");
            System.out.println("0- <<< Geri Dön");
            System.out.println("Seçiniz......: ");
            secim = secim();
            switch (secim){
                case 1: createTweet(); break;
                case 2: listTweet(); break;
                case 3: break;
            }
        }while(secim!=0);
    }

    private void createTweet(){
        System.out.println("**********************************");
        System.out.println("*****     TWEET OLUSTUR    *******");
        System.out.println();
        System.out.println("Resim.......: ");
        String resim = ifade();
        System.out.println("Tweet.......: ");
        String tweetContent = ifade();
        Tweet tweet = Tweet.builder()
                .userid(userProfile.getId())
                .shareddate(System.currentTimeMillis())
                .image(resim)
                .content(tweetContent)
                .build();
        tweetService.save(tweet);
    }

    private void listTweet(){
        System.out.println("*************************************");
        System.out.println("*******  AKTİF TWEET LİSTESİ  *******");
        System.out.println("*************************************");
        System.out.println();
        tweetService.findAllViewTweet().forEach(t->{
            System.out.println("-----------------------------------------");
            System.out.println("tweetid......: "+ t.getId());
            System.out.println(t.getNickName()+ "  -> "+ t.getUsername());
            System.out.println();
            System.out.println(t.getContent());
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.printf("  Y[%s]     R[%s]   L[%s]    W[%s]  \n",
                    t.getTweetcomment(),t.getRetweet(),t.getTweetlike(),t.getTweetview());
            System.out.println("------------------------------------------");
            System.out.println();
        });
        int secim;
        do{
            System.out.println("1- Görüntüle");
            System.out.println("0- <<< Geri");
            secim = secim();
            if(secim == 1){
                System.out.print("Hangi Tweet i görüntüleyeceksiniz.....: ");
                int id = secim();
                tweetDetail(id);
            }
        }while (secim!=0);

    }

    /**
     *
     * @param tweetId
     */
    public void tweetDetail(long tweetId){
        int secim;
        do{
            goruntulenmeArttir(tweetId);
            VwTweet tweet = tweetService.findVwTweetById(tweetId).get();
            Map<Long, VwUserProfile> userList = userProfileService.findAllVwUserList();
            System.out.println("-----------------------------------------");
            System.out.println("tweetid......: "+ tweet.getId());
            System.out.println(tweet.getNickName()+ "  -> "+ tweet.getUsername());
            System.out.println();
            System.out.println(tweet.getContent());
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.println(".........................................");
            System.out.printf("  Y[%s]     R[%s]   L[%s]    W[%s]  \n",
                    tweet.getTweetcomment(),tweet.getRetweet(),tweet.getTweetlike(),tweet.getTweetview());
            System.out.println("------------------------------------------");
            System.out.println();
            System.out.println("  YORUMLAR");
            commentService.findByTweetId(tweetId).forEach(c->{
                VwUserProfile user = userList.get(c.getUserid());
                System.out.println(user.getUsername()+" -> "+ c.getComment());
            });
            System.out.println("1- Yorum Yap");
            System.out.println("2- Beğeni Yap");
            System.out.println("0- <<< Geri");
            System.out.print("Seçiniz.....: ");
            secim = secim();
            switch (secim){
                case  1: yorumYap(tweetId);break;
                case  2: break;
            }
        }while (secim!=0);
    }

    public void yorumYap(Long tweetId){
        System.out.print("Yorum yaz.......: ");
        String yorum = ifade();
        commentService.save(Comment.builder()
                        .userid(userProfile.getId())
                        .comment(yorum)
                        .tweetid(tweetId)
                        .commentdate(System.currentTimeMillis())
                .build());
        yorumArttir(tweetId);
    }

    private void goruntulenmeArttir(Long tweetID){
       Tweet tweet =  tweetService.findById(tweetID).get();
       tweet.setTweetview(tweet.getTweetview()+1);
       tweetService.update(tweet);
    }
    private void yorumArttir(Long tweetID){
        Tweet tweet =  tweetService.findById(tweetID).get();
        tweet.setTweetcomment(tweet.getTweetcomment()+1);
        tweetService.update(tweet);
    }

}
