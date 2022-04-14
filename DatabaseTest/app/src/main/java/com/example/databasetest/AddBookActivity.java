package com.example.databasetest;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Button add = (Button) findViewById(R.id.add);
        EditText name = (EditText) findViewById(R.id.name);
        EditText author = (EditText) findViewById(R.id.author);
        EditText price = (EditText) findViewById(R.id.price);
        EditText pages = (EditText) findViewById(R.id.pages);
        EditText category_id = (EditText) findViewById(R.id.category_id);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 5);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = author.getText().toString();
                String a2 = price.getText().toString();
                String a3 = pages.getText().toString();
                String a4 = name.getText().toString();
                String a5 = category_id.getText().toString();
                if (!a1.equals("") && !a2.equals("") && !a3.equals("") && !a4.equals("") && !a5.equals("") ) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into Book values(?,?,?,?,?)", new Object[]{a1, a2, a3, a4, a5});
                    Toast.makeText(AddBookActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}