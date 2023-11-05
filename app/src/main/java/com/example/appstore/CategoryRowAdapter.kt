package com.example.appstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CategoryRowAdapter(val categories: ArrayList<Category>): BaseAdapter() {
    override fun getCount(): Int {
        return categories.size
    }

    override fun getItem(p0: Int): Any {
        return categories[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val row: View
        if (p1 == null){
            row = LayoutInflater.from(p2?.context).inflate(R.layout.category_row_layout, p2, false)
            val category : TextView = row.findViewById<TextView>(R.id.category)
//        val scrollView : HorizontalScrollView = row.findViewById<HorizontalScrollView>(R.id.scrollView)
            val categoryItemLayout: LinearLayout = row.findViewById<LinearLayout>(R.id.categoryItem)
            val categoryItems: ArrayList<CategoryItem> = categories[p0].categoryItems
            for (i in 0..<categoryItems.size){
                val item: View = LayoutInflater.from(categoryItemLayout.context).inflate(R.layout.frame_icon_label, categoryItemLayout, false)
                item.findViewById<TextView>(R.id.content).text = categoryItems[i].content;
                item.findViewById<ImageView>(R.id.imageView).setImageResource(categoryItems[i].imageResource)
                categoryItemLayout.addView(item)
            }
            category.text = categories[p0].category
        }else{
            row = p1
        }

        return row
    }
}