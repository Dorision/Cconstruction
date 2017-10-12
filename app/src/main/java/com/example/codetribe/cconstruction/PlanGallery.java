package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PlanGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_gallery);
    }

    public void PlanOrder(View view){
        Intent i = new Intent (PlanGallery.this,OrderPlans.class);
        startActivity(i);

    }
}
