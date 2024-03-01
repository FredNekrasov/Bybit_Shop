package com.testmvvmapp.view_model

import androidx.lifecycle.*
import com.testmvvmapp.model.entities.User
import com.testmvvmapp.model.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val resultMSF = MutableStateFlow<Pair<Boolean,User?>>(false to null)
    val resultSF = resultMSF.asStateFlow()
    fun authorization(userName: String, password: String) {
        viewModelScope.launch {
            repository.logIn(userName, password).also {
                if(it == null) resultMSF.emit(false to null) else resultMSF.emit(true to it)
            }
        }
    }
    fun registration(user: User) {
        viewModelScope.launch {
            repository.signUp(user).also {
                if(it == null) resultMSF.emit(false to null) else resultMSF.emit(true to it)
            }
        }
    }
}