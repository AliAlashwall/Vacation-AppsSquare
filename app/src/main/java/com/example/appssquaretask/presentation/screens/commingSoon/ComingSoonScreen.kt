package com.example.appssquaretask.presentation.screens.commingSoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appssquaretask.R
import com.example.appssquaretask.presentation.component.FilledButton
import com.example.appssquaretask.presentation.theme.AppsSquareTaskTheme
import com.example.appssquaretask.presentation.theme.background
import com.example.appssquaretask.presentation.theme.onPrimary

@Composable
fun ComingSoonScreen(onRefreshClicked: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            modifier = Modifier.size(204.dp, 188.dp),
            contentDescription = stringResource(id = R.string.app_logo)
        )

        Text(
            text = stringResource(R.string.comming_soon),
            style = MaterialTheme.typography.titleLarge,
            color = onPrimary
        )

        FilledButton(
            text = "Refresh",
            onClick = onRefreshClicked,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 27.dp)
        )
    }
}

@Preview
@Composable
private fun ComingSoonScreenPreview() {
    AppsSquareTaskTheme {
        ComingSoonScreen {}
    }
}