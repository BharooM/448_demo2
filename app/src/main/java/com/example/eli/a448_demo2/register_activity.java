package com.example.eli.a448_demo2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register_activity extends AppCompatActivity
{
    private Button submitButton;
    //private TextInputLayout passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        submitButton = (Button) findViewById(R.id.submit_button);
        //passwordInput = (TextInputLayout) findViewById(R.id.password_input);

        //passwordInput.setPasswordVisibilityToggleEnabled(true);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openLoginActivity();
            }
        });
    }

    public void openLoginActivity()
    {
        Intent loginIntent = new Intent(this, login_activity.class);
        startActivity(loginIntent);
    }

}
