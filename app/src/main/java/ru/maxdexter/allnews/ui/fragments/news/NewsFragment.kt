package ru.maxdexter.allnews.ui.fragments.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.App
import ru.maxdexter.allnews.data.localsource.database.AppDatabase
import ru.maxdexter.allnews.data.localsource.repository.LocalRepositoryImpl
import ru.maxdexter.allnews.data.remotesource.api.RetrofitInstance
import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepositoryImpl
import ru.maxdexter.allnews.databinding.NewsFragmentBinding
import ru.maxdexter.allnews.domain.usecaseimpl.GetCategoryNewsUseCaseImpl
import ru.maxdexter.allnews.domain.usecaseimpl.SaveAndReturnNewsUseCaseImpl
import ru.maxdexter.allnews.ui.adapters.recycler.loadstate.NewsLoadStateAdapter
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsAdapter
import ru.maxdexter.allnews.ui.fragments.home.HomeFragmentDirections
import ru.maxdexter.allnews.ui.utils.loadStateListener
import javax.inject.Inject

private const val NEWS_TYPE = "news type"

class NewsFragment : Fragment() {


    private var newsType: Int = 0
//    private val viewModel: NewsViewModel by lazy {
//        val api = RetrofitInstance.api
//        val newsDao = AppDatabase.invoke(requireContext()).getNewsDao()
//        val localRepository = LocalRepositoryImpl(newsDao)
//        val repository = RemoteRepositoryImpl(api)
//        val useCase = GetCategoryNewsUseCaseImpl(repository)
//        val saveNewsUseCase = SaveAndReturnNewsUseCaseImpl(localRepository)
//        ViewModelProvider(
//            this,
//            NewsViewModelFactory(useCase, saveNewsUseCase)
//        ).get(NewsViewModel::class.java)
//    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<NewsViewModel> { viewModelFactory }


    private lateinit var newsAdapter: NewsAdapter

    private var _binding: NewsFragmentBinding? = null

    private val binding get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.newsComponent()
            .create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsType = it.getInt(NEWS_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsFragmentBinding.inflate(layoutInflater)
        initNewsAdapter()
        return binding.root
    }

    private fun initNewsAdapter() {
        newsAdapter = NewsAdapter {
            viewModel.saveNews(it)
            findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToDetailFragment(it.title)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeData()


    }

    private fun observeData() {
        val categoryList = listOf(
            "general",
            "business",
            "sports",
            "health",
            "science",
            "technology",
            "entertainment"
        )
        lifecycleScope.launch {
            viewModel.getNews(categoryList[newsType]).collect {
                val res = it
                newsAdapter.submitData(res)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvNews.apply {
            adapter = newsAdapter.withLoadStateHeaderAndFooter(
                header = NewsLoadStateAdapter { newsAdapter.retry() },
                footer = NewsLoadStateAdapter { newsAdapter.retry() }
            )
        }
        newsAdapter.loadStateListener(binding, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(type: Int): Fragment {
            return NewsFragment().apply {
                arguments = Bundle().apply {
                    putInt(NEWS_TYPE, type)
                }
            }
        }
    }

}