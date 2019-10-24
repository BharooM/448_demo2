package com.example.eli.a448_demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity
{
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTitle("Healthy Belly");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openAboutUs();
            }
        });
    }

    public void openAboutUs()
    {
        Intent aboutIntent = new Intent(this, AboutUs.class);
        startActivity(aboutIntent);
    }
}
