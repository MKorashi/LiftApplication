package com.example.dell.lift.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.dell.lift.AppDatabase;
import com.example.dell.lift.Entities.User;

import java.util.ArrayList;

/**
 * Created by Dell on 22-Aug-17.
 */


    public class UserViewModel extends AndroidViewModel {


        private AppDatabase appDatabase;

        public UserViewModel(Application application) {
            super(application);

            appDatabase = AppDatabase.getDatabase(this.getApplication());

        }

    public void addBorrow(final User user) {
        new addAsyncTask(appDatabase).execute(user);
    }

    public void deleteUser(User user) {
            new deleteAsyncTask(appDatabase).execute(user);
        }

        private static class deleteAsyncTask extends AsyncTask<User, Void, Void> {

            private AppDatabase db;

            deleteAsyncTask(AppDatabase appDatabase) {
                db = appDatabase;
            }

            @Override
            protected Void doInBackground(final User... params) {
                db.getUsersDao().delete(params);
                return null;
            }


        }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User... params) {
            db.getUsersDao().create(params[0]);
            return null;
        }

    }




}
