package com.example.matule.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.presentation.navigation.Destinations
import com.example.matule.presentation.theme.MatuleTheme
import com.example.matule.presentation.theme.Shadow
import com.example.matule.presentation.theme.poppins
import com.example.matule.presentation.theme.raleway
import com.example.matule.presentation.widget.BottomNavigation
import com.example.matule.presentation.widget.CategoryItem
import com.example.matule.presentation.widget.ProductGrid

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val categories by viewModel.categories.collectAsState()
    val popular by viewModel.popular.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Column(
        Modifier
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(Modifier.height(20.dp))
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                val (burger, text, highlight, bag) = createRefs()
                Text(
                    text = "Главная",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = raleway,
                    color = colorScheme.onBackground,
                    modifier = Modifier.constrainAs(text) {
                        centerHorizontallyTo(parent)
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.home_highlight),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(highlight) {
                        top.linkTo(text.top, margin = (-8).dp)
                        start.linkTo(text.start, margin = (-8).dp)
                    }
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.constrainAs(bag) {
                        top.linkTo(highlight.top, margin = 5.dp)
                        end.linkTo(parent.end)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = colorScheme.onBackground,
                        containerColor = colorScheme.surface
                    )
                ) {
                    Icon(painter = painterResource(R.drawable.ic_bag), contentDescription = "")
                }
                Image(
                    painter = painterResource(R.drawable.burger),
                    contentDescription = "",
                    modifier = Modifier.constrainAs(burger) {
                        bottom.linkTo(text.bottom, margin = 9.dp)
                    })
            }
            Spacer(Modifier.height(22.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    modifier = Modifier
                        .shadow(2.dp, RoundedCornerShape(14.dp))
                        .weight(1f)
                        .background(colorScheme.surface, RoundedCornerShape(14.dp))
                        .padding(start = 26.dp, top = 14.dp, bottom = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = ""
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = "Поиск",
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        color = colorScheme.onSurface
                    )
                }
                IconButton(
                    onClick = {},
                    Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorScheme.primary,
                        contentColor = colorScheme.onPrimary
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sliders),
                        contentDescription = ""
                    )
                }
            }
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Категории",
                color = colorScheme.onBackground,
                fontFamily = raleway,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(16.dp))
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.width(20.dp))
            for (category in categories) {
                CategoryItem(text = category, onClick = {
                    navController.navigate(Destinations.Catalog(it))
                })
                Spacer(Modifier.width(16.dp))
            }
            Spacer(Modifier.width(4.dp))
        }
        Spacer(Modifier.height(24.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Популярное",
                    fontFamily = raleway,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onBackground,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
                Text(
                    text = "Все",
                    fontFamily = poppins,
                    color = colorScheme.primary,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        navController.navigate(Destinations.Popular)
                    }
                )
            }
            Spacer(Modifier.height(30.dp))
            ProductGrid(popular.take(2)) { id, event ->
                println("$id $event")
            }
            Spacer(Modifier.height(30.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Акции",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = raleway,
                    fontSize = 16.sp,
                    color = colorScheme.onBackground
                )
                Text(
                    text = "Все",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    fontFamily = poppins,
                    color = colorScheme.primary
                )
            }
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.sale),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        BottomNavigation(navController)
    }
    if (isLoading) {
        Box(Modifier.fillMaxSize().background(Shadow), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    MatuleTheme {
        Box(Modifier.background(colorScheme.background)) {
            HomeScreen(rememberNavController())
        }
    }
}