package com.coba.cobalivedata

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class MainViewModel : ViewModel() {

    companion object {
        private const val ONE_SECOND = 1000
    }

    private val mInitialTime = MutableLiveData<Long?>()
    private val mElapsedTime = MutableLiveData<Long?>()
    private var timer: Timer? = null

    fun startTimer() {
        mInitialTime.value = SystemClock.elapsedRealtime()
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                val initialTime = mInitialTime.value ?: return
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    fun getElapsedTime(): LiveData<Long?> {
        return mElapsedTime
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}