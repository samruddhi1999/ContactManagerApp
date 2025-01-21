package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    //If you need Context inside your ViewModel
    //you should use AndroidVieModel(AVM).
    //Because it contains the application context.

    private Repository myRepository;
    //LiveData
    private LiveData<List<Contacts>> allContacts;


    public MyViewModel(@NonNull Application application ) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addAllContacts(Contacts contacts){
        myRepository.addContacts(contacts);
    }

    public void deleteContacts(Contacts contacts){
        myRepository.deleteContacts(contacts);
    }
}
