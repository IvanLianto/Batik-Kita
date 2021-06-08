package com.example.batikkita.ui.gift

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.batikkita.R
import com.example.batikkita.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {

    private lateinit var binding: FragmentGiftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGiftBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            actionQuiz.setOnClickListener { comingSoonToast() }
            actionPoint.setOnClickListener { comingSoonToast() }
            actionSupriseMe.setOnClickListener { comingSoonToast() }
            actionVoucher.setOnClickListener { comingSoonToast() }
        }
    }

    private fun comingSoonToast(){
        Toast.makeText(requireContext(), "Coming Soon !", Toast.LENGTH_SHORT).show()
    }
}