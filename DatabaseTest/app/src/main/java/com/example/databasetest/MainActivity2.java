package com.example.databasetest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Book> bookList = new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initBooks();
        BookAdapter adapter1 = new BookAdapter(MainActivity2.this, R.layout.book_layout, bookList);
        ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter1);
        Button addBook = (Button) findViewById(R.id.add_book);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, AddBookActivity.class);
                startActivity(intent);
            }
        });


    }
    @SuppressLint("Range")
    private void initBooks() {
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 5);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select b.name,b.price,c.category_name from Book as b,Category as c where b.category_id=c.id", null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setName(cursor.getString(cursor.getColumnIndex("name")));
                book.setPrice(Double.toString(cursor.getDouble(cursor.getColumnIndex("price"))));
                book.setCategory_name(cursor.getString(cursor.getColumnIndex("category_name")));
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}