package com.maxprof90.myphonebook.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.maxprof90.myphonebook.R;

public class AddContactsActivity extends AppCompatActivity {

    EditText fName, lName, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


    }
}