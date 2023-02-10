package com.muhammet.controllerspring;

import com.muhammet.TweetterSpringWebApplication;
import com.muhammet.repository.entity.Tweet;
import com.muhammet.service.TweetService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweeterRestController {

    private final TweetService tweetService;

    public TweeterRestController(){
        this.tweetService = new TweetService();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Tweet>> findAllTweet(){
        return  ResponseEntity.ok(tweetService.findAll());
    }
}
