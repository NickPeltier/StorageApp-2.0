package com.example.nickp.storageapp;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.hardware.camera2.*;
import android.hardware.Camera;

import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;

/**
 * Created by nickp on 2/20/2016.
 *
 * This class is used to create the open the camera and use it as a view that can be called at
 * any tim.
 *
 * The camera is assigned to the surface holder object after the class validates that the device
 * has a camera, and that the user has given the application permission to access the camera.
 *
 * Orientation is also adjusted.
 */
public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
    private GoogleApiClient client;
    private SurfaceHolder mHolder;
    private Camera mCamera;

    /**
     *
     * @param context
     * @param camera
     *
     * Contect is the view that is using this class
     * Camera is the camera on the device using the class
     */
    public CameraView(Context context, Camera camera) {
        super(context);

        mCamera = camera;
        mCamera.setDisplayOrientation(90);
        //get the holder and set this class as the callback, so we can get camera data here
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            //when the surface is created, we can set the camera to draw images in this surfaceholder
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d("ERROR", "Camera error on surfaceCreated " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        //before changing the application orientation, you need to stop the preview, rotate and then start it again
        if (mHolder.getSurface() == null)//check if the surface is ready to receive camera data
            return;

        try {
            mCamera.stopPreview();
        } catch (Exception e) {
            //this will happen when you are trying the camera if it's not running
        }

        //now, recreate the camera preview
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d("ERROR", "Camera error on surfaceChanged " + e.getMessage());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //our app has only one screen, so we'll destroy the camera in the surface
        //if you are unsing with more screens, please move this code your activity
        mCamera.stopPreview();
        mCamera.release();
    }
}