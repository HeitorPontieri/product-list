package br.senai.sp.jandira.productlistds3m.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.productlistds3m.model.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        backgroundColor = Color.Red
    ) {
        Column() {
            Text(
                text = " ${product.id} - ${product.productName}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
            Text(
                text = "${product.productDescription}",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = " R$${product.productPrice}",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}