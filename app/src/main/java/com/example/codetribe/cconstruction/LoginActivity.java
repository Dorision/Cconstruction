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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewRegister;
    private Button buttonLogin;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity here
            finish();
            startActivity(new Intent( getApplicationContext(), MainActivity.class));
        }

        editTextEmail=(EditText) findViewById(R.id.email_address);
        editTextPassword=(EditText) findViewById(R.id.password);
        textViewRegister=(TextView) findViewById(R.id.register);
        buttonLogin=(Button) findViewById(R.id.login);


        buttonLogin.setOnClickListener(this);
        textViewRegister.setOnClickListener(this);



    }

    public void UserLogin(){
        String email= editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

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

        progressDialog.setMessage("User Logging in..");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                  //start profile activity
                    finish();
                    startActivity(new Intent( getApplicationContext(), MainActivity.class));
                }


            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogin){
            UserLogin();
        }
        if(v==textViewRegister){
            finish();
            startActivity( new Intent(this,RegisterActivity.class));
        }

    }
    public void Reset(View view){
        Intent i = new Intent (LoginActivity.this, Reset.class);
        startActivity(i);

    }

    public void Admin(View view){
        Intent i = new Intent (LoginActivity.this, admin_login.class);
        startActivity(i);

    }

}
