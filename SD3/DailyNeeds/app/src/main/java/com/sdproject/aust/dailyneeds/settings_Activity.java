package com.sdproject.aust.dailyneeds;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class settings_Activity extends AppCompatActivity {

    private String current_user, person_type, section;

    private EditText id_et, semester_et, department_et, contactNumber_et;
    private RadioButton A_rb, B_rb, C_rb;

    //private DatabaseReference databaseReference_MAIN;
    private DatabaseReference databaseReference_CR;
    private DatabaseReference databaseReference_OTHER;

    private FirebaseAuth firebaseAuth;

    private boolean radiobuton_clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setings);

        id_et = (EditText) findViewById(R.id.settings_et_id);
        semester_et = (EditText) findViewById(R.id.settings_et_semester);
        department_et = (EditText) findViewById(R.id.settings_et_department);
        contactNumber_et = (EditText) findViewById(R.id.settings_et_contactNumber);

        A_rb = (RadioButton) findViewById(R.id.settings_radiobtn_A);
        B_rb = (RadioButton) findViewById(R.id.settings_radiobtn_B);
        C_rb = (RadioButton) findViewById(R.id.settings_radiobtn_C);

        id_et = (EditText) findViewById(R.id.settings_et_id);
        semester_et = (EditText) findViewById(R.id.settings_et_semester);
        contactNumber_et = (EditText) findViewById(R.id.settings_et_contactNumber);
        department_et = (EditText) findViewById(R.id.settings_et_department);

        firebaseAuth = FirebaseAuth.getInstance();

        current_user = firebaseAuth.getCurrentUser().getEmail();

        //databaseReference_MAIN = FirebaseDatabase.getInstance().getReference();
        databaseReference_CR = FirebaseDatabase.getInstance().getReference().child("CR");
        databaseReference_OTHER = FirebaseDatabase.getInstance().getReference().child("OTHER");

        databaseReference_CR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot x: dataSnapshot.getChildren()){
                    if (Objects.equals(x.child("email").getValue(), current_user)){
                        current_user = x.getKey();
                        person_type = "CR";
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(settings_Activity.this, "Failed to read cr", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference_OTHER.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot x: dataSnapshot.getChildren()){
                    if (Objects.equals(x.child("email").getValue(), current_user)){
                        current_user = x.getKey();
                        person_type = "OTHER";
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(settings_Activity.this, "Failed to read other", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setings_save_button(View view) {
        Toast.makeText(this, "user: " + current_user, Toast.LENGTH_SHORT).show();
        if (radiobuton_clicked && id_et.getText() != null && semester_et.getText() != null && department_et.getText() != null && !contactNumber_et.getText().equals("+880")) {
            if (person_type.equals("CR")) {
                databaseReference_CR = databaseReference_CR.child(current_user);

                databaseReference_CR.child("section").setValue(section);
                databaseReference_CR.child("id").setValue(id_et.getText().toString().trim());
                databaseReference_CR.child("semester").setValue(semester_et.getText().toString().trim());
                databaseReference_CR.child("department").setValue(department_et.getText().toString().trim());
                databaseReference_CR.child("contactNumber").setValue(contactNumber_et.getText().toString().trim());

            } else if (person_type.equals("OTHER")) {
                databaseReference_OTHER = databaseReference_CR.child(current_user);

                databaseReference_OTHER.child("section").setValue(section);
                databaseReference_OTHER.child("id").setValue(id_et.getText().toString().trim());
                databaseReference_OTHER.child("semester").setValue(semester_et.getText().toString().trim());
                databaseReference_OTHER.child("department").setValue(department_et.getText().toString().trim());
                databaseReference_OTHER.child("contactNumber").setValue(contactNumber_et.getText().toString().trim());
            }
        } else {
            Toast.makeText(this, "Fill all the gapes", Toast.LENGTH_SHORT).show();
        }
    }

    public void section_selection(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.settings_radiobtn_A:
                if (checked){
                    radiobuton_clicked = true;
                    section = "A";
                    Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.settings_radiobtn_B:
                if (checked){
                    radiobuton_clicked = true;
                    section = "B";
                    Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.settings_radiobtn_C:
                if (checked){
                    radiobuton_clicked = true;
                    section = "C";
                    Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
