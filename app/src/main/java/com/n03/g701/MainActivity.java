package com.n03.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.n03.g701.adapter.ProductAdapter;
import com.n03.g701.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> arrayList;
    ProductAdapter productAdapter;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkViews();
        addEvents();
        initData();
    }

    private void linkViews()
    {
        lvProduct= findViewById(R.id.lvProduct);
        btnAdd = findViewById(R.id.btnAddProduct);
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Product_Add.class);
                startActivity(intent);
            }
        });
        productAdapter = new ProductAdapter(MainActivity.this, R.layout.item_listview, initData());
        lvProduct.setAdapter(productAdapter);
    }
    private ArrayList<Product> initData() {

        return arrayList;

    }
}