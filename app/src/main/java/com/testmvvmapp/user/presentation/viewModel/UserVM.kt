package com.testmvvmapp.user.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testmvvmapp.user.data.local.entity.User
import com.testmvvmapp.user.data.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserVM(private val repository: UserRepository) : ViewModel() {
    private val resultMSF = MutableStateFlow<Pair<Boolean, User?>>(false to null)
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