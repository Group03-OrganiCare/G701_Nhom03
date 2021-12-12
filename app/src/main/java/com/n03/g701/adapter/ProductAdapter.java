package com.n03.g701.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.n03.g701.R;
import com.n03.g701.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int item_listview;
    List<Product> productList;

    public ProductAdapter(Context context, int item_listview, List<Product> productList) {
        this.context = context;
        this.item_listview = item_listview;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            //Link item view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvItemThumb = view.findViewById(R.id.imvItemThumb);
            holder.txtItemName = view.findViewById(R.id.txtItemName);
            holder.txtItemId = view.findViewById(R.id.txtItemId);
            holder.txtItemCompany = view.findViewById(R.id.txtItemCompany);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Product p = productList.get(i);
        holder.imvItemThumb.setImageResource(p.getProductThumb());
        holder.txtItemName.setText(p.getProductName());
        holder.txtItemId.setText(p.getProductId());
        holder.txtItemPrice.setText(String.valueOf(p.getProductPrice()));
        holder.txtItemCompany.setText(p.getProductCompany());

        return view;
    }

    public static class ViewHolder {
        ImageView imvItemThumb;
        TextView txtItemName, txtItemId, txtItemPrice, txtItemCompany;
    }
}
