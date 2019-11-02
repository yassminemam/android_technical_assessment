package com.app.technicalassessment.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ViewModel @Inject constructor(repository: CategoryListRepo) : ViewModel() {

    val categories= repository.items
}