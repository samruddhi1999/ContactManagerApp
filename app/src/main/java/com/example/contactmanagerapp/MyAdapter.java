package com.example.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactVieHolder> {

    private ArrayList<Contacts> contactsArrayList;

    public MyAdapter(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public ContactVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating new View holders for items in recyclerView

        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false);
        return new ContactVieHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVieHolder holder, int position) {
        //Called by recyclerView when it needs to display or update an item
        //at a specific position in the list or grid

        Contacts currentContact = contactsArrayList.get(position);
        holder.contactListItemBinding.setContact(currentContact);
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        //Determines the total number of items in the dataset that will be displayed in the recyclerview

        if (contactsArrayList != null) {
            return contactsArrayList.size();
        } else {
            return 0;
        }
    }

    class ContactVieHolder extends RecyclerView.ViewHolder {
        private ContactListItemBinding contactListItemBinding;


        public ContactVieHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }


}
