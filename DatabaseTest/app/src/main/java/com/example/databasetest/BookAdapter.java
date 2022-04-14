package com.example.databasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private int resourceId;

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView name = (TextView) view.findViewById(R.id.Book_name);
        TextView price = (TextView) view.findViewById(R.id.Book_price);
        TextView category_name = (TextView) view.findViewById(R.id.category_name);

        name.setText(book.getName());
        price.setText(book.getPrice());
        category_name.setText(book.getCategory_name());
        return view;
    }
}
