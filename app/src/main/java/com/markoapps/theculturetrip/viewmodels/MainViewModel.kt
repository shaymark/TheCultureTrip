package com.markoapps.theculturetrip.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.markoapps.theculturetrip.network.ApiService
import com.markoapps.theculturetrip.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: ApiService
    ): ViewModel() {

    fun getArticles() = liveData (Dispatchers.IO){
                emit(Resource.loading(null))
            try{
                emit(Resource.success(apiService.getArticles().data))
            } catch (e : Exception){
                emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
            }
    }

}