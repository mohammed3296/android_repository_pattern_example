package com.mohammedabdullah3296.bindingrecyclerview;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> usersList;
    private UserRepository userRepository;

    public UserViewModel( ) {

        userRepository = new UserRepository(new Application());
        usersList = userRepository.getAllUsers() ;
    }

    public LiveData<List<User>> getUsers() {
        if (usersList == null) {
            usersList = new MutableLiveData<List<User>>();

         }
        return usersList;

    }


}
