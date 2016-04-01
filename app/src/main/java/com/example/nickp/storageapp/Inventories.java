package com.example.nickp.storageapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.OutputStreamWriter;

/**
 * Created by nickp on 2/29/2016.
 */
public class Inventories extends AppCompatActivity implements View.OnClickListener
{
    private static final String END_OF_FILE_NAME = ".txt";
    private static String FILE_NAME;
    private static final String INV_FOLDER = "Inventories";
    private static String invName;

    File directory = new File("/app/res/raw");

    EditText title;
    Button firstButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventories);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //setSupportActionBar(toolbar);

        title = (EditText)findViewById(R.id.parnt);
        firstButt = (Button)findViewById(R.id.inv1);


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

    }


    public void saveClicked(View v) {
/*
        try {

            OutputStreamWriter out=

                    new OutputStreamWriter(openFileOutput(STORETEXT, 0));

            out.write(txtEditor.getText().toString());

            out.close();

            Toast

                    .makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG)

                    .show();

        }

        catch (Throwable t) {

            Toast

                    .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)

                    .show();

        }*/

    }
}
