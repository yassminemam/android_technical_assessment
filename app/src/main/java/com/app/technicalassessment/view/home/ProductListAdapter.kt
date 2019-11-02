package com.app.technicalassessment.view.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.technicalassessment.R
import com.app.technicalassessment.model.data.Product
import com.app.technicalassessment.util.PRODUCT_EXTRA
import com.app.technicalassessment.view.details.ProductDetailsActivity
import kotlinx.android.synthetic.main.item_product.view.*

class ProductListAdapter(private val items: ArrayList<Product>, val context: Context) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) {
            with(itemView) {
                tv_product_title.text = item.name
                iv_product_info.setOnClickListener {
                    onClickProduct(item)
                }
            }
        }
    }
    fun onClickProduct(product:Product)
    {
        val intent = Intent(context, ProductDetailsActivity::class.java)
        intent.putExtra(PRODUCT_EXTRA, product)
        context.startActivity(intent)
    }
}