package com.sdproject.aust.dailyneeds;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

//signup activity
public class MainActivity extends AppCompatActivity {

    private boolean radiobuton_clicked = false;
    private EditText username_et, email_et, password_et, confirmpassword_et;
    private RadioButton cr_rb, other_rb;
    private String cr_str = "CR", other_str = "OTHER";
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuth_state_listener;

    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference_CR;
    private DatabaseReference databaseReference_OTHER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference_CR = FirebaseDatabase.getInstance().getReference().child("CR");
        databaseReference_OTHER = FirebaseDatabase.getInstance().getReference().child("OTHER");

        progressDialog = new ProgressDialog(this);

        cr_rb = (RadioButton) findViewById(R.id.signup_radiobutton_cr);
        other_rb = (RadioButton) findViewById(R.id.signup_radiobutton_other);

        username_et = (EditText) findViewById(R.id.signup_username_et);
        email_et = (EditText) findViewById(R.id.signup_email_et);
        password_et = (EditText) findViewById(R.id.signup_passwor_et);
        confirmpassword_et = (EditText) findViewById(R.id.signup_confirmpasswor_et);

        firebaseAuth_state_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(MainActivity.this,home_Activity.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(firebaseAuth_state_listener);
    }

    public void signup_button(View view) {
        //after inserting data into a database
        //including cr or others
        //if others then sending option in events will be disable

        if (!radiobuton_clicked || username_et.getText() == null || email_et.getText() == null || password_et.getText() == null || confirmpassword_et.getText() == null) {
            Toast.makeText(this, "Fill all the blanks", Toast.LENGTH_SHORT).show();
        } else if (radiobuton_clicked
                && username_et.getText() != null
                && email_et.getText() != null
                && password_et.getText() != null
                && confirmpassword_et.getText() != null
                && Objects.equals(password_et.getText().toString(),confirmpassword_et.getText().toString()) ){

            // add data to my MyFireBase database project (database write)
            progressDialog.setMessage("Signing Up...");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email_et.getText().toString().trim(), password_et.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                information inf = null;

                                if (cr_rb.isChecked()){
                                    inf = new information(email_et.getText().toString().trim(),password_et.getText().toString(),"0","0","0","0","0");
                                    databaseReference_CR.child(username_et.getText().toString().trim()).setValue(inf);
                                } else if (other_rb.isChecked()){
                                    inf = new information(email_et.getText().toString().trim(),password_et.getText().toString(),"0","0","0","0","0");
                                    databaseReference_OTHER.child(username_et.getText().toString().trim()).setValue(inf);
                                }

                                Toast.makeText(MainActivity.this, "Successfully Created & saved data", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(MainActivity.this, login_Activity.class));
                                MainActivity.this.finish();
                            }
                            else
                                Toast.makeText(MainActivity.this, "Could not create, please try again", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    public void login_button(View view) {
        startActivity(new Intent(MainActivity.this,login_Activity.class));
        MainActivity.this.finish();
    }

    public void signup_radiobutton(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.signup_radiobutton_cr:
                if (checked){
                    radiobuton_clicked = true;
                    Toast.makeText(this, "cr", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.signup_radiobutton_other:
                if (checked){
                    radiobuton_clicked = true;
                    Toast.makeText(this, "other", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
