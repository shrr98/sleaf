package com.mnhyim.s_leaf.views.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mnhyim.s_leaf.core.domain.model.Plant
import com.mnhyim.s_leaf.core.domain.usecase.PlantsUseCase
import com.mnhyim.s_leaf.utils.DataMapper
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
@FlowPreview
@ExperimentalCoroutinesApi
class ScanViewModel(private val plantsUseCase: PlantsUseCase) : ViewModel() {

    private val queryChannel = ConflatedBroadcastChannel<String>()
    fun setScanImage(image: String) {
        queryChannel.offer(image)
    }

    val scanResult = queryChannel.asFlow()
        .debounce(100)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .flatMapLatest {
            plantsUseCase.uploadImage(it)
        }.asLiveData()

}