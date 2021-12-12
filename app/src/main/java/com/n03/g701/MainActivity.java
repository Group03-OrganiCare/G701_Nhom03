package com.n03.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.n03.g701.adapter.ProductAdapter;
import com.n03.g701.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> products;
    ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkViews();
        initData();
        loadData();

    }

    private void linkViews() {
        lvProduct= findViewById(R.id.lvProduct);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product("123", "Laptop", "ASUS", 15000000, R.drawable.banner));

    }

    private void loadData() {
        productAdapter = new ProductAdapter(MainActivity.this, R.layout.item_listview, products);
        lvProduct.setAdapter(productAdapter);
    }
}