package com.turanapps.cnctorna.view.fragments.institutional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.turanapps.cnctorna.R
import com.turanapps.cnctorna.databinding.FragmentAboutUsBinding
import com.turanapps.cnctorna.view.fragments.CommunicationFragment

class AboutUsFragment : Fragment() {

    private lateinit var binding: FragmentAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsBinding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicationButtonClick()

    }

    private fun communicationButtonClick(){
        binding.communicationButton.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CommunicationFragment()).commit()

        }
    }

}