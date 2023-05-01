package com.example.f1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton floatingActionButton;
List<ModelProduct> modelProducts;
AdapterProduct adapterProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.productrecyclerview);
        floatingActionButton=findViewById(R.id.floatingcart);
        modelProducts=new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(MainActivity.this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        
        recyclerView.setLayoutManager(gridLayoutManager);
        
        
        getProducts();
    }

    private void getProducts() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("foods");
        reference.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelProducts.clear();
                for(DataSnapshot snapshot1:dataSnapshot.getChildren()){
        ModelProduct modelProduct=snapshot1.getValue(ModelProduct.class);
        modelProducts.add(modelProduct);
        adapterProduct=new AdapterProduct(MainActivity.this,modelProducts,floatingActionButton);
        recyclerView.setAdapter(adapterProduct);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}