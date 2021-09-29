package ru.maxdexter.allnews.ui.fragments.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.maxdexter.allnews.data.localsource.database.AppDatabase
import ru.maxdexter.allnews.data.localsource.repository.LocalRepositoryImpl
import ru.maxdexter.allnews.databinding.FragmentBookmarksBinding
import ru.maxdexter.allnews.domain.usecaseimpl.GetBookmarksUseCaseImpl
import ru.maxdexter.allnews.ui.adapters.recycler.bookmark.BookmarksAdapter

class BookmarksFragment : Fragment() {

    private val bookmarksViewModel: BookmarksViewModel by lazy {
        val newsDao = AppDatabase.invoke(requireContext()).getNewsDao()
        val localRepository = LocalRepositoryImpl(newsDao)
        val getBookmarksUseCase = GetBookmarksUseCaseImpl(localRepository)
        ViewModelProvider(this, BookmarkViewModelFactory(getBookmarksUseCase)).get(
            BookmarksViewModel::class.java
        )
    }
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

    override fun onResume() {
        super.onResume()
        bookmarksViewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)

        bookmarksViewModel.data.observe(viewLifecycleOwner, {
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