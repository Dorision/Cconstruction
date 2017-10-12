package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.codetribe.cconstruction.R.id.option1;
import static com.example.codetribe.cconstruction.R.id.option2;

public class DesignOrder extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private TextView textOption1;
    private TextView textOption2;
    private TextView textOption3;
    private EditText editTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_order);

        editTextName=(EditText) findViewById(R.id.name_field);
        textOption1=(TextView) findViewById(option1);
        textOption2=(TextView) findViewById(option2);
        textOption3=(TextView) findViewById(R.id.option3);
        editTextDescription=(EditText) findViewById(R.id.description);

        textOption1.setOnClickListener(this);
        textOption2.setOnClickListener(this);
        textOption3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==textOption1){
            String option1 = textOption1.getText().toString().trim();
            String name = editTextName.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:rufustman@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, name);
            intent.putExtra(Intent.EXTRA_TEXT, option1);

            startActivity(Intent.createChooser(intent, "Send Email"));
        }

        if(v==textOption2){
            String option2 = textOption2.getText().toString().trim();
            String name = editTextName.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:rufustman@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, name);
            intent.putExtra(Intent.EXTRA_TEXT, option2);

            startActivity(Intent.createChooser(intent, "Send Email"));
        }

        if(v==textOption3){
            String option3 = textOption3.getText().toString().trim();
            String name = editTextName.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:rufustman@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, name);
            intent.putExtra(Intent.EXTRA_TEXT, option3);
            startActivity(Intent.createChooser(intent, "Send Email"));
        }

    }

    public void Description(View view){

        String name = editTextName.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:rufustman@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, name);
        intent.putExtra(Intent.EXTRA_TEXT, description);

        startActivity(Intent.createChooser(intent, "Send Email"));

    }
}
