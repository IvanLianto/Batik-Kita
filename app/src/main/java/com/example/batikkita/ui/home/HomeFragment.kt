package com.example.batikkita.ui.home

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.FragmentHomeBinding
import com.example.batikkita.interfaces.BatikOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.DummyObject
import com.example.batikkita.utils.ViewModelFactory
import com.example.batikkita.utils.alertDialog
import com.example.batikkita.utils.show
import com.example.vo.Status
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment(), BatikOnClickInterface {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
            adapter = HomeAdapter()
            adapter.dataInterface = this
            binding.rvHome.adapter = adapter
            observerRecyclerView()
        }
    }

    private fun observerRecyclerView() {
        viewModel.getListBatik().observe(viewLifecycleOwner, { list ->
            if (list != null) {
                when (list.status) {
                    Status.LOADING -> {
                        isLoading(true)
                    }
                    Status.SUCCESS -> {
                        isLoading(false)
                        adapter.submitList(list.data)
                        adapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        isLoading(false)
                        alertDialog(requireContext(), "ERROR", "Check your internet connection!")
                    }
                }
            }
        })
    }

    private fun isLoading(flag: Boolean) {
        binding.apply {
            rvHome.show(!flag)
            progressBar.show(flag)
        }
    }

    private fun initializeDatatoFirestore() { //for dev only!
        val db = FirebaseFirestore.getInstance()
        val batikRef = db.collection("Batik")

        val list = DummyObject.generateBatik()

        for (i in list) {
            batikRef.add(i)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Masukin data ${i.name}", Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }

    override fun onClicked(view: View, data: BatikEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
        startActivity(intent)
    }
}