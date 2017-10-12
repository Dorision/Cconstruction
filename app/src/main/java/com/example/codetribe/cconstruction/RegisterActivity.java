package com.example.codetribe.cconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Profile");

        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity here
            finish();
            startActivity(new Intent( getApplicationContext(), LoginActivity.class));
        }


        editTextName=(EditText) findViewById(R.id.register_namel);
        editTextEmail=(EditText) findViewById(R.id.register_email);
        editTextPassword=(EditText) findViewById(R.id.register_password);
        editTextConfirmPassword=(EditText) findViewById(R.id.register_confirm_password);
       buttonRegister=(Button) findViewById(R.id.actual_register);

        buttonRegister.setOnClickListener(this);
    }

    public void registerUser(){


        final String userNamE = editTextName.getText().toString().trim();
        final String email = editTextEmail.getEditableText().toString().trim();
        if (TextUtils.isEmpty(userNamE)) {

            Toast.makeText(getApplicationContext(), "please, enter your name", Toast.LENGTH_LONG).show();
            return;

        }


        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        // onClick of button perform this simplest code.
        if (email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }
        final String password=editTextPassword.getText().toString().trim();
        final String confirmpassword=editTextConfirmPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //enter an email address
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            //stopping the function execution
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

        if(TextUtils.isEmpty(confirmpassword)){
            //password is empty
            Toast.makeText(this, "please enter confirm password",Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (password.length() !=confirmpassword.length()) {

            Toast.makeText(getApplicationContext(), "password does not match confirm password", Toast.LENGTH_SHORT).show();

            return;
        }



        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //user is successfully registered or logged in
                    finish();

                    String password = editTextPassword.getText().toString().trim();
                    String confirmpassword = editTextConfirmPassword.getText().toString().trim();
                    String userNamE = editTextName.getText().toString().trim();
                    String email = editTextEmail.getEditableText().toString().trim();


                    final String id = task.getResult().getUser().getUid();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    progressDialog.setMessage("Registering please wait..");
                    progressDialog.show();


                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                    databaseReference = databaseReference.getRef().child("Profile");
                    UpdateProfile userprofile = new UpdateProfile(userNamE, email, password, confirmpassword);
                    databaseReference.child(id).setValue(userprofile);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Registration Error", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if(view==buttonRegister){
            registerUser();
        }


    }

}

