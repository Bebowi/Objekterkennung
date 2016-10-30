package de.bebowi.objekterkennung;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static de.bebowi.objekterkennung.R.layout.cam;

/**
 * Created by benny on 29.10.16.
 */

public class Cam extends AppCompatActivity {

    private VideoView videoView0 = null;
    private SurfaceView surfaceView = null;

    private TextView txtView0 = null;
    private TextView textView1 = null;

    private Camera mCamera;
    private CameraPreview mPreview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cam);

        this.txtView0 = (TextView) findViewById(R.id.txtView0);
        this.videoView0 = (VideoView) findViewById(R.id.videoView0);
        this.textView1 = (TextView) findViewById(R.id.textView1);
        this.surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        mCamera = getCameraInstance();

       /* mPreview = new CameraPreview(this.mCamera);

        this.
*/

    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }




}
