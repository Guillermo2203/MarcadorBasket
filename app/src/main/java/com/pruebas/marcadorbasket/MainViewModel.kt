package com.pruebas.marcadorbasket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _localScoreLiveData: MutableLiveData<Int> = MutableLiveData()
    private var _visitorScoreLiveData: MutableLiveData<Int> = MutableLiveData()

    val localScoreLiveData: LiveData<Int>
        get() = _localScoreLiveData
    val visitorScoreLiveData: LiveData<Int>
        get() = _visitorScoreLiveData

    init {
        resetScore()
    }

    fun resetScore() {
        _localScoreLiveData.value = 0
        _visitorScoreLiveData.value = 0
    }

    fun addPointsToScore(points: Int, local: Boolean) {
        if(local) {
            _localScoreLiveData.value = _localScoreLiveData.value?.plus(points)
        } else {
            _visitorScoreLiveData.value = _visitorScoreLiveData.value?.plus(points)
        }
    }

    fun minus1Points(local: Boolean) {
        if (local && _localScoreLiveData.value!! > 0) {
            _localScoreLiveData.value = _localScoreLiveData.value?.minus(1)
        } else if (!local && _visitorScoreLiveData.value!! > 0){
            _visitorScoreLiveData.value = _visitorScoreLiveData.value?.minus(1)
        }
    }


}