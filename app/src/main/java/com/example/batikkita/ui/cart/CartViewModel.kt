package com.example.batikkita.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.vo.Resource

class CartViewModel(private val batikRepository: BatikRepository) : ViewModel() {
    fun getListCart(): LiveData<Resource<List<CartEntity>>> = batikRepository.getListCart()
}