package com.sdproject.aust.dailyneeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class contacts_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contuctslayout);
    }

    public void contucts_radiobutton(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.contacts_radiobuton_cr:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.contacts_radiobuton_teacher:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}