package ru.maxdexter.allnews.ui.fragments.searchnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.allnews.databinding.FragmentSearchBinding

class SearchNewsFragment : Fragment() {

    private lateinit var searchNewsViewModel: SearchNewsViewModel
    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchNewsViewModel =
            ViewModelProvider(this).get(SearchNewsViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}