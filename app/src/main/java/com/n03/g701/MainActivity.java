package com.n03.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.n03.g701.adapter.ProductAdapter;
import com.n03.g701.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> arrayList;
    ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkViews();
        addEvents();
        initData();
    }

    private void linkViews() {
        lvProduct= findViewById(R.id.lvProduct);
    }

    private void addEvents() {
        productAdapter = new ProductAdapter(MainActivity.this, R.layout.item_listview, initData());
        lvProduct.setAdapter(productAdapter);
    }

    private ArrayList<Product> initData() {

        return arrayList;

    }
}