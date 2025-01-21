package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandlers {

    private Context context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }

    // This method should be public for data binding to work correctly
    public void onFABClicked(View view) {
        Intent intent = new Intent(context, AddNewContactActivity.class);
        context.startActivity(intent);
    }
}
