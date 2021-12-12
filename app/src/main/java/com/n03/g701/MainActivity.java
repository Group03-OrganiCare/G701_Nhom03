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

    private void addEvents() {
        productAdapter = new ProductAdapter(MainActivity.this, R.layout.item_listview, initData());
        lvProduct.setAdapter(productAdapter);
    }

    private ArrayList<Product> initData() {

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