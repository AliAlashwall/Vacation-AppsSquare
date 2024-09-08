package com.example.appssquaretask.presentation.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appssquaretask.R
import com.example.appssquaretask.presentation.component.FilledButton
import com.example.appssquaretask.presentation.theme.AppsSquareTaskTheme

@Composable
fun StartScreen(onExploreClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.start_image),
            contentDescription = stringResource(
                R.string.start_image
            ), Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            Modifier
                .padding(horizontal = 37.dp)
                .fillMaxSize()) {

            Text(
                text = stringResource(R.string.aspen),
                style = MaterialTheme.typography.displaySmall,
                fontSize = 116.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 100.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(R.string.plan_your),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(11.dp))

            Text(
                text = "Luxurious \n Vacation",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                textAlign = TextAlign.Start
            )

            FilledButton(
                text = stringResource(R.string.explore),
                onClick = onExploreClicked,
                modifier = Modifier.padding(bottom = 57.dp, top = 27.dp)
            )

        }
    }
}

@Preview
@Composable
private fun StartScreenPreview() {
    AppsSquareTaskTheme {
        StartScreen {}
    }
}