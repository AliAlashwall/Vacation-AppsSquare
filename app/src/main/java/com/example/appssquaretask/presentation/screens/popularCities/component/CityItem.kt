package com.example.appssquaretask.presentation.screens.popularCities.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appssquaretask.R
import com.example.appssquaretask.data.model.CityData
import com.example.appssquaretask.presentation.theme.AppsSquareTaskTheme
import com.example.appssquaretask.presentation.theme.onPrimary
import com.example.appssquaretask.presentation.theme.primary
import com.example.appssquaretask.presentation.theme.secondary


@Composable
fun CityItem(
    cityData: CityData,
    onCityClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = cityData.image),
            contentDescription = stringResource(id = R.string.city_image),
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = MaterialTheme.shapes.large,
                    spotColor = primary,
                    clip = true
                )
                .size(210.dp, 177.dp)
                .clickable { onCityClicked() },
        )

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = cityData.name,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                color = onPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${cityData.reviewsNum} Reviews",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                color = secondary,
                modifier = Modifier.padding(start = 40.dp)

            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun CityItemPreview() {
    AppsSquareTaskTheme {
        val cityData = CityData(
            name = "Cairo",
            reviewsNum = 355,
            description = R.string.city_description,
            image = R.drawable.first_img
        )
        CityItem(cityData = cityData) {}
    }
}