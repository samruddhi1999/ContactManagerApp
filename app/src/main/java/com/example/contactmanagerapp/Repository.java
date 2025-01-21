package com.example.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    // The available Data resources: Room Database
    private final ContactDAO contactDAO;

    // Executor for background operations
    private final ExecutorService executor;
    // Handler for updating UI on the main thread
    private final Handler handler;

    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDao();

        // Used for background database operations
        executor = Executors.newSingleThreadExecutor();

        // Used for updating the UI (main thread)
        handler = new Handler(Looper.getMainLooper());
    }

    // Methods in DAO executed from the Repository
    public void addContacts(Contacts contacts) {
        executor.execute(() -> {
            // Executes this code asynchronously on a separate thread
            contactDAO.insert(contacts);

            // Update UI if needed, using handler.post() on the main thread
            handler.post(() -> {
                // Perform UI updates if required
            });
        });
    }

    public void deleteContacts(Contacts contacts) {
        executor.execute(() -> {
            contactDAO.delete(contacts);

            handler.post(() -> {
                // Perform UI updates if required
            });
        });
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return contactDAO.getAllContacts();
    }
}
