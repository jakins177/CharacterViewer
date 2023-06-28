package com.sample.simpsonsviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sample.simpsonsviewer.R
import com.sample.simpsonsviewer.SimpsonModel.RelatedTopic
//import com.example.simpsonsviewer.databinding.FragmentForecastDetailBinding
import com.sample.simpsonsviewer.model.ForecastDetails
import com.sample.simpsonsviewer.util.parseName
import com.sample.simpsonsviewer.databinding.FragmentForecastDetailBinding

class ForecastDetailFragment : Fragment() {
    private val TAG = "ForecastDetailFragment"
    private var _binding: FragmentForecastDetailBinding? = null
    private val binding get() = _binding!!
    private val args: com.sample.simpsonsviewer.view.ForecastDetailFragmentArgs by navArgs()
    private lateinit var fDetail: ForecastDetails
    private lateinit var cDetail: RelatedTopic

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentForecastDetailBinding.inflate(layoutInflater, container, false).also {
        _binding = it

        cDetail = args.cDetail
        initViews()

    }.root


    private fun initViews() = with(binding) {

//        if (fDetail != null && fDetail.weather != null) {
//
//            var weather: Weather = fDetail.weather!![0]
//
//            binding.feelsLikeTextView.text = "Feels like ${fDetail.main?.feelsLike.toString()}"
//            binding.tempTextView.text = fDetail.main?.temp.toString()
//            binding.weatherDescTextView.text = weather.description.toString()
//            binding.weatherTextView.text = weather.main.toString()
//        }

        if (cDetail != null) {
            binding.weatherDescTextView.text = cDetail.Text.toString()
            binding.feelsLikeTextView.text = parseName(cDetail.Text.toString())
            val imageUrl = cDetail.Icon.URL
            if (imageUrl != null && imageUrl.isNotEmpty()) {
                val completeImageUrl  = "https://duckduckgo.com$imageUrl"

                Glide.with(requireContext())
                    .load(completeImageUrl)
                    .placeholder(R.drawable.place_holder) // Replace with your placeholder image resource
                    .error(R.drawable.error_image) // Replace with your error image resource (optional)
                    .into(binding.characterImageView)

            } else {
                binding.characterImageView.setImageResource(R.drawable.place_holder)
            }


        }

    }


}