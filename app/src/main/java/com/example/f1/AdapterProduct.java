package com.example.f1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.MyViewHolder> {
    Context context;
    List <ModelProduct> modelProducts;
    FloatingActionButton floatingActionButton;
    public AdapterProduct(@NonNull Context context,List<ModelProduct> modelProducts,FloatingActionButton floatingActionButton) {

        this.context=context;
        this.modelProducts=modelProducts;
        this.floatingActionButton=floatingActionButton;

    }
@NonNull
@Override



    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productcontainer,parent,false);
        return new AdapterProduct.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position){
        String name=modelProducts.get(position).getName();
        String price=modelProducts.get(position).getPrice();
        String image=modelProducts.get(position).getImage();

        holder.product_name.setText(name);
        holder.product_price.setText(price);

        try{
            Picasso.get().load(image).into(holder.product_image);
        }
        catch(Exception e){

        }
        holder.addtocartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            addToCart(name,price,image);
            }
        });
    }
public int itemid=1;
    private void addToCart(String name, String price, String image) {
        Random random = new Random();
        itemid=random.nextInt(200000);


        EasyDB easyDB = new EasyDB.init(context,"FOOD_DB")
                .setTableName("FOOD_TAB")
                .addColumn(new Column())

    }

    @Override
    public int getItemCount(){
        return modelProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
ImageView product_image;
TextView product_name,product_price;
Button addtocartButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            product_image=itemView.findViewById(R.id.productimage);
            product_name=itemView.findViewById(R.id.productname);
            product_price=itemView.findViewById(R.id.productprice);
            addtocartButton=itemView.findViewById(R.id.cartbutton);
        }
    }
    }



