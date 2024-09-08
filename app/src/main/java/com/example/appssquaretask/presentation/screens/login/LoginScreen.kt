package com.example.appssquaretask.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appssquaretask.R
import com.example.appssquaretask.presentation.component.FilledButton
import com.example.appssquaretask.presentation.component.MyTextField
import com.example.appssquaretask.presentation.theme.AppsSquareTaskTheme
import com.example.appssquaretask.presentation.theme.background
import com.example.appssquaretask.presentation.theme.onSecondary
import com.example.appssquaretask.presentation.theme.primary

@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit,
    userPassword: String, userPhoneNumber: String,
    onSignupClicked: () -> Unit
) {

    val phoneNumberState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .background(background)
            .padding(horizontal = 27.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .padding(top = 21.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.app_logo),
                Modifier.size(75.dp, 69.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.login),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = stringResource(R.string.enter_to_your_personal_profile_com_and_follow),
            modifier = Modifier
                .padding(top = 7.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodySmall,
            color = onSecondary
        )

        Spacer(modifier = Modifier.height(14.dp))

        MyTextField(
            value = phoneNumberState.value,
            onValueChange = { phoneNumberState.value = it },
            label = R.string.phone_number,
            keyBoardType = KeyboardType.Phone,
            placeholder = stringResource(R.string.phone_number),
        )

        Spacer(modifier = Modifier.height(14.dp))
        MyTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = R.string.password,
            keyBoardType = KeyboardType.Text,
            placeholder = stringResource(R.string.password),
        )


        Spacer(modifier = Modifier.height(47.dp))

        FilledButton(
            text = stringResource(R.string.login),
            onClick = {
                if (userPhoneNumber == phoneNumberState.value &&
                    userPassword == passwordState.value
                ) {
                    onLoginClicked()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(47.dp))

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.dont_have_account))
                append(" ")
                withStyle(
                    style = MaterialTheme.typography.bodyMedium.toSpanStyle().copy(
                        color = primary, textDecoration = TextDecoration.Underline
                    ),
                ) {
                    append(stringResource(R.string.sign_up))

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onSignupClicked() },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF91919F)
        )


    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    AppsSquareTaskTheme {
        LoginScreen({}, "", "") {}
    }
}