package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Enquire extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquire);

        editTextName=(EditText) findViewById(R.id.name);
        editTextEmail=(EditText) findViewById(R.id.email);
        editTextMessage=(EditText) findViewById(R.id.message);
    }
    public void Submit(View view){

        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:rufustman@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, name);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(intent, "Send Email"));

    }
}
