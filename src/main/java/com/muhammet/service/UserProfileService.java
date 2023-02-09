package com.muhammet.service;

import com.muhammet.repository.UserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.MyFactoryService;

import java.util.Optional;

public class UserProfileService extends MyFactoryService<UserProfileRepository, UserProfile,Long> {

    public UserProfileService(){
        super(new UserProfileRepository());
    }

    public boolean existByUsername(String username){
            return getRepository().existByUsername(username);
    }

    public boolean doLogin(String username,String password){
        return getRepository().doLogin(username,password);
    }

    public Optional<UserProfile> findByUsername(String username){
        return getRepository().findByUsername(username);
    }
}
