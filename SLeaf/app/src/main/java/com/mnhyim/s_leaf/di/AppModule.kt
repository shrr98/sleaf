package com.mnhyim.s_leaf.di

import com.mnhyim.s_leaf.core.domain.usecase.FavoriteInteractor
import com.mnhyim.s_leaf.core.domain.usecase.FavoriteUseCase
import com.mnhyim.s_leaf.core.domain.usecase.PlantsInteractor
//import com.mnhyim.s_leaf.core.domain.usecase.PlantsInteractor
import com.mnhyim.s_leaf.core.domain.usecase.PlantsUseCase
import com.mnhyim.s_leaf.views.favorite.FavoriteViewModel
import com.mnhyim.s_leaf.views.home.HomeViewModel
import com.mnhyim.s_leaf.views.scan.ScanViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FavoriteUseCase> { FavoriteInteractor(get()) }
    factory<PlantsUseCase> { PlantsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { ScanViewModel(get()) }
}