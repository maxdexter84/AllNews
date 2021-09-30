package ru.maxdexter.allnews.ui.fragments.detail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.maxdexter.allnews.App
import ru.maxdexter.allnews.R
import ru.maxdexter.allnews.databinding.DetailFragmentBinding
import ru.maxdexter.allnews.ui.utils.setImage
import javax.inject.Inject

class DetailFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DetailViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.detailComponent()
            .create().inject(this)
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = arguments?.let {
            DetailFragmentArgs.fromBundle(it).title
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(layoutInflater)
        id?.let { viewModel.getNewsFromDatabase(it) }
        setUI()
        navigateUp()
        menuListener()
        changeIconBookmark()
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun changeIconBookmark() {
        viewModel.isBookmark.observe(viewLifecycleOwner, {
            when (it) {
                true -> binding.toolbarDetail.menu.findItem(R.id.bookmark).icon =
                    resources.getDrawable(
                        R.drawable.ic_baseline_bookmark_24,
                        requireActivity().theme
                    )
                false -> binding.toolbarDetail.menu.findItem(R.id.bookmark).icon =
                    resources.getDrawable(
                        R.drawable.ic_baseline_bookmark_border_24,
                        requireActivity().theme
                    )
            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        MenuInflater(requireContext()).inflate(R.menu.detail_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun menuListener() {
        binding.toolbarDetail.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.bookmark -> {
                    viewModel.saveBookmark()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateUp() {
        binding.toolbarDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setUI() {
        viewModel.news.observe(viewLifecycleOwner, { news ->
            binding.ivArticleImage.setImage(news?.urlToImage)
            binding.tvDescription.text = news?.description
            binding.tvTitle.text = news?.title
            binding.tvSource.text = news?.url
            binding.tvPublishedAt.text = news?.publishedAt
            news?.let { viewModel.changeIcon() }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}