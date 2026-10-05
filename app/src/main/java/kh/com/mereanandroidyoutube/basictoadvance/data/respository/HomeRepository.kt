package kh.com.mereanandroidyoutube.basictoadvance.data.respository

import kotlinx.coroutines.flow.Flow
import kh.com.exercise.model.BaseUiState
import kh.com.exercise.model.general.MaterialComponentModel
import kh.com.mereanandroidyoutube.basictoadvance.data.storage.componentList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds


class HomeRepository {
    fun getHomeData(): Flow<BaseUiState<List<MaterialComponentModel>>> {
        return flow {
            emit(BaseUiState.Loading)
            delay(1000.milliseconds)
            emit(BaseUiState.Success(componentList))
        }
    }
}