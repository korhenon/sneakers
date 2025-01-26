package com.example.matule.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.presentation.navigation.Destinations
import com.example.matule.presentation.theme.MatuleTheme

@Composable
fun BottomNavigation(navController: NavController) {
    val density = LocalDensity.current
    var height by remember { mutableStateOf(0.dp) }
    val currentRoute = navController.currentDestination?.route?.split(".")?.last()
    Box(
        Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.bottom_bar),
            contentDescription = "",
            Modifier
                .fillMaxWidth()
                .offset(y = 4.dp)
                .blur(15.dp)
                .alpha(0.15f)
                .height(height - 4.dp),
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.tint(Color.Black),
            alignment = Alignment.TopCenter
        )
        Image(
            painter = painterResource(id = R.drawable.bottom_bar),
            contentDescription = "",
            Modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    height = with(density) { it.size.height.toDp() }
                },
            contentScale = ContentScale.FillWidth,
        )
        Box(
            Modifier
                .offset(y = -(18).dp)
                .size(104.dp)
                .blur(28.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .size(56.dp)
                    .background(Color(0x995B9EE1), CircleShape)
            )
        }
        IconButton(
            onClick = {}, colors = IconButtonDefaults.iconButtonColors(
                contentColor = colorScheme.onPrimary,
                containerColor = colorScheme.primary
            ), modifier = Modifier
                .size(56.dp)
                .offset(y = (-50).dp)
        ) {
            Icon(painter = painterResource(R.drawable.ic_bag), contentDescription = "")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "",
                    tint = if (currentRoute == "Home") colorScheme.primary else colorScheme.onSurfaceVariant,
                    modifier = if (currentRoute != "Favorites") Modifier.clickable {
                        navController.navigate(Destinations.Home)
                    } else Modifier
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart_navigation),
                    contentDescription = "",
                    tint = if (currentRoute == "Favorites") colorScheme.primary else colorScheme.onSurfaceVariant,
                    modifier = if (currentRoute != "Favorites") Modifier.clickable {
                        navController.navigate(Destinations.Favorites)
                    } else Modifier
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "",
                    tint = if (currentRoute == "Notifications") colorScheme.primary else colorScheme.onSurfaceVariant
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "",
                    tint = if (currentRoute == "Profile") colorScheme.primary else colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    MatuleTheme {
        Box(Modifier.background(colorScheme.background)) {
            BottomNavigation(rememberNavController())
        }
    }
}