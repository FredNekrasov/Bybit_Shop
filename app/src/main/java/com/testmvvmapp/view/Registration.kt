package com.testmvvmapp.view

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
import androidx.navigation.NavHostController
import com.testmvvmapp.R.string
import com.testmvvmapp.model.entities.User
import com.testmvvmapp.ui.*
import com.testmvvmapp.view_model.UserVM

@Composable
fun Registration(controller: NavHostController, userVM: UserVM) {
    val userData = userVM.resultSF.collectAsState().value
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }

    var isUserNameCorrect by rememberSaveable { mutableStateOf(false) }
    var isPasswordCorrect by rememberSaveable { mutableStateOf(false) }
    var isEmailCorrect by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(string.registration))
        Spacer(Modifier.height(64.dp))
        TextField(
            userName,
            { userName = it },
            label = { Text(stringResource(string.enterUN),fontFamily = FontFamily.Serif) },
            supportingText = { if(isUserNameCorrect)Text(stringResource(string.incorrectUserName),color = MaterialTheme.colorScheme.error,fontFamily = FontFamily.Serif) },
            isError = isUserNameCorrect,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            password,
            { password = it },
            label = { Text(stringResource(string.enterPassword),fontFamily = FontFamily.Serif) },
            supportingText = { if(isPasswordCorrect) Text(stringResource(string.incorrectPassword),color = MaterialTheme.colorScheme.error,fontFamily = FontFamily.Serif) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            isError = isPasswordCorrect,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            email,
            { email = it },
            label = { Text(stringResource(string.enterEmail),fontFamily = FontFamily.Serif) },
            supportingText = { if(isEmailCorrect) Text(stringResource(string.incorrectEmail),color = MaterialTheme.colorScheme.error,fontFamily = FontFamily.Serif) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = isEmailCorrect,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors()
        )
        Spacer(Modifier.height(8.dp))
        FredTextField(name,{ name = it },stringResource(string.enterName))
        Spacer(Modifier.height(8.dp))
        FredTextField(surname,{ surname = it },id = stringResource(string.enterSurname))
        Spacer(Modifier.height(32.dp))
        FredButton({
            isUserNameCorrect = userName.isBlank()
            isPasswordCorrect = password.isBlank() || password.length < 8
            isEmailCorrect = email.isBlank() || !email.contains("@")
            if(!isEmailCorrect && !isUserNameCorrect && !isPasswordCorrect) userVM.registration(User(userName, password, email, name, surname))
        },stringResource(string.signUp))
        Spacer(Modifier.height(8.dp))
        FredButton({ controller.navigate(ScreenRoutes.Authorization.route) }, stringResource(string.goBack))
        if(userData.first) controller.navigate(ScreenRoutes.Profile.route)
    }
}