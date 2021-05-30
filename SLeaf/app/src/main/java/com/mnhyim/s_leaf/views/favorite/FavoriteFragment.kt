package com.mnhyim.s_leaf.views.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.ui.FavoriteAdapter
import com.mnhyim.s_leaf.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _favoriteBinding: FragmentFavoriteBinding? = null
    private val favoriteBinding get() = _favoriteBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _favoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            // TODO: DEBUG BUTTON, hapus nnti
            favoriteBinding.btnDebug.setOnClickListener {
                val c = Calendar.getInstance()
                val x = c.get(Calendar.SECOND)
                favoriteViewModel.addFavorite(
                    Plant(
                        id = 0,
                        className = "Classname $x",
                        name = "Name $x",
                        desc = "Desc  $x",
                        scientificName = "ScientificName $x",
                        imageURL = "imageURL $x",
                        isFavorite = true
                    )
                )
            }

            val favoriteAdapter = FavoriteAdapter()
            favoriteAdapter.onItemClick = { selectedData ->
                Log.d("FavoriteFragment", "$selectedData clicked")
            }

            favoriteViewModel.listFavorite.observe(viewLifecycleOwner, { dataFavorite ->
                favoriteAdapter.setData(dataFavorite)
                Log.d("FavoriteFragment", "${favoriteViewModel.listFavorite.value}")
            })

            with(favoriteBinding.rvPlants) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteAdapter
            }
        }
    }
}