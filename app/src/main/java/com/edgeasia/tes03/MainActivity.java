package com.edgeasia.tes03;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private int i = 0;
    //private CustButton btnTag;
    private int btnId = 0;


    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvas = (RelativeLayout)findViewById(R.id.canvas);
        canvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    btnId++;
                    Button btnTag = new Button(getApplicationContext());
                    btnTag.setText("Button" + String.valueOf(btnId));
                    btnTag.setY(btnId*100);
                    btnTag.setId(btnId);
                    btnTag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("button number", String.valueOf(v.getId()));
                        }
                    });
                    canvas.addView(btnTag, new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT)
                    );
                }
            }
        });
    }
}
