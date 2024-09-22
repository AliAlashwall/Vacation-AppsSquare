package com.example.appssquaretask.presentation.screens.popularCities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appssquaretask.R
import com.example.appssquaretask.data.model.Restaurant
import com.example.appssquaretask.presentation.screens.popularCities.component.CityItem
import com.example.appssquaretask.presentation.theme.background
import com.example.appssquaretask.presentation.theme.onPrimary

@Composable
fun PopularCitiesScreen(
    onCityClicked: (String, Int, String, String) -> Unit,
    citiesData: List<Restaurant>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo),
                modifier = Modifier.size(136.dp, 117.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
        }
        item {
            Text(
                text = stringResource(R.string.popular_cities),
                style = MaterialTheme.typography.titleLarge,
                color = onPrimary,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(citiesData) { city ->
            CityItem(
                name = city.name,
                reviewsNum = city.id,
                image = city.image,
                onCityClicked = { onCityClicked(city.name, city.id, city.address, city.image) }
            )
            if (city != citiesData.last()) {
                Spacer(modifier = Modifier.height(26.dp))
            }
        }
    }

}
