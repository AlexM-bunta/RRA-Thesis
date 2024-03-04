package com.thesis.rra.domain.viewmodels

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesis.rra.data.Restaurant
import com.thesis.rra.domain.repositories.ApiRepository
import kotlinx.coroutines.launch

class RestaurantsViewModel(
    private val repository: ApiRepository = ApiRepository()
) : ViewModel() {

    private val TAG = "VIEW_MODEL"

    private var _restaurantsList = MutableLiveData<SnapshotStateList<Restaurant>>()
    val restaurantsList: LiveData<SnapshotStateList<Restaurant>> = _restaurantsList

    private var _typesList = MutableLiveData<SnapshotStateList<String>>()
    val typesList: LiveData<SnapshotStateList<String>> = _typesList

    fun getRestaurants() {
        viewModelScope.launch {
            try {
                repository.getAll { data ->
                    if (data.isNotEmpty()) {
                        _restaurantsList.value = data
                    }
                }

            } catch (ex: Exception) {
                Log.i(TAG, "getAll: Error - ${ex.message}")
            }
        }
    }

    fun getRestaurantTypes() {
        viewModelScope.launch {
            try {
                repository.getTypes { data ->
                    if (data.isNotEmpty()) {
                        _typesList.value = data
                    }
                }
            } catch (ex: Exception) {
                Log.i(TAG, "getRestaurantTypes: Error - ${ex.message}")
            }
        }
    }

    fun getByType(type: String) {
        viewModelScope.launch {
            try {
                repository.getByType(type) { data ->
                    if (data.isNotEmpty()) {
                        _restaurantsList.value = data
                    }
                }
            } catch (ex: Exception) {
                Log.i(TAG, "getByType: Error - ${ex.message}")
            }
        }
    }

    @Composable
    fun openGoogleMaps(
        latitude: Double,
        longitude: Double
    ) {
        Log.i(TAG, "openGoogleMaps: ${latitude}, ${longitude}")
        
        val mapUri = Uri.parse("https://maps.google.com/maps?daddr=${latitude},${longitude}")
        val intent = Intent(Intent.ACTION_VIEW, mapUri)
        LocalContext.current.startActivity(intent)
    }

}