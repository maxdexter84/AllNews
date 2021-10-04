package ru.maxdexter.allnews.ui.fragments.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.maxdexter.allnews.App
import ru.maxdexter.allnews.databinding.HistoryFragmentBinding
import ru.maxdexter.allnews.ui.adapters.recycler.bookmark.BookmarksAdapter
import javax.inject.Inject

class HistoryFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HistoryViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.historyComponent()
            .create().inject(this)
    }

    private var _binding: HistoryFragmentBinding? = null
    private val binding get() = _binding!!
    private val bookmarksAdapter: BookmarksAdapter by lazy {
        BookmarksAdapter {
            findNavController().navigate(
                HistoryFragmentDirections.actionHistoryFragmentToDetailFragment(
                    it.title
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HistoryFragmentBinding.inflate(layoutInflater)

        viewModel.data.observe(viewLifecycleOwner, {
            bookmarksAdapter.submitList(it)
        })
        binding.rvHistory.adapter = bookmarksAdapter

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}