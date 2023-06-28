package com.sample.simpsonsviewer.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.sample.simpsonsviewer.databinding.FragmentCitylookupBinding

class CityLookupFragment : Fragment() {
    private val TAG = "CityLookupFragment"
    private var _binding: FragmentCitylookupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCitylookupBinding.inflate(layoutInflater, container, false).also {
        _binding = it
      //  setupObservers()


        binding.lookUpButton.setOnClickListener {
            Log.i(TAG, "onCreateView: lookupbutton clicked")

            val directions =
                com.sample.simpsonsviewer.view.CityLookupFragmentDirections.actionCityLookupFragmentToForecastFragment()
            view?.findNavController()?.navigate(directions)

        }


    }.root


    }



