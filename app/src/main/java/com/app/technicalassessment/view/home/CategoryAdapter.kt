package com.app.technicalassessment.view.home
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.technicalassessment.R
import com.app.technicalassessment.model.data.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(val items: ArrayList<Category>, val context: Context)
    : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Category) {
            with(itemView) {
                rv_products.layoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                rv_products.adapter = ProductListAdapter(ArrayList(item.products), context)
            }
        }
    }
}