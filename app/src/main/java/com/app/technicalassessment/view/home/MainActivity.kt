package com.app.technicalassessment.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.technicalassessment.R
import com.app.technicalassessment.databinding.ContentMainBinding
import com.app.technicalassessment.model.api.ApiInterface
import com.app.technicalassessment.model.api.CategoryListRemoteDataSource
import com.app.technicalassessment.model.api.RetrofitInstance
import com.app.technicalassessment.model.data.Category
import com.app.technicalassessment.model.data.database.AppDatabase
import com.app.technicalassessment.viewmodel.CategoryListRepo
import com.app.technicalassessment.viewmodel.ViewModel

class MainActivity : AppCompatActivity(){
    private var viewModel: ViewModel? = null
    private var binding: ContentMainBinding? = null
    private var catgAdapter: CategoryAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.content_main
        )
        binding!!.rvCategories.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    fun loadData() {
        val apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
        val dataSource = CategoryListRemoteDataSource(apiInterface)
        val categListDao = AppDatabase.getInstance(applicationContext).CategoryListDao()
        val repo = CategoryListRepo(categListDao, dataSource)
        viewModel = ViewModel(repo)
        subscribeUi(binding!!)
    }

    fun subscribeUi(binding: ContentMainBinding) {
        viewModel!!.categories.observe(this, Observer { result: List<Category> ->
            catgAdapter = CategoryAdapter(ArrayList(result), this@MainActivity)
            binding.rvCategories.adapter = catgAdapter
        })
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
}