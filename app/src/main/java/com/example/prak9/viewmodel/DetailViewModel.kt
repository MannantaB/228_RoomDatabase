package com.example.prak9.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prak9.repositori.RepositoriSiswa
import com.example.prak9.view.route.DestinasiDetailSiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa) : ViewModel(){
        private val idSiswa: Int =
            checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])
        val uiDetailState: StateFlow<DetailSiswaUiState> =
            repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .map {
                    DetailSiswaUiState(detailSiswa = it.toDetailSiswa())
                }.stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                    initialValue = DetailSiswaUiState()
                )
    suspend fun deleteSiswa(){
        repositoriSiswa.deleteSiswa(uiDetailState.value.detailSiswa.toSiswa())
    }

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    }

data class DetailSiswaUiState(
    val detailSiswa: DetailSiswa = DetailSiswa()
)