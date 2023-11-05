package com.example.appstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categoryList = arrayListOf<Category>()
        val categoryItems = arrayListOf<CategoryItem>()
//        val list = arrayListOf<String>()
//        for (i in 1..10){
//            list.add("Item $i");
//        }
        for (i in 1..8){
            categoryItems.add(
                CategoryItem(resources.getIdentifier("dice_$i","drawable", packageName ), "Item $i")
            )
        }

        for (i in 1..5){
            categoryList.add(Category("Category $i", categoryItems))
        }
        val adapter = CategoryRowAdapter(categoryList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }
}