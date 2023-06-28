package com.sample.simpsonsviewer.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.sample.simpsonsviewer.viewmodel.WeatherViewModel
import com.sample.simpsonsviewer.databinding.FragmentCitylookupBinding

class CityLookupFragment : Fragment() {
    private val TAG = "CityLookupFragment"
    private var _binding: FragmentCitylookupBinding? = null
    private val binding get() = _binding!!
    private val weatherViewModel by activityViewModels<WeatherViewModel>()

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

//    private fun setupObservers() = with(weatherViewModel) {
//        weatherState.observe(viewLifecycleOwner) { state ->
//
//            if (state is ApiState.Success) {
//
//                val wData = state.data;
//
//
//                val directions =
//                    CityLookupFragmentDirections.actionCityLookupFragmentToForecastFragment(wData)
//                view?.findNavController()?.navigate(directions)
//
//            }


 //       }

    }



