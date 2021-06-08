package com.example.batikkita.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.databinding.FragmentCartBinding
import com.example.batikkita.interfaces.CartOnClickInterface
import com.example.batikkita.utils.ViewModelFactory

class CartFragment : Fragment(), CartOnClickInterface {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: CartAdapter
    private lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[CartViewModel::class.java]
            adapter = CartAdapter()
            adapter.dataInterface = this
            binding.rvCart.adapter = adapter
            observerRecyclerView()
        }
    }

    private fun observerRecyclerView() {
        viewModel.getListCart().observe(viewLifecycleOwner, {
            adapter.submitList(it.data)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onClicked(view: View, data: CartEntity) {
        val intent = Intent(context, CartDetailActivity::class.java)
        intent.putExtra(CartDetailActivity.EXTRA_ID, data.id)
        startActivity(intent)
    }

}