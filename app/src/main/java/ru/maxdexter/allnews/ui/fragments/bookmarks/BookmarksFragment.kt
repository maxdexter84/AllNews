package ru.maxdexter.allnews.ui.fragments.bookmarks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.maxdexter.allnews.App
import ru.maxdexter.allnews.databinding.FragmentBookmarksBinding
import ru.maxdexter.allnews.ui.adapters.recycler.bookmark.BookmarksAdapter
import javax.inject.Inject

class BookmarksFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!
    private val bookmarksAdapter: BookmarksAdapter by lazy {
        BookmarksAdapter {
            findNavController().navigate(
                BookmarksFragmentDirections.actionBookmarksFragmentToDetailFragment(
                    it.title
                )
            )
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<BookmarksViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.bookmarksComponent()
            .create().inject(this)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)

        viewModel.data.observe(viewLifecycleOwner, {
            bookmarksAdapter.submitList(it)
        })
        binding.rvFavourite.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavourite.adapter = bookmarksAdapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}