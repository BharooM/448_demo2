package com.example.eli.a448_demo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class Homepage extends AppCompatActivity
{
    ImageView image;
    ImageView result;
    DrawerLayout dLayout;
    ActionBarDrawerToggle aToggle;
    NavigationView nView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTitle("Healthy Belly");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        image = (ImageView) findViewById(R.id.image);
        result = (ImageView) findViewById(R.id.result_image);
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        aToggle = new ActionBarDrawerToggle(this, dLayout, R.string.open, R.string.close);
        nView = (NavigationView) findViewById(R.id.navigation_view);

        nView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.log_out:
                        openMainActivity();
//                    case R.id.about_us:
//                    case R.id.delete_profile:
//                    case R.id.help_contact:
//                    case R.id.payment:
//                    case R.id.history:
//                    case R.id.update_profile:
//                    case R.id.search:
                }
                return true;
            }
        });

        dLayout.addDrawerListener(aToggle);
        aToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        image.setImageBitmap(bitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (aToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openMainActivity()
    {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
