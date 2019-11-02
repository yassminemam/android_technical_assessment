package com.app.technicalassessment.view.details

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.technicalassessment.R
import com.app.technicalassessment.databinding.ActivityProductDetailsBinding
import com.app.technicalassessment.model.data.Product
import com.app.technicalassessment.util.BASE_IMG_URL
import com.app.technicalassessment.util.PRODUCT_EXTRA
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {
    var currentProduct:Product? = null
    private var binding: ActivityProductDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        currentProduct = intent.getSerializableExtra(PRODUCT_EXTRA) as? Product

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_details
        )

        binding!!.product = currentProduct
    }

    override fun onResume() {
        super.onResume()
        val imgPath = BASE_IMG_URL + currentProduct!!.url
        Picasso.get()
            .load(Uri.parse(imgPath)).error(R.drawable.img_placeholder).placeholder(R.drawable.img_placeholder)
            .into(iv_producg_img)
    }
}
