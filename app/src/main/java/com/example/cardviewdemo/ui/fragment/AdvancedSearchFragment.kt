package com.example.cardviewdemo.ui.fragment

import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_advanced_search.*

class AdvancedSearchFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_advanced_search, null)
    }

    override fun initData() {
        article_one_spinner.setItems(
            "Astrophysics",
            "Condensed Matter",
            "Computer Science",
            "Economics",
            "Electrical Engineering and Systems Science",
            "High Energy Physics - Experiment",
            "High Energy Physics - Lattice",
            "High Energy Physics - Phenomenology",
            "High Energy Physics - Theory",
            "Mathematics",
            "Mathematical Physics",
            "Nonlinear Sciences",
            "Nuclear Experiment",
            "Nuclear Theory",
            "Physics",
            "Quantitative Biology",
            "Quantitative Finance",
            "Quantum Physics",
            "Statistics"
        )
        article_one_spinner.setOnItemSelectedListener(object : MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(
                view: MaterialSpinner?,
                position: Int,
                id: Long,
                item: String?
            ) {
                println("DEBUG:SELECTED:" + item)
            }
        })
    }
}