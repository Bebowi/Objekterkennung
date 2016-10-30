package de.bebowi.objekterkennung;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;
import static de.bebowi.objekterkennung.R.layout.cam;

/**
 * Created by benny on 18.10.16.
 */

public class Cam2 extends AppCompatActivity {

    // Deklarieren und initialisieren der View Elemente
    private TextView txtView0 = null;
    private TextView textView1 = null;
    private TextureView textureView = null;

    // Kamera daklarieren und initialisieren
    private CameraDevice cam = null;
    private CameraDevice.StateCallback camStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {
            cam = camera;
            Toast.makeText(getApplicationContext(), "Kamera verbunden", Toast.LENGTH_SHORT).show();
           // startPreview();
        }

        @Override
        public void onDisconnected(CameraDevice camera) {

        }

        @Override
        public void onError(CameraDevice camera, int error) {

        }
    };

    // Liste von allen verfügbaren Kameras deklariert und initialisiert
    private String[] camID = null;

    // Kameramanager zur Verwaltung der Kamera
    private CameraManager manager = null;


    // Kamera setup
    private void setupCam(){

        // Kameramanager zur Verwaltung der Kamera
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            camID = manager.getCameraIdList();

            // Zeigt alle Eigenschaften der gewählten Kamera an
            CameraCharacteristics cameraCharacteristics = manager.getCameraCharacteristics(camID[0]);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    /**** Verbindung mit der Kamera ***/

    // Zugriffsrechte
    private static final int REQUEST_CAMERA_PERMISSION_RESULT = 0;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CAMERA_PERMISSION_RESULT){
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "Kamerazugriff benötigt", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Kamera verbinden
    private void verbindeCam() {
        try {
            /** Zugriffsrechte überprüfen **/
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    manager.openCamera(camID[0], camStateCallback, null);
                } else {
                    if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(this, "Die App brauch Kamerazugriff", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION_RESULT);
                }
            } else {
                manager.openCamera(camID[0], camStateCallback, null);
            }
            /*******************************/
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam2);

        //Instanzieren der View Elemente
        this.txtView0 = (TextView) findViewById(R.id.txtView0);
        this.textView1 = (TextView) findViewById(R.id.textView1);
        this.textureView = (TextureView) findViewById(R.id.textureView);

        // Hole Liste der Verfügbaren Kameras
        setupCam();

        // Kamera mit ID=0 verbinden
        verbindeCam();



        try{
            /*this.txtView0.setText("Geht");

            //this.manager.AvailabilityCallback;
            String[] camID = manager.getCameraIdList();

            this.textView1.setText("Kameras erkannt");*/

   /*        CameraDevice.StateCallback deviceCallback = new CameraDevice.StateCallback(){

               public void onOpened(CameraDevice camera){


                   System.out.println("Die onOpened Methode wurde aufgerufen");

                   camDev = camera;

                   //videoView0.start();
                  // System.out.println(videoView0.isPlaying());

          *//*         // Create an implicit intent, for image capture.
                   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                   int REQUEST_ID_IMAGE_CAPTURE = 100;

                    // Start camera and wait for the results.
                   this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);*//*

               }

               public void onDisconnected(CameraDevice camera){
                   camera.close();
               };

               public void onError(CameraDevice camera, int error){
                   camera.close();
               };
            };*/

           /* this.textView1.setText("StateCallback geht auch");




            List<Surface> surfaces = new ArrayList<>();
            Surface previewSurface = new Surface(surfaceView);

            //camDev.createCaptureSession();


           // @RequiresPermission(Manifest.permission.CAMERA)
          //  int permissionCheck = ContextCompat.checkSelfPermission(Cam2, Manifest.permission.CAMERA);
            manager.openCamera("0", deviceCallback, null);

            camDev.TEMPLATE_MANUAL;

            videoView0.start();


            this.textView1.setText("openCamera geht");*/

           // this.textView1.setText(camID[0]+", "+camID[1]);
        } catch(Exception e){this.txtView0.setText("Fehler");}



    }


}
