package com.example.batikkita.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ActivitySearchBinding
import com.example.batikkita.interfaces.BatikOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.ViewModelFactory
import com.example.batikkita.utils.show

class SearchActivity : AppCompatActivity(), BatikOnClickInterface {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: SearchAdapter
    private lateinit var viewModel: SearchViewModel

    private lateinit var result: ArrayList<String>
    private lateinit var indexSpinner: MutableLiveData<String>
    private lateinit var resultString: String

    private var type = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[SearchViewModel::class.java]

        val spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.list_filter,
            R.layout.support_simple_spinner_dropdown_item
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = spinnerAdapter

        result = ArrayList()
        indexSpinner = MutableLiveData()

        adapter = SearchAdapter()
        adapter.dataInterface = this
        binding.rvSearch.adapter = adapter

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        setListener()
        getData()

    }

    private fun setListener() {
        binding.btnSet.setOnClickListener {
            when (binding.spinner.selectedItem.toString()) {
                "Theme" -> {
                    result.clear()
                    indexSpinner.value = "Theme"
                    binding.apply {
                        groupTheme.show(true)
                        groupColor.show(false)
                        rbgComplexity.show(false)
                        rvSearch.show(false)
                        btnSearchParam.show(true)
                    }
                }
                "Color" -> {
                    result.clear()
                    indexSpinner.value = "Color"
                    binding.apply {
                        groupTheme.show(false)
                        groupColor.show(true)
                        rbgComplexity.show(false)
                        rvSearch.show(false)
                        btnSearchParam.show(true)
                    }

                }
                "Complexity" -> {
                    result.clear()
                    indexSpinner.value = "Complexity"
                    binding.apply {
                        groupTheme.show(false)
                        groupColor.show(false)
                        rbgComplexity.show(true)
                        rvSearch.show(false)
                        btnSearchParam.show(true)
                    }
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
                    type = "theme"
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
                }

                "Color" -> {
                    val list = ArrayList<CheckBox>()
                    type = "color"
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
                }

                "Complexity" -> {
                    val list = ArrayList<RadioButton>()
                    type = "complexity"
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
                }
            }
            if (result.isEmpty()) {
                Toast.makeText(this@SearchActivity, "Please choose one", Toast.LENGTH_SHORT).show()
            } else {
                parseStringToResult(result)
            }
        }
    }

    private fun parseStringToResult(list: ArrayList<String>) {
        val sb = StringBuilder()
        for (i in 0 until list.size) {
            sb.append(" $type LIKE '%${list[i]}%' ")
            if (i != list.size - 1 && list.size != 1) {
                sb.append(" OR ")
            }
        }
        val result = sb.toString()
        resultString = result

        observeViewModel()
    }

    private fun observeViewModel() {
        binding.apply {
            groupTheme.show(false)
            groupColor.show(false)
            rbgComplexity.show(false)
            rvSearch.show(true)
            btnSearchParam.show(false)
        }
        val query = SimpleSQLiteQuery("SELECT * FROM batikEntities WHERE $resultString")
        viewModel.searchBatikByFilter(query).observe(this, { list ->
            Log.d("SearchActivity", resultString)
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onClicked(view: View, data: BatikEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
        startActivity(intent)
    }
}