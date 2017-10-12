package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DesignGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_gallery);
    }

    public void DesignOrder(View view){
        Intent i = new Intent (DesignGallery.this,DesignOrder.class);
        startActivity(i);

    }
}
