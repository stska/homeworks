package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.security.Policy;

//import androidx.appcompat.widget.SearchView;

public class MainActivity extends AppCompatActivity implements InitialFragment.OnItemClickedListener{
     @Override
     public void OnItemClicked(Policy.Parameters recieveparams){
         Toast.makeText(getApplicationContext(), "AAAAAAAAAAAAAAAAAAAA)", Toast.LENGTH_SHORT).show();
     }
    //данные для подргуки в избранное. Особой роли не играбт, так как делал для тренировки. Потом буду подгружать туда данные из поиска
    public void testMeth(){

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main_activity);



    }



    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResumer()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), "onResume");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), "onDestroy");
    }
    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();

            //additional code
        } else {
            getSupportFragmentManager().popBackStack();


        }

    }




}

