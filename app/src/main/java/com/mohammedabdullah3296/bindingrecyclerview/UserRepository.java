package com.mohammedabdullah3296.bindingrecyclerview;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class UserRepository {

    private MutableLiveData<List<User>> allUsers;

    public UserRepository(Application application){
        allUsers = new MutableLiveData<>() ; 
        loadUsers();
    }

      void loadUsers() {

        ApiInterface apiService1 =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<User>> call1 = apiService1.getUsers("135");
        call1.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, retrofit2.Response<List<User>> response) {
                int statusCode = response.code();
                allUsers.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
    }



    public MutableLiveData<List<User>> getAllUsers() {
        return allUsers;
    }
}