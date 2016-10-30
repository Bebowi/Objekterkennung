package de.bebowi.objekterkennung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Test;

import static de.bebowi.objekterkennung.R.layout.cam2;

public class MainActivity extends AppCompatActivity {

    private Button startButton = null;
    private Button btnStartCam2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.startButton = (Button) findViewById(R.id.button_1);
        this.btnStartCam2 = (Button) findViewById(R.id.button_2);

        this.startButton.setOnClickListener(camListener);
        this.btnStartCam2.setOnClickListener(cam2Listener);
    }



    private View.OnClickListener camListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(v.getContext(), Cam.class));
        }
    };

    private View.OnClickListener cam2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(v.getContext(), Cam2.class));
        }
    };
}
