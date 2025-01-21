package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewContactClickHandler {

    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context,MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitButtonClickHandler(View view){
        if (contacts.getName()==null || contacts.getEmail()==null){
            Toast.makeText(context,"Fields Cant be empty", Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(context, MainActivity.class);
            /*intent.putExtra("Name",contacts.getName());
            intent.putExtra("Email",contacts.getEmail());*/
            Contacts c = new Contacts(contacts.getName(), contacts.getEmail());
            myViewModel.addAllContacts(c);

            context.startActivity(intent);
        }

    }

}
