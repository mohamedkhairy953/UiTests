package com.paytabs.uitest.recycler_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paytabs.uitest.R
import com.paytabs.uitest.databinding.FragmentRecyclerViewBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RecyclerViewFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val b = FragmentRecyclerViewBinding.bind(
            inflater.inflate(
                R.layout.fragment_recycler_view,
                container,
                false
            )
        )
        b.rvNames.adapter =
            RvAdapter(listOf("mohamed ", "mohamed", "vncesnkfewivu", "jsfklkfl", "dlewfllf")) {
                childFragmentManager.beginTransaction().add(
                    android.R.id.content,
                    ItemDetailsFragment.newInstance(it, it), ""
                ).commit()
            }

        return b.root
    }

}