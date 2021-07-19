package com.paytabs.uitest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.paytabs.uitest.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val b =
            FragmentMainBinding.bind(inflater.inflate(R.layout.fragment_main, container, false))

        arguments?.getString(ARG_PARAM1)?.let {
            b.tvHelloBlank.text = it
        }
        b.btnShowToast.setOnClickListener {
            Toast.makeText(requireContext(), R.string.toast_msg, Toast.LENGTH_SHORT).show()
        }

        b.btnShowDialog.setOnClickListener {
            MaterialDialog(requireContext()).show {
                input(
                    waitForPositiveButton = true,
                    allowEmpty = false
                ) { dialog, name ->
                   b.tvHelloBlank.text=name
                }
                title(R.string.text_enter_name)
                positiveButton(R.string.text_ok)
            }
        }
        b.chbDisappear.setOnCheckedChangeListener { v, isChecked ->
            if (isChecked) {
                b.btnShowToast.visibility = View.GONE
                b.tvHelloBlank.visibility = View.GONE
                b.btnShowDialog.visibility = View.GONE
            }
        }
        return b.root
    }

    override fun onResume() {
        super.onResume()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}