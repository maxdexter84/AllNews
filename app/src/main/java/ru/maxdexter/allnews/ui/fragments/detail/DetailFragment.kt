package ru.maxdexter.allnews.ui.fragments.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.maxdexter.allnews.R
import ru.maxdexter.allnews.data.localsource.database.AppDatabase
import ru.maxdexter.allnews.data.localsource.repository.LocalRepositoryImpl
import ru.maxdexter.allnews.databinding.DetailFragmentBinding
import ru.maxdexter.allnews.domain.usecaseimpl.GetNewsFromDbByIdImpl
import ru.maxdexter.allnews.domain.usecaseimpl.SaveNewsUseCaseImpl
import ru.maxdexter.allnews.ui.utils.setImage

class DetailFragment : Fragment() {


    private val viewModel: DetailViewModel by lazy {

        val newsDao = AppDatabase.invoke(requireContext()).getNewsDao()
        val localRepository = LocalRepositoryImpl(newsDao)
        val getNewsFromDbById = GetNewsFromDbByIdImpl(localRepository)
        val saveNewsUseCase = SaveNewsUseCaseImpl(localRepository)
        ViewModelProvider(
            this,
            DetailViewModelFactory(
                saveNewsUseCase,
                getNewsFromDbById
            )
        ).get(DetailViewModel::class.java)
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