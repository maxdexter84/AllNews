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
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.App
import ru.maxdexter.allnews.databinding.NewsFragmentBinding
import ru.maxdexter.allnews.ui.adapters.recycler.loadstate.NewsLoadStateAdapter
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsAdapter
import ru.maxdexter.allnews.ui.fragments.home.HomeFragmentDirections
import ru.maxdexter.allnews.ui.utils.NetworkCheck
import ru.maxdexter.allnews.ui.utils.loadStateListener
import javax.inject.Inject

private const val NEWS_TYPE = "news type"

class NewsFragment : Fragment() {

    private var newsType: Int = 0

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<NewsViewModel> { viewModelFactory }

    @Inject
    lateinit var checkNetwork: NetworkCheck

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.newsComponent()
            .create().inject(this)
    }

    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter {
            viewModel.saveNews(it)
            findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToDetailFragment(it.title)
            )
        }
    }

    private var _binding: NewsFragmentBinding? = null

    private val binding get() = _binding!!


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
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeData()
        observeNetwork()
        initBtnRetry()
    }

    private fun initBtnRetry() {
        binding.btnRetrySearch.setOnClickListener {
            newsAdapter.retry()
        }
    }

    private fun observeNetwork() {
        checkNetwork.observe(viewLifecycleOwner, {
            parseResult(it)
            newsAdapter.retry()
        })
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.getNews(newsType).collect {
                newsAdapter.submitData(it)
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

    private fun parseResult(result: Boolean) {
        when (result) {
            false -> showSnackBar("Отсутствует интернет соедтинение!")
            true -> {}
        }
    }

    private fun showSnackBar(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG).show()
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