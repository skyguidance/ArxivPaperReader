/**
 * Create by Qi,TianYi <qitianyi@gwmail.gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_advanced_search.*
import kotlinx.android.synthetic.main.fragment_advanced_search.view.*

/**
 * The Advanced Search Fragment.
 * Provided Search By Sub-Category Function.
 */
class AdvancedSearchFragment : BaseFragment() {
    var Category: String=""
    var SearchWord: String=""

    /**
     * Init View for this Fragment.
     */
    override fun initView(): View? {
        var view=View.inflate(context, R.layout.fragment_advanced_search, null)

        /**
         * The Main Category Spinner.
         * This is the list for the Main Category.
         */
        view.article_one_spinner.setItems(
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

        /**
         * This is the initial resources for sub-category.
         * Prevent App from crashing. Use this as a filler.
         */
        view.article_two_spinner.setItems(
            "Astrophysics of Galaxies",
            "Cosmology and Nongalactic Astrophysics",
            "Earth and Planetary Astrophysics",
            "High Energy Astrophysical Phenomena",
            "Instrumentation and Methods for Astrophysics",
            "Solar and Stellar Astrophysics"
        )

        /**
         * Main Category Listener.
         * Set the Sub-category choices based on the main category.
         */
        view.article_one_spinner.setOnItemSelectedListener(object :
            MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(
                view: MaterialSpinner?,
                position: Int,
                id: Long,
                item: String?
            ) {
                when (item) {
                    "Astrophysics" -> {
                        article_two_spinner.setItems(
                            "Astrophysics of Galaxies",
                            "Cosmology and Nongalactic Astrophysics",
                            "Earth and Planetary Astrophysics",
                            "High Energy Astrophysical Phenomena",
                            "Instrumentation and Methods for Astrophysics",
                            "Solar and Stellar Astrophysics"
                        )
                    }
                    "Condensed Matter" -> {
                        article_two_spinner.setItems(
                            "Disordered Systems and Neural Networks",
                            "Materials Science",
                            "Mesoscale and Nanoscale Physics",
                            "Other Condensed Matter",
                            "Quantum Gases",
                            "Soft Condensed Matter",
                            "Statistical Mechanics",
                            "Strongly Correlated Electrons",
                            "Superconductivity"
                        )
                    }
                    "Computer Science" -> {
                        article_two_spinner.setItems(
                            "Artificial Intelligence",
                            "Computation and Language",
                            "Computational Complexity",
                            "Computational Engineering, Finance, and Science",
                            "Computational Geometry",
                            "Computer Science and Game Theory",
                            "Computer Vision and Pattern Recognition",
                            "Computers and Society",
                            "Cryptography and Security",
                            "Data Structures and Algorithms",
                            "Databases",
                            "Digital Libraries",
                            "Discrete Mathematics",
                            "Distributed, Parallel, and Cluster Computing",
                            "Emerging Technologies",
                            "Formal Languages and Automata Theory",
                            "General Literature",
                            "Graphics",
                            "Hardware Architecture",
                            "Human-Computer Interaction",
                            "Information Retrieval",
                            "Information Theory",
                            "Logic in Computer Science",
                            "Machine Learning",
                            "Mathematical Software",
                            "Multiagent Systems",
                            "Multimedia",
                            "Neural and Evolutionary Computing",
                            "Numerical Analysis",
                            "Operating Systems",
                            "Other Computer Science",
                            "Performance",
                            "Programming Languages",
                            "Robotics",
                            "Social and Information Networks",
                            "Software Engineering",
                            "Sound",
                            "Symbolic Computation",
                            "Systems and Control"
                        )
                    }
                    "Economics" -> {
                        article_two_spinner.setItems(
                            "Econometrics",
                            "General Economics",
                            "Theoretical Economics"
                        )
                    }
                    "Electrical Engineering and Systems Science" -> {
                        article_two_spinner.setItems(
                            "Audio and Speech Processing",
                            "Image and Video Processing",
                            "Signal Processing",
                            "Systems and Control"
                        )
                    }
                    "General Relativity and Quantum Cosmology" -> {
                        article_two_spinner.setItems("General Relativity and Quantum Cosmology")
                    }
                    "High Energy Physics - Experiment" -> {
                        article_two_spinner.setItems("High Energy Physics - Experiment")
                    }
                    "High Energy Physics - Lattice" -> {
                        article_two_spinner.setItems("High Energy Physics - Lattice")
                    }
                    "High Energy Physics - Phenomenology" -> {
                        article_two_spinner.setItems("High Energy Physics - Phenomenology")
                    }
                    "High Energy Physics - Theory" -> {
                        article_two_spinner.setItems("High Energy Physics - Theory")
                    }
                    "Mathematics" -> {
                        article_two_spinner.setItems(
                            "Algebraic Geometry",
                            "Algebraic Topology",
                            "Analysis of PDEs",
                            "Category Theory",
                            "Classical Analysis and ODEs",
                            "Combinatorics",
                            "Commutative Algebra",
                            "Complex Variables",
                            "Differential Geometry",
                            "Dynamical Systems",
                            "Functional Analysis",
                            "General Mathematics",
                            "General Topology",
                            "Geometric Topology",
                            "Group Theory",
                            "History and Overview",
                            "Information Theory",
                            "K-Theory and Homology",
                            "Logic",
                            "Mathematical Physics",
                            "Metric Geometry",
                            "Number Theory",
                            "Numerical Analysis",
                            "Operator Algebras",
                            "Optimization and Control",
                            "Probability",
                            "Quantum Algebra",
                            "Representation Theory",
                            "Rings and Algebras",
                            "Spectral Theory",
                            "Statistics Theory",
                            "Symplectic Geometry"
                        )
                    }
                    "Mathematical Physics" -> {
                        article_two_spinner.setItems("Mathematical Physics")
                    }
                    "Nonlinear Sciences" -> {
                        article_two_spinner.setItems(
                            "Adaptation and Self-Organizing Systems",
                            "Cellular Automata and Lattice Gases",
                            "Chaotic Dynamics",
                            "Exactly Solvable and Integrable Systems",
                            "Pattern Formation and Solitons"
                        )
                    }
                    "Nuclear Experiment" -> {
                        article_two_spinner.setItems("Nuclear Experiment")
                    }
                    "Nuclear Theory" -> {
                        article_two_spinner.setItems("Nuclear Theory")
                    }
                    "Physics" -> {
                        article_two_spinner.setItems(
                            "Accelerator Physics",
                            "Applied Physics",
                            "Atmospheric and Oceanic Physics",
                            "Atomic Physics",
                            "Atomic and Molecular Clusters",
                            "Biological Physics",
                            "Chemical Physics",
                            "Classical Physics",
                            "Computational Physics",
                            "Data Analysis, Statistics and Probability",
                            "Fluid Dynamics",
                            "General Physics",
                            "Geophysics",
                            "History and Philosophy of Physics",
                            "Instrumentation and Detectors",
                            "Medical Physics",
                            "Optics",
                            "Physics Education",
                            "Physics and Society",
                            "Plasma Physics",
                            "Popular Physics",
                            "Space Physics"
                        )
                    }
                    "Quantitative Biology" -> {
                        article_two_spinner.setItems(
                            "Biomolecules",
                            "Cell Behavior",
                            "Genomics",
                            "Molecular Networks",
                            "Neurons and Cognition",
                            "Other Quantitative Biology",
                            "Populations and Evolution",
                            "Quantitative Methods",
                            "Subcellular Processes",
                            "Tissues and Organs"
                        )
                    }
                    "Quantitative Finance" -> {
                        article_two_spinner.setItems(
                            "Computational Finance",
                            "Economics",
                            "General Finance",
                            "Mathematical Finance",
                            "Portfolio Management",
                            "Pricing of Securities",
                            "Risk Management",
                            "Statistical Finance",
                            "Trading and Market Microstructure"
                        )
                    }
                    "Quantum Physics" -> {
                        article_two_spinner.setItems("Quantum Physics")
                    }
                    "Statistics" -> {
                        article_two_spinner.setItems(
                            "Applications",
                            "Computation",
                            "Machine Learning",
                            "Methodology",
                            "Other Statistics",
                            "Statistics Theory"
                        )
                    }
                    else -> println("Debug:ERROR spinner 1:" + item)
                }
            }
        })

        /**
         * Sub Category Listener.
         * Set the Category Variable to selected Sub-Category.
         */
        view.article_two_spinner.setOnItemSelectedListener(object :
            MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(
                view: MaterialSpinner?,
                position: Int,
                id: Long,
                item: String?
            ) {
                when (item) {
                    "Astrophysics of Galaxies" -> {
                        Category="astro-ph.GA"
                    }
                    "Cosmology and Nongalactic Astrophysics" -> {
                        Category="astro-ph.CO"
                    }
                    "Earth and Planetary Astrophysics" -> {
                        Category="astro-ph.EP"
                    }
                    "High Energy Astrophysical Phenomena" -> {
                        Category="astro-ph.HE"
                    }
                    "Instrumentation and Methods for Astrophysics" -> {
                        Category="astro-ph.IM"
                    }
                    "Solar and Stellar Astrophysics" -> {
                        Category="astro-ph.SR"
                    }
                    "Disordered Systems and Neural Networks" -> {
                        Category="cond-mat.dis-nn"
                    }
                    "Materials Science" -> {
                        Category="cond-mat.mtrl-sci"
                    }
                    "Mesoscale and Nanoscale Physics" -> {
                        Category="cond-mat.mes-hall"
                    }
                    "Other Condensed Matter" -> {
                        Category="cond-mat.other"
                    }
                    "Quantum Gases" -> {
                        Category="cond-mat.quant-gas"
                    }
                    "Soft Condensed Matter" -> {
                        Category="cond-mat.soft"
                    }
                    "Statistical Mechanics" -> {
                        Category="cond-mat.stat-mech"
                    }
                    "Strongly Correlated Electrons" -> {
                        Category="cond-mat.str-el"
                    }
                    "Superconductivity" -> {
                        Category="cond-mat.supr-con"
                    }
                    "Artificial Intelligence" -> {
                        Category="cs.AI"
                    }
                    "Computation and Language" -> {
                        Category="cs.CL"
                    }
                    "Computational Complexity" -> {
                        Category="cs.CC"
                    }
                    "Computational Engineering, Finance, and Science" -> {
                        Category="cs.CE"
                    }
                    "Computational Geometry" -> {
                        Category="cs.CG"
                    }
                    "Computer Science and Game Theory" -> {
                        Category="cs.GT"
                    }
                    "Computer Vision and Pattern Recognition" -> {
                        Category="cs.CV"
                    }
                    "Computers and Society" -> {
                        Category="cs.CY"
                    }
                    "Cryptography and Security" -> {
                        Category="cs.CR"
                    }
                    "Data Structures and Algorithms" -> {
                        Category="cs.DS"
                    }
                    "Databases" -> {
                        Category="cs.DB"
                    }
                    "Digital Libraries" -> {
                        Category="cs.DL"
                    }
                    "Discrete Mathematics" -> {
                        Category="cs.DM"
                    }
                    "Distributed, Parallel, and Cluster Computing" -> {
                        Category="cs.DC"
                    }
                    "Emerging Technologies" -> {
                        Category="cs.ET"
                    }
                    "Formal Languages and Automata Theory" -> {
                        Category="cs.FL"
                    }
                    "General Literature" -> {
                        Category="cs.GL"
                    }
                    "Graphics" -> {
                        Category="cs.GR"
                    }
                    "Hardware Architecture" -> {
                        Category="cs.AR"
                    }
                    "Human-Computer Interaction" -> {
                        Category="cs.HC"
                    }
                    "Information Retrieval" -> {
                        Category="cs.IR"
                    }
                    "Information Theory" -> {
                        Category="cs.IT"
                    }
                    "Logic in Computer Science" -> {
                        Category="cs.LO"
                    }
                    "Machine Learning" -> {
                        Category="cs.LG"
                    }
                    "Mathematical Software" -> {
                        Category="cs.MS"
                    }
                    "Multiagent Systems" -> {
                        Category="cs.MA"
                    }
                    "Multimedia" -> {
                        Category="cs.MM"
                    }
                    "Networking and Internet Architecture" -> {
                        Category="cs.NI"
                    }
                    "Neural and Evolutionary Computing" -> {
                        Category="cs.NE"
                    }
                    "Numerical Analysis" -> {
                        Category="cs.NA"
                    }
                    "Operating Systems" -> {
                        Category="cs.OS"
                    }
                    "Other Computer Science" -> {
                        Category="cs.OH"
                    }
                    "Performance" -> {
                        Category="cs.PF"
                    }
                    "Programming Languages" -> {
                        Category="cs.PL"
                    }
                    "Robotics" -> {
                        Category="cs.RO"
                    }
                    "Social and Information Networks" -> {
                        Category="cs.SI"
                    }
                    "Software Engineering" -> {
                        Category="cs.SE"
                    }
                    "Sound" -> {
                        Category="cs.SD"
                    }
                    "Symbolic Computation" -> {
                        Category="cs.SC"
                    }
                    "Systems and Control" -> {
                        Category="cs.SY"
                    }
                    "Econometrics" -> {
                        Category="econ.EM"
                    }
                    "General Economics" -> {
                        Category="econ.GN"
                    }
                    "Theoretical Economics" -> {
                        Category="econ.TH"
                    }
                    "Audio and Speech Processing" -> {
                        Category="eess.AS"
                    }
                    "Image and Video Processing" -> {
                        Category="eess.IV"
                    }
                    "Signal Processing" -> {
                        Category="eess.SP"
                    }
                    "Systems and Control" -> {
                        Category="eess.SY"
                    }
                    "General Relativity and Quantum Cosmology" -> {
                        Category="gr-qc"
                    }
                    "High Energy Physics - Experiment" -> {
                        Category="hep-ex"
                    }
                    "High Energy Physics - Lattice" -> {
                        Category="hep-lat"
                    }
                    "High Energy Physics - Phenomenology" -> {
                        Category="hep-ph"
                    }
                    "High Energy Physics - Theory" -> {
                        Category="hep-th"
                    }
                    "Algebraic Geometry" -> {
                        Category="math.AG"
                    }
                    "Algebraic Topology" -> {
                        Category="math.AT"
                    }
                    "Analysis of PDEs" -> {
                        Category="math.AP"
                    }
                    "Category Theory" -> {
                        Category="math.CT"
                    }
                    "Classical Analysis and ODEs" -> {
                        Category="math.CA"
                    }
                    "Combinatorics" -> {
                        Category="math.CO"
                    }
                    "Commutative Algebra" -> {
                        Category="math.AC"
                    }
                    "Complex Variables" -> {
                        Category="math.CV"
                    }
                    "Differential Geometry" -> {
                        Category="math.DG"
                    }
                    "Dynamical Systems" -> {
                        Category="math.DS"
                    }
                    "Functional Analysis" -> {
                        Category="math.FA"
                    }
                    "General Mathematics" -> {
                        Category="math.GM"
                    }
                    "General Topology" -> {
                        Category="math.GN"
                    }
                    "Geometric Topology" -> {
                        Category="math.GT"
                    }
                    "Group Theory" -> {
                        Category="math.GR"
                    }
                    "History and Overview" -> {
                        Category="math.HO"
                    }
                    "Information Theory" -> {
                        Category="math.IT"
                    }
                    "K-Theory and Homology" -> {
                        Category="math.KT"
                    }
                    "Logic" -> {
                        Category="math.LO"
                    }
                    "Mathematical Physics" -> {
                        Category="math.MP"
                    }
                    "Metric Geometry" -> {
                        Category="math.MG"
                    }
                    "Number Theory" -> {
                        Category="math.NT"
                    }
                    "Numerical Analysis" -> {
                        Category="math.NA"
                    }
                    "Operator Algebras" -> {
                        Category="math.OA"
                    }
                    "Optimization and Control" -> {
                        Category="math.OC"
                    }
                    "Probability" -> {
                        Category="math.PR"
                    }
                    "Quantum Algebra" -> {
                        Category="math.QA"
                    }
                    "Representation Theory" -> {
                        Category="math.RT"
                    }
                    "Rings and Algebras" -> {
                        Category="math.RA"
                    }
                    "Spectral Theory" -> {
                        Category="math.SP"
                    }
                    "Statistics Theory" -> {
                        Category="math.ST"
                    }
                    "Symplectic Geometry" -> {
                        Category="math.SG"
                    }
                    "Mathematical Physics" -> {
                        Category="math-ph"
                    }
                    "Adaptation and Self-Organizing Systems" -> {
                        Category="nlin.AO"
                    }
                    "Cellular Automata and Lattice Gases" -> {
                        Category="nlin.CG"
                    }
                    "Chaotic Dynamics" -> {
                        Category="nlin.CD"
                    }
                    "Exactly Solvable and Integrable Systems" -> {
                        Category="nlin.SI"
                    }
                    "Pattern Formation and Solitons" -> {
                        Category="nlin.PS"
                    }
                    "Nuclear Experiment" -> {
                        Category="nucl-ex"
                    }
                    "Nuclear Theory" -> {
                        Category="nucl-th"
                    }
                    "Accelerator Physics" -> {
                        Category="physics.acc-ph"
                    }
                    "Applied Physics" -> {
                        Category="physics.app-ph"
                    }
                    "Atmospheric and Oceanic Physics" -> {
                        Category="physics.ao-ph"
                    }
                    "Atomic Physics" -> {
                        Category="physics.atom-ph"
                    }
                    "Atomic and Molecular Clusters" -> {
                        Category="physics.atm-clus"
                    }
                    "Biological Physics" -> {
                        Category="physics.bio-ph"
                    }
                    "Chemical Physics" -> {
                        Category="physics.chem-ph"
                    }
                    "Classical Physics" -> {
                        Category="physics.class-ph"
                    }
                    "Computational Physics" -> {
                        Category="physics.comp-ph"
                    }
                    "Data Analysis, Statistics and Probability" -> {
                        Category="physics.data-an"
                    }
                    "Fluid Dynamics" -> {
                        Category="physics.flu-dyn"
                    }
                    "General Physics" -> {
                        Category="physics.gen-ph"
                    }
                    "Geophysics" -> {
                        Category="physics.geo-ph"
                    }
                    "History and Philosophy of Physics" -> {
                        Category="physics.hist-ph"
                    }
                    "Instrumentation and Detectors" -> {
                        Category="physics.ins-det"
                    }
                    "Medical Physics" -> {
                        Category="physics.med-ph"
                    }
                    "Optics" -> {
                        Category="physics.optics"
                    }
                    "Physics Education" -> {
                        Category="physics.ed-ph"
                    }
                    "Physics and Society" -> {
                        Category="physics.soc-ph"
                    }
                    "Plasma Physics" -> {
                        Category="physics.plasm-ph"
                    }
                    "Popular Physics" -> {
                        Category="physics.pop-ph"
                    }
                    "Space Physics" -> {
                        Category="physics.space-ph"
                    }
                    "Biomolecules" -> {
                        Category="q-bio.BM"
                    }
                    "Cell Behavior" -> {
                        Category="q-bio.CB"
                    }
                    "Genomics" -> {
                        Category="q-bio.GN"
                    }
                    "Molecular Networks" -> {
                        Category="q-bio.MN"
                    }
                    "Neurons and Cognition" -> {
                        Category="q-bio.NC"
                    }
                    "Other Quantitative Biology" -> {
                        Category="q-bio.OT"
                    }
                    "Populations and Evolution" -> {
                        Category="q-bio.PE"
                    }
                    "Quantitative Methods" -> {
                        Category="q-bio.QM"
                    }
                    "Subcellular Processes" -> {
                        Category="q-bio.SC"
                    }
                    "Tissues and Organs" -> {
                        Category="q-bio.TO"
                    }
                    "Computational Finance" -> {
                        Category="q-fin.CP"
                    }
                    "Economics" -> {
                        Category="q-fin.EC"
                    }
                    "General Finance" -> {
                        Category="q-fin.GN"
                    }
                    "Mathematical Finance" -> {
                        Category="q-fin.MF"
                    }
                    "Portfolio Management" -> {
                        Category="q-fin.PM"
                    }
                    "Pricing of Securities" -> {
                        Category="q-fin.PR"
                    }
                    "Risk Management" -> {
                        Category="q-fin.RM"
                    }
                    "Statistical Finance" -> {
                        Category="q-fin.ST"
                    }
                    "Trading and Market Microstructure" -> {
                        Category="q-fin.TR"
                    }
                    "Quantum Physics" -> {
                        Category="quant-ph"
                    }
                    "Applications" -> {
                        Category="stat.AP"
                    }
                    "Computation" -> {
                        Category="stat.CO"
                    }
                    "Machine Learning" -> {
                        Category="stat.ML"
                    }
                    "Methodology" -> {
                        Category="stat.ME"
                    }
                    "Other Statistics" -> {
                        Category="stat.OT"
                    }
                    "Statistics Theory" -> {
                        Category="stat.TH"
                    }
                    else -> {
                        println("Debug: Second" + item)
                    }
                }
            }

        })

        /**
         * Set the Search Button on Click Listener.
         */
        view.btn_go_advanced_search.setOnClickListener {
            SearchWord=view.search_view.text.toString()
            var frag=PaperBrowseFragment()
            var item=Bundle()
            frag.setArguments(item)
            fragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.container, frag)?.commit()
        }
        return view
    }

}