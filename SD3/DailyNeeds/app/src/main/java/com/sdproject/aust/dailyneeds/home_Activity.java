package com.sdproject.aust.dailyneeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class home_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        firebaseAuth = FirebaseAuth.getInstance();

    }
    public void contacts_button(View view) {
        startActivity(new Intent(home_Activity.this, contacts_Activity.class));
    }

    public void routine_button(View view) {
        startActivity(new Intent(home_Activity.this, routine_Activity.class));
    }

    public void events_button(View view) {
        startActivity(new Intent(home_Activity.this, events_Activity.class));
    }

    public void cgpa_calculator_button(View view) {
        startActivity(new Intent(home_Activity.this, cgpa_calculator_Activity.class));
    }

    public void settings_button(View view) {
        startActivity(new Intent(home_Activity.this, settings_Activity.class));
    }

    public void info_button(View view) {
        startActivity(new Intent(home_Activity.this, info_Activity.class));
    }

    public void logout(View view) {
        firebaseAuth.signOut();
        startActivity(new Intent(this, login_Activity.class));
        this.finish();
    }
}
