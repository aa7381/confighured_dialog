package com.example.confighured_dialog;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    /**
     * AlertDialog builder
     */
    AlertDialog.Builder adb;

    /**
     * all the button
     */
    Button button1, button2, button3, button4;

    /**
     * create this to change the background color
     */
    View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        mainLayout = findViewById(R.id.mainLayout);
    }


    public void clicked1(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("random message");
        adb.setMessage("hello");

        final String[] colors = {"Red", "Green", "Blue"};

        int[] color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(/* context: */ this);

        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                mainLayout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void clicked2(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("random message");
        adb.setMessage("hello");

        final String[] colors = {"Red", "Green", "Blue"};

        int[] color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(/* context: */ this);

        adb.setTitle("List of colors - multi choice");

        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setMultiChoiceItems(colors, /* checkedItems: */ null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mainLayout.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void clicked3(View view )
    {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("random message");
        adb.setMessage("hello");


        adb = new AlertDialog.Builder(/* context: */ this);

        adb.setTitle("List of colors - multi choice");

        adb.setNegativeButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mainLayout.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void clicked4(View view )
    {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("random message");
        adb.setMessage("hello");

        final EditText eT = new EditText( this);
        eT.setHint("Type text here!");
        adb.setView(eT);

        adb.setPositiveButton("copy ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eT.getText().toString();
                dialog.cancel();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();

    }
}



