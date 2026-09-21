package kh.com.mereanandroidyoutube.basictoadvance.feature.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.mereanandroidyoutube.model.BaseUiState
import kh.com.mereanandroidyoutube.model.general.MaterialComponentModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Stable
class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {
    private val _stateUiState = MutableStateFlow<BaseUiState<List<MaterialComponentModel>>>(BaseUiState.None)
    val stateUiState = _stateUiState.asStateFlow()

    init {
        getHomeData()
    }

    fun getHomeData() {
        viewModelScope.launch {
            homeRepository.getHomeData().collect { componentListUiState ->
                _stateUiState.emit(componentListUiState)
            }
        }
    }
}
