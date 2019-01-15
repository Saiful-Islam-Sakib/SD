package com.sdproject.aust.dailyneeds;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class events_Activity extends AppCompatActivity {

    private EditText send_et;
    private TextView events_tv;
    private LinearLayout linearLayout;

    private DatabaseReference firebaseDatabase;
    private DatabaseReference databaseReference_CR;
    private FirebaseAuth firebaseAuth;
    private String current_user;
    private boolean person_type = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("EVENTS");

        linearLayout = (LinearLayout) findViewById(R.id.events_scrollView_linearlayout);
        send_et = (EditText) findViewById(R.id.events_et);

        firebaseAuth = FirebaseAuth.getInstance();

        current_user = firebaseAuth.getCurrentUser().getEmail();

        //databaseReference_MAIN = FirebaseDatabase.getInstance().getReference();
        databaseReference_CR = FirebaseDatabase.getInstance().getReference().child("CR");

        databaseReference_CR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot x: dataSnapshot.getChildren()){
                    if (Objects.equals(x.child("email").getValue(), current_user)){
                        current_user = x.getKey();
                        person_type = true;
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(events_Activity.this, "you are not CR", Toast.LENGTH_SHORT).show();
            }
        });

        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                linearLayout.removeAllViewsInLayout();
                for (DataSnapshot x: dataSnapshot.getChildren()){
                    events_tv = new TextView(events_Activity.this);

                    String temp_str = x.getValue().toString().trim();
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    events_tv.setText(temp_str);
                    events_tv.setBackgroundResource(R.drawable.custom_text_view);
                    events_tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
                    events_tv.setTextColor(getResources().getColor(R.color.light_1));
                    params.setMargins(10,10,10,10);
                    events_tv.setLayoutParams(params);

                    linearLayout.addView(events_tv);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(events_Activity.this, "Failed to read", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void send_events_button(View view) {
        if (person_type){
            if (send_et.getText().equals("")){
                Toast.makeText(this, "Please type something", Toast.LENGTH_SHORT).show();
            }else {
                String temp_str = send_et.getText().toString().trim();
                firebaseDatabase.push().setValue(temp_str);
                send_et.setText("");
            }
        }else {
            send_et.setText("");
            Toast.makeText(this, "you are not CR", Toast.LENGTH_SHORT).show();
        }

    }
}
