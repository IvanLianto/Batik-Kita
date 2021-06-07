package com.example.batikkita.ui.search

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.batikkita.R
import com.example.batikkita.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var result: ArrayList<String>
    private lateinit var indexSpinner: MutableLiveData<String>
    private lateinit var resultString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.list_filter,
            R.layout.support_simple_spinner_dropdown_item
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = spinnerAdapter

        result = ArrayList()
        indexSpinner = MutableLiveData()

        setListener()
        getData()

    }

    private fun setListener() {
        binding.btnSet.setOnClickListener {
            when (binding.spinner.selectedItem.toString()) {
                "Theme" -> {
                    result.clear()
                    indexSpinner.value = "Theme"
                    binding.groupTheme.visibility = View.VISIBLE
                    binding.groupColor.visibility = View.GONE
                    binding.rbgComplexity.visibility = View.GONE

                }
                "Color" -> {
                    result.clear()
                    indexSpinner.value = "Color"
                    binding.groupColor.visibility = View.VISIBLE
                    binding.groupTheme.visibility = View.GONE
                    binding.rbgComplexity.visibility = View.GONE

                }
                "Complexity" -> {
                    result.clear()
                    indexSpinner.value = "Complexity"
                    binding.rbgComplexity.visibility = View.VISIBLE
                    binding.groupTheme.visibility = View.GONE
                    binding.groupColor.visibility = View.GONE

                }
            }
        }
    }

    private fun getData() {
        binding.btnSearchParam.setOnClickListener {
            result.clear()
            when (indexSpinner.value) {
                "Theme" -> {
                    val list = ArrayList<CheckBox>()
                    with(binding) {
                        list.add(cbCalligraphy)
                        list.add(cbCloud)
                        list.add(cbFauna)
                        list.add(cbGeometric)
                        list.add(cbFlora)
                        list.add(cbHuman)
                        list.add(cbMonument)
                    }

                    for (data in list) {
                        if (data.isChecked) {
                            result.add(data.text.toString())
                        }
                    }

                    parseStringToResult(result)
                }

                "Color" -> {
                    val list = ArrayList<CheckBox>()
                    with(binding) {
                        list.add(cbBlack)
                        list.add(cbBlue)
                        list.add(cbBrown)
                        list.add(cbDarkBlue)
                        list.add(cbGreen)
                        list.add(cbOrange)
                        list.add(cbRed)
                        list.add(cbWhite)
                        list.add(cbYellow)
                    }

                    for (data in list) {
                        if (data.isChecked) {
                            result.add(data.text.toString())
                        }
                    }

                    parseStringToResult(result)
                }

                "Complexity" -> {
                    val list = ArrayList<RadioButton>()
                    with(binding) {
                        list.add(rbLow)
                        list.add(rbMedium)
                        list.add(rbHigh)
                    }

                    for (data in list) {
                        if (data.isChecked) {
                            result.add(data.text.toString())
                        }
                    }

                    parseStringToResult(result)
                }
            }
        }
    }

    private fun parseStringToResult(list: ArrayList<String>) {
        val sb = StringBuilder()
        for (i in 0 until list.size) {
            if(i == list.size-1){
                sb.append("%").append(list[i]).append("%")
            }
            sb.append("%").append(list[i]).append("%").append("AND theme LIKE")
        }
        val result = sb.toString()
        resultString = result

        observeViewModel()
    }

    private fun observeViewModel(){
        Toast.makeText(this, resultString,Toast.LENGTH_SHORT).show()
    }
}