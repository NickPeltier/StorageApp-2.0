package com.example.nickp.storageapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nickp on 3/4/2016.
 */
public class Settings extends AppCompatActivity implements View.OnClickListener
{

    /**
     *
     * @param savedInstanceState
     *
     * This method is called everytime the "Settings" tab is selected by the user.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }


    /**
     *
     * @param v
     *
     * v is the view on the screen (.xml layout file (Location: app/res/layout))
     *
     * Method that is called everytime the user touches the screen
     */
    @Override
    public void onClick(View v) {

    }
}
