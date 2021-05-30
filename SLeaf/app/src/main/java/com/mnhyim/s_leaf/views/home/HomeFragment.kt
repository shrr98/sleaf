package com.mnhyim.s_leaf.views.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mnhyim.s_leaf.R
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.ui.FavoriteAdapter
import com.mnhyim.s_leaf.core.ui.HomeAdapter
import com.mnhyim.s_leaf.databinding.FragmentFavoriteBinding
import com.mnhyim.s_leaf.databinding.FragmentHomeBinding
import com.mnhyim.s_leaf.views.favorite.FavoriteViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@FlowPreview
class HomeFragment : Fragment() {

    private var TAG: String = this::class.java.simpleName

    private val homeViewModel: HomeViewModel by viewModel()

    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val homeAdapter = HomeAdapter()

            homeAdapter.onItemClick = { selectedData ->
                homeViewModel.addFavorite(
                    Plant(
                        id = selectedData.id,
                        className = selectedData.className,
                        name = selectedData.name,
                        desc = selectedData.desc,
                        scientificName = selectedData.scientificName,
                        imageURL = listOf(selectedData.imageURL[0], selectedData.imageURL[1]),
                        isFavorite = true
                    )
                )
                Log.d(TAG, "$selectedData clicked")
            }

            homeViewModel.listPlants.observe(viewLifecycleOwner, { data ->
                homeAdapter.setData(data)
                if (homeAdapter.getItemCount() > 0) homeBinding.progressBar.visibility = View.INVISIBLE
            })

            with(homeBinding.rvPlants) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = homeAdapter
            }
        }
    }
}