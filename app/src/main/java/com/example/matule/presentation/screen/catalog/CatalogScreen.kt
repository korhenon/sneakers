package com.example.matule.presentation.screen.catalog

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.matule.presentation.theme.raleway
import com.example.matule.presentation.widget.CategoryItem
import com.example.matule.presentation.widget.ProductGrid

@Composable
fun CatalogScreen(navController: NavController, viewModel: CatalogViewModel = hiltViewModel()) {
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val categories by viewModel.categories.collectAsState()
    val products by viewModel.products.collectAsState()
    Column {
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
                IconButton(onClick = {
                    navController.popBackStack()
                }, modifier = Modifier.size(44.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "",
                        tint = colorScheme.onBackground
                    )
                }
                Text(
                    text = selectedCategory,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = raleway,
                    fontSize = 16.sp,
                    color = colorScheme.onBackground
                )
                Spacer(Modifier.width(44.dp))
            }
            Spacer(Modifier.height(16.dp))
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
                    viewModel.select(it)
                }, isSelected = selectedCategory == category)
                Spacer(Modifier.width(16.dp))
            }
            Spacer(Modifier.width(4.dp))
        }
        Spacer(Modifier.height(20.dp))
        Column(Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {
            ProductGrid(products) { id, event ->

            }
        }
    }
}