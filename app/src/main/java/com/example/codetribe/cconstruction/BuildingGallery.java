package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BuildingGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_gallery);
    }

    public void BuildingOrder(View view){
        Intent i = new Intent (BuildingGallery.this,BuildingOrder.class);
        startActivity(i);

    }
}
