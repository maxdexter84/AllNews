package ru.maxdexter.allnews.ui.fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.maxdexter.allnews.databinding.NewsFragmentBinding
private const val NEWS_TYPE = "news type"
class NewsFragment : Fragment() {


    private var newsType: Int? = null
    private lateinit var viewModel: NewsViewModel

    private var _binding: NewsFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
           newsType =  it?.getInt(NEWS_TYPE, -1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(type: Int): Fragment{
            return NewsFragment().apply {
                arguments = Bundle().apply {
                    putInt(NEWS_TYPE, type)
                }
            }
        }
    }

}