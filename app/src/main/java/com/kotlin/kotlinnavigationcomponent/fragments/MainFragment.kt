package com.kotlin.kotlinnavigationcomponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kotlin.kotlinnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    private var bundle: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        btnOpenFragmentA.setOnClickListener(this)
        btnOpenFragmentB.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            btnOpenFragmentA -> {
                bundle = bundleOf("KEY" to "This is Fragment A")
                navController.navigate(R.id.AFragment, bundle)
            }


            btnOpenFragmentB -> {
                bundle = bundleOf("KEY" to "This is Fragment B")
                navController.navigate(R.id.BFragment, bundle)
            }


        }
    }
}