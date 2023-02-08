package com.muhammet.service;

import com.muhammet.repository.UserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.MyFactoryService;

public class UserProfileService extends MyFactoryService<UserProfileRepository, UserProfile,Long> {

    public UserProfileService(){
        super(new UserProfileRepository());
    }

    public boolean existByUsername(String username){
            return getRepository().existByUsername(username);
    }
}
