package com.paytabs.uitest.intents_test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.paytabs.uitest.R
import com.paytabs.uitest.databinding.FragmentIntentBinding
const val GALLERY_REQUEST_CODE = 1234

class IntentFragment : Fragment() {
    private lateinit var b :FragmentIntentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         b =
            FragmentIntentBinding.bind(inflater.inflate(R.layout.fragment_intent, container, false))
       b.ivPicked.setOnClickListener {
           pickFromGallery()
       }
        return b.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            Log.d("TAG", "RESULT_OK")
            when(requestCode){

                GALLERY_REQUEST_CODE -> {
                    Log.d("TAG", "GALLERY_REQUEST_CODE detected.")
                    data?.data?.let { uri ->
                        Log.d("TAG", "URI: $uri")
                        Glide.with(this)
                            .load(uri)
                            .into(b.ivPicked)
                    }
                }
            }
        }
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }
}