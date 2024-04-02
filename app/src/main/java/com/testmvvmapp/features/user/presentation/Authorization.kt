package com.testmvvmapp.features.user.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.testmvvmapp.R
import com.testmvvmapp.ui.*
import com.testmvvmapp.features.user.presentation.viewModel.UserVM

@Composable
fun Authorization(controller: NavController, userVM: UserVM) {
    val userData = userVM.resultSF.collectAsState().value
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isUserNameCorrect by rememberSaveable { mutableStateOf(false) }
    var isPasswordCorrect by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(R.string.authorization))
        Spacer(Modifier.height(64.dp))
        TextField(
            userName,
            { userName = it },
            label = { Text(stringResource(R.string.enterUN), fontFamily = FontFamily.Serif) },
            supportingText = { if(isUserNameCorrect)Text(stringResource(R.string.incorrectUserName), color = MaterialTheme.colorScheme.error, fontFamily = FontFamily.Serif) },
            isError = isUserNameCorrect,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            password,
            { password = it },
            label = { Text(stringResource(R.string.enterPassword), fontFamily = FontFamily.Serif) },
            supportingText = { if(isPasswordCorrect) Text(stringResource(R.string.incorrectPassword), color = MaterialTheme.colorScheme.error, fontFamily = FontFamily.Serif) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            isError = isPasswordCorrect,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors()
        )
        Spacer(Modifier.height(32.dp))
        FredButton({
            isUserNameCorrect = userName.isBlank()
            isPasswordCorrect = password.isBlank() || password.length < 8
            if(!isUserNameCorrect && !isPasswordCorrect) userVM.authorization(userName, password)
        },stringResource(R.string.logIn))
        Spacer(Modifier.height(8.dp))
        FredButton({ controller.navigate(ScreenRoutes.Registration.route) }, stringResource(R.string.registration))
        if(userData.first) controller.navigate(ScreenRoutes.Profile.route)
    }
}