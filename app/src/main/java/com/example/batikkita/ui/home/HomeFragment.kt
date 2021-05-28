package com.example.batikkita.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.R
import com.example.batikkita.databinding.FragmentHomeBinding
import com.example.batikkita.utils.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            adapter = HomeAdapter()
            binding.rvHome.adapter = adapter
            observerRecyclerView()
        }
    }

    private fun observerRecyclerView() {
        viewModel.getListBatik().observe(viewLifecycleOwner, { list ->
            if (list != null) {
                adapter.submitList(list)
                adapter.notifyDataSetChanged()
            }
        })
    }
}