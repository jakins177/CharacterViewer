package com.sample.simpsonsviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sample.simpsonsviewer.R
import com.sample.simpsonsviewer.databinding.FragmentCharacterDetailBinding

import com.sample.simpsonsviewer.SimpsonModel.RelatedTopic
//import com.example.simpsonsviewer.databinding.FragmentForecastDetailBinding
import com.sample.simpsonsviewer.util.parseName


class CharacterDetailFragment : Fragment() {
    private val TAG = "CharacterDetailFragment"
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!
    private val args: com.sample.simpsonsviewer.view.CharacterDetailFragmentArgs by navArgs()
    private lateinit var cDetail: RelatedTopic

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharacterDetailBinding.inflate(layoutInflater, container, false).also {
        _binding = it

        cDetail = args.cDetail
        initViews()

    }.root


    private fun initViews() = with(binding) {


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