package r2.adam.motion.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import r2.adam.motion.model.CustomModel

class MainViewModel : ViewModel() {

    private val _customLiveData: MutableLiveData<List<CustomModel>> = MutableLiveData()
    val customLiveData: LiveData<List<CustomModel>> get() = _customLiveData


    init {
        _customLiveData.value = (1..10).map {
            CustomModel(it)
        }
    }
}