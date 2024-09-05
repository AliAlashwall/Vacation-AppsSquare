package com.example.appssquaretask.presentation.screens.cityDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appssquaretask.R
import com.example.appssquaretask.data.model.CityData
import com.example.appssquaretask.presentation.theme.AppsSquareTaskTheme
import com.example.appssquaretask.presentation.theme.onPrimary
import com.example.appssquaretask.presentation.theme.primary
import com.example.appssquaretask.presentation.theme.secondary


@ExperimentalMaterial3Api
@Composable
fun CityDetails(
    cityData: CityData,
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {}, navigationIcon = {
                FilledIconButton(
                    onClick = onBackClicked,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = primary,
                        contentColor = Color.White
                    ),
                    shape = MaterialTheme.shapes.medium, modifier = Modifier.size(44.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = stringResource(R.string.navigate_back),
                    )
                }

            }, modifier = Modifier.padding(vertical = 16.dp, horizontal = 28.dp)
            )
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 26.dp)
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = cityData.image),
                contentDescription = stringResource(
                    R.string.city_image
                ),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        shape = MaterialTheme.shapes.large,
                        spotColor = Color.Unspecified,
                        ambientColor = Color.Unspecified,
                        clip = true
                    )
                    .fillMaxWidth()
                    .weight(1f)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    text = cityData.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = onPrimary
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "${cityData.reviewsNum} Reviews",
                    style = MaterialTheme.typography.labelSmall,
                    color = secondary
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = stringResource(cityData.description),
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun CityDetailsPreview() {
    AppsSquareTaskTheme {
        val cityData = CityData(
            name = "Coeurdes Alpes ",
            image = R.drawable.first_img,
            reviewsNum = 355,
            description = R.string.city_description,
        )
        CityDetails(cityData) {}
    }
}