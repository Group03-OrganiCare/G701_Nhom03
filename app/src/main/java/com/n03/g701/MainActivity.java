package com.n03.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.n03.g701.adapter.ProductAdapter;
import com.n03.g701.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> products;
    ProductAdapter productAdapter;

    ImageView imvDelete;


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
        imvDelete = findViewById(R.id.imvDelete);
    }

    private void initData() {
        products = new ArrayList<Product>();
        products.add(new Product("123", "Laptop", "ASUS", 15000000, R.drawable.banner));

    }

    private void loadData() {
        productAdapter = new ProductAdapter(MainActivity.this, R.layout.item_listview, products);
        lvProduct.setAdapter(productAdapter);

        //delete product
        imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_delete_dialog);
                dialog.setCanceledOnTouchOutside(false);

                Button btnConfirmDelete = dialog.findViewById(R.id.btnConfirmDelete);
                btnConfirmDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                Button btnCancelDelete = dialog.findViewById(R.id.btnCancelDelete);
                btnCancelDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}