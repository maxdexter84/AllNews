package ru.maxdexter.allnews.ui.adapters.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.maxdexter.allnews.ui.fragments.news.NewsFragment

const val PAGE_COUNT = 7

class MainViewPagerAdapter(private val container: FragmentActivity) :
    FragmentStateAdapter(container) {
    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return NewsFragment.newInstance(position)
    }


}