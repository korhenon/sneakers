package com.example.matule.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.example.matule.R
import com.example.matule.data.models.Product
import com.example.matule.presentation.theme.poppins

enum class ProductCardEventType {
    Details, ToggleFavorite, AddToCart, GoToCart
}

@Composable
fun ProductCard(
    product: Product,
    eventListener: (Int, ProductCardEventType) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(colorScheme.surface)
            .clickable {
                eventListener(product.id, ProductCardEventType.Details)
            },
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(Modifier.height(18.dp))
            Image(
                painter = rememberAsyncImagePainter(product.image),
                contentDescription = "",
                modifier = Modifier
                    .height(70.dp)
                    .padding(horizontal = 9.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.Center

            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "BEST SELLER",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 9.dp)
            )
            Text(
                text = product.name,
                fontFamily = poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorScheme.onSurface,
                lineHeight = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 9.dp)
            )
            Spacer(Modifier.height(4.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 9.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "₽${"%.2f".format(product.price).replace(',', '.')}",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onBackground,
                    lineHeight = 16.sp
                )
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            colorScheme.primary,
                            shape = RoundedCornerShape(topStart = 16.dp)
                        )
                        .clickable {
                            if (!false) {
                                eventListener(product.id, ProductCardEventType.AddToCart)
                            } else {
                                eventListener(product.id, ProductCardEventType.GoToCart)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (!false) Icon(
                        painter = painterResource(id = R.drawable.ic_add_to_cart),
                        contentDescription = "",
                        tint = colorScheme.onPrimary
                    ) else Icon(
                        painter = painterResource(id = R.drawable.ic_to_cart),
                        contentDescription = "",
                        tint = colorScheme.onPrimary
                    )
                }
            }
        }
        Box(
            Modifier
                .padding(start = 9.dp, top = 9.dp)
                .size(28.dp)
                .background(colorScheme.background, CircleShape)
                .clickable {
                    eventListener(product.id, ProductCardEventType.ToggleFavorite)
                },
            contentAlignment = Alignment.Center
        ) {
            if (false) Image(
                painter = painterResource(id = R.drawable.ic_heart_filled),
                contentDescription = ""
            ) else Icon(
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = "",
                tint = colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ProductGrid(list: List<Product>, eventListener: (Int, ProductCardEventType) -> Unit) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(15.dp)) {
        for (i in 0..<(list.size + 1) / 2) {
            println(i)
            val selection = list.drop(i * 2).take(2)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                ProductCard(selection[0], eventListener, modifier = Modifier.weight(1f))
                if (selection.size > 1) {
                    ProductCard(selection[1], eventListener, modifier = Modifier.weight(1f))
                } else {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}