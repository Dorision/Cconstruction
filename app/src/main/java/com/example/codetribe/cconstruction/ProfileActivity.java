package com.example.codetribe.cconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText  editFirstname;
    private EditText editLastname;
    private EditText editEmailAddress;
    private EditText editIdentity;
    private EditText editGender;
    private EditText editLocation;
    private EditText editPassword1;
    private EditText editConfirmPassword1;
    private Button buttonSubmit;
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressDialog=new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference().child("Profile");


        editFirstname=(EditText) findViewById(R.id.firstname);
        editLastname= (EditText) findViewById(R.id.lastname);
        editEmailAddress= (EditText) findViewById(R.id.email_address);
        editIdentity= (EditText) findViewById(R.id.id_number);
        editGender = (EditText) findViewById(R.id.gender);
        editLocation= (EditText) findViewById(R.id.location);
        editPassword1 = (EditText) findViewById(R.id.password);
        editConfirmPassword1= (EditText) findViewById(R.id.confirm_password);
        buttonSubmit = (Button) findViewById(R.id.submit);

        buttonSubmit.setOnClickListener(this);


    }









    @Override
    public void onClick(View view) {




        String name= editFirstname.getText().toString();
        String surname=editLastname.getText().toString();
       final  String email=editEmailAddress.getText().toString();
        String identity=editIdentity.getText().toString();
        String gender=editGender.getText().toString();
        String location =editLocation.getText().toString();
        String password=editPassword1.getText().toString();
        String confirmPassword=editConfirmPassword1.getText().toString();


        if (TextUtils.isEmpty(name)) {

            Toast.makeText(getApplicationContext(), "please, enter your name", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(surname)) {

            Toast.makeText(getApplicationContext(), "please, enter your surname", Toast.LENGTH_SHORT).show();
            return;

        }

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(identity)) {

            Toast.makeText(getApplicationContext(), "please, enter your Identity number", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(gender)) {

            Toast.makeText(getApplicationContext(), "please, enter your contacts number", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(location)) {

            Toast.makeText(getApplicationContext(), "please, enter your location", Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "please enter password",Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (password.length() < 8) {

            Toast.makeText(getApplicationContext(), "password too short, please enter 8 characters", Toast.LENGTH_SHORT).show();

            return;
        }

        if(TextUtils.isEmpty(confirmPassword)){
            //password is empty
            Toast.makeText(this, "please enter confirm password",Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (password.length() !=confirmPassword.length()) {

            Toast.makeText(getApplicationContext(), "password does not match confirm password", Toast.LENGTH_SHORT).show();

            return;
        }



        if(view ==buttonSubmit){

           // (String firstName, String lastName, String emailAddress, String location, String identity, String gender, String password, String confirmPassword
            UpdateProfile userprofile = new UpdateProfile(name, surname,email, location, identity, gender, password, confirmPassword);
            databaseReference.setValue(userprofile);

            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            Toast.makeText(getApplicationContext(), "Updated Successfully",Toast.LENGTH_SHORT).show();


            progressDialog.dismiss();
        }


    }
}
