package ru.maxdexter.allnews.ui.fragments.searchnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.data.remotesource.api.RetrofitInstance
import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepositoryImpl
import ru.maxdexter.allnews.databinding.FragmentSearchBinding
import ru.maxdexter.allnews.domain.usecaseimpl.GetSearchNewsUseCaseImpl
import ru.maxdexter.allnews.ui.adapters.recycler.loadstate.NewsLoadStateAdapter
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsAdapter
import ru.maxdexter.allnews.ui.utils.loadStateListener

class SearchNewsFragment : Fragment() {

    private val viewModel: SearchNewsViewModel by lazy {
        val api = RetrofitInstance.api
        val repository = RemoteRepositoryImpl(api)
        val useCase = GetSearchNewsUseCaseImpl(repository)
        ViewModelProvider(
            this,
            SearchNewsViewModelFactory(useCase)
        ).get(SearchNewsViewModel::class.java)
    }
    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRvAdapter()
        initRecyclerView()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startSearching()
    }

    override fun onResume() {
        super.onResume()
        searching()
    }


    private fun startSearching() {
        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searching()
                true
            } else {
                false
            }
        }
    }

    private fun searching() {
        binding.etSearch.text.trim().let { query ->
            if (query.isNotEmpty()) {
                observeData(query)
            }
        }
    }

    private fun observeData(query: CharSequence) {
        lifecycleScope.launch {
            viewModel.getNews(query.toString()).collect {
                newsAdapter.submitData(it)
            }

        }
    }

    private fun initRvAdapter() {
        newsAdapter = NewsAdapter {
            findNavController().navigate(
                SearchNewsFragmentDirections.actionNavigationSearchToDetailFragment(
                    it
                )
            )
        }
    }

    private fun initRecyclerView() {
        binding.rvSearchNews.apply {
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
}