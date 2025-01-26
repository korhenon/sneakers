package com.example.matule.presentation.screen.popular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.matule.R
import com.example.matule.data.models.Product
import com.example.matule.presentation.navigation.Destinations
import com.example.matule.presentation.theme.raleway
import com.example.matule.presentation.widget.ProductGrid

@Composable
fun PopularScreen(navController: NavController, viewModel: PopularViewModel = hiltViewModel()) {
    val popular by viewModel.popular.collectAsState()
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }, modifier = Modifier.size(44.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorScheme.surface)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "",
                    tint = colorScheme.onBackground
                )
            }
            Text(
                text = "Популярное",
                fontWeight = FontWeight.SemiBold,
                fontFamily = raleway,
                fontSize = 16.sp,
                color = colorScheme.onBackground
            )
            IconButton(
                onClick = {
                    navController.navigate(Destinations.Favorites)
                },
                modifier = Modifier.size(44.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorScheme.surface)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = colorScheme.onBackground
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        ProductGrid(popular) { id, event -> }
    }
}