package com.testmvvmapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.testmvvmapp.R.string
import com.testmvvmapp.ui.*

@Composable
fun Registration() {
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        FredText(stringResource(string.registration))
        Spacer(Modifier.height(64.dp))
        FredTextField(userName, { userName = it }, stringResource(string.enterUN))
        Spacer(Modifier.height(8.dp))
        FredOTF(password,{ password = it },stringResource(string.enterPassword),KeyboardType.NumberPassword)
        Spacer(Modifier.height(32.dp))
        FredOTF(password,{ password = it },stringResource(string.enterEmail),KeyboardType.Email)
        Spacer(Modifier.height(32.dp))
        FredTextField(password,{ password = it },stringResource(string.enterName))
        Spacer(Modifier.height(32.dp))
        FredTextField(password,{ password = it },stringResource(string.enterSurname))
        Spacer(Modifier.height(32.dp))
        FredButton({  },stringResource(string.signUp))
    }
}