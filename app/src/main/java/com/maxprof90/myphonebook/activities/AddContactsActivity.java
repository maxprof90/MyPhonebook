package com.maxprof90.myphonebook.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.maxprof90.myphonebook.managers.ContactManager;
import com.maxprof90.myphonebook.R;
import com.maxprof90.myphonebook.models.ContactData;

public class AddContactsActivity extends AppCompatActivity {

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btnAdd = findViewById(R.id.btnSaveContact);

        btnAdd.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.firstName)).getText().toString();
            String lastName = ((EditText) findViewById(R.id.lastName)).getText().toString();
            String phone = ((EditText) findViewById(R.id.editTextPhone)).getText().toString();
            String avatar = ((ImageView) findViewById(R.id.imageView)).getDrawable().toString();

            if (name.isEmpty() || phone.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(AddContactsActivity.this, "Нужно заполнить поля", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                ContactManager.getInstance().add(new ContactData(name, lastName, phone));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(AddContactsActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(AddContactsActivity.this, "Успех", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}