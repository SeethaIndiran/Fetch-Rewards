package com.example.fetchapp.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchapp.data.FetchRepository
import com.example.fetchapp.models.Item
import com.example.fetchapp.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchViewModel @Inject constructor( private val repository: FetchRepository): ViewModel() {

    private val _items = MutableLiveData<ScreenState< List<Item>>>()
    val items: LiveData<ScreenState<List<Item>>> get() = _items


    fun getItems(){
        viewModelScope.launch {
                _items.postValue(ScreenState.Loading(null))

            try{
                val response = repository.fetchItems()

                _items.postValue(ScreenState.Success(response))
            }catch (e:Exception){
                _items.postValue(ScreenState.Error("Network Error: ${e.localizedMessage}"))
            }



        }
    }

}