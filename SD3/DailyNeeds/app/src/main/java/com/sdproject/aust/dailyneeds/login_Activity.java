package com.sdproject.aust.dailyneeds;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_Activity extends AppCompatActivity {

    private EditText email_et, password_et;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(login_Activity.this,home_Activity.class));
                    login_Activity.this.finish();
                }
            }
        };

        email_et = (EditText) findViewById(R.id.login_email_et);
        password_et = (EditText) findViewById(R.id.login_password_et);

        progressDialog = new ProgressDialog(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public void login_ok(View view) {

        if (email_et.getText() == null || password_et.getText() == null) {
            Toast.makeText(this, "Fill all the gapes", Toast.LENGTH_SHORT).show();
            return;
        } else {
            progressDialog.setMessage("Loging in...");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(email_et.getText().toString().trim(), password_et.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(login_Activity.this, "Successfully Loged in", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login_Activity.this,home_Activity.class));
                                login_Activity.this.finish();
                            } else {
                                Toast.makeText(login_Activity.this, "wrong password or email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void login_forgotpass(View view) {
        //future work or last job
    }
}
