package com.example.nickp.storageapp;

import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

/**
 * Created by nickp on 2/20/2016.
 *
 * This class is for scanning barcodes.
 * It uses the camera.xml file as the layout (Location: app/res/layout)
 */
public class Cam extends MainActivity {
    private GoogleApiClient client;

    SurfaceView cameraView;                 //Camara view object
    TextView barcodeInfo;                   //Textbox that will display barcode info

    BarcodeDetector barcodeDetector;        //Object that detects barcodes
    CameraSource cameraSource;              //Object tha tattaches BarcodeDetector to camera

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;


    /**
     *
     * @param savedInstanceState
     *
     * This method is called everytime the "Import" tab is selected by the user.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create the screen with the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        //Assign variables to widgets on the screen (ID's in .XML file)
        cameraView = (SurfaceView) findViewById(R.id.camera_view);
        barcodeInfo = (TextView) findViewById(R.id.code_info);

        //Variable for the barcode scanner object
        barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        //Variable to set the camera to look for barcodes
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .setAutoFocusEnabled(true)
                .build();


        //Method for calling the camera to turn on
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    cameraSource.start(cameraView.getHolder());
                } catch (IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }
            }

            //Method to assign the barcode detector object to the camera view
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Size p = cameraSource.getPreviewSize();

                //Set the processor for barcode scanning (Other option is facial recognition)
                barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
                    @Override
                    public void release() {
                    }

                    @Override
                    public void receiveDetections(Detector.Detections<Barcode> detections) {
                        final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                        if (barcodes.size() != 0) {
                            barcodeInfo.post(new Runnable() {    // Use the post method of the TextView
                                public void run() {
                                    barcodeInfo.setText(    // Update the TextView
                                            barcodes.valueAt(0).displayValue
                                    );
                                }
                            });
                        }
                    }
                });
            }

            //Method that will turn the camera off when the surface is closed
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        //btn to close the application
        ImageButton imgClose = (ImageButton) findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             *
             * view is the view on the screen (.xml layout file (Location: app/res/layout))
             *
             * Method that is called when the user clicks the "X" button
             */
            @Override
            public void onClick(View view) {
                //Close the screen
                System.exit(0);
            }
        });
    }
}