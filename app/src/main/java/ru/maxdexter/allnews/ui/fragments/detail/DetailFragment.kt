package ru.maxdexter.allnews.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.maxdexter.allnews.databinding.DetailFragmentBinding
import ru.maxdexter.allnews.ui.model.UINews
import ru.maxdexter.allnews.ui.utils.setImage

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private var news: UINews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        news = arguments?.let {
            DetailFragmentArgs.fromBundle(it).news
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(layoutInflater)
        setUI()
        binding.toolbarDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    private fun setUI() {
        binding.ivArticleImage.setImage(news?.urlToImage)
        binding.tvDescription.text = news?.description
        binding.tvTitle.text = news?.title
        binding.tvSource.text = news?.url
        binding.tvPublishedAt.text = news?.publishedAt
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}