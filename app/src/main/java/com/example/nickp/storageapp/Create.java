package com.example.nickp.storageapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Create extends AppCompatActivity implements  View.OnClickListener{
    EditText name;                                              //Name of the Inventory textbox
    Button finish;                                              //Button to finish the adding method
    String invName = "";                                        //Name of the Inventory
    private static final String END_OF_FILE_NAME = ".txt";
    private String fName;
    private static final String INV_FOLDER = "Inventories";


    /**
     *
     * @param savedInstanceState
     *
     * This method is called everytime the "Add new Inventory" button is selected by the user.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Create the screen with the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //Toolbar on the side of the screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Assign variables to widets on the layout file and initiate them as being clickable
        name = (EditText)findViewById(R.id.invName);
        finish = (Button) findViewById(R.id.nextButt);
        finish.setOnClickListener(this);
        name.setOnClickListener(this);
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
    public void onClick(View v)
    {
        //If the user tapped the finish button
        if(v == finish)
        {
            invName = name.getText().toString();

            if(invName != "")
            {
                fName = invName + END_OF_FILE_NAME;
                boolean copy = checkFilename();
            }
        }
    }

    //Method to ceck to see if file exists
    private boolean checkFilename(){
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, fName);

        if(!file.exists()){
            file.mkdirs();
            return false;
        }

        else
        {
            return true;
        }
    }


}
