package br.senai.sp.jandira.productlistds3m

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.productlistds3m.components.ProductCard
import br.senai.sp.jandira.productlistds3m.model.Product
import br.senai.sp.jandira.productlistds3m.DAO.repository.ProductRepository
import br.senai.sp.jandira.productlistds3m.ui.theme.ProductListDS3MTheme
import androidx.compose.ui.tooling.preview.Preview as Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListDS3MTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProductList()
                }
            }
        }
    }
}


@Composable
fun ProductList() {
    var nameState by remember {
        mutableStateOf("")
    }
    var descriptionState by remember {
        mutableStateOf("")
    }
    var priceState by remember {
        mutableStateOf("")
    }
    var productListStates by remember{
        mutableStateOf(listOf<Product>())
    }

    val context = LocalContext.current
    val productRepository = ProductRepository(LocalContext.current)
    productListStates = productRepository.getProductList()


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        OutlinedTextField(value = nameState, onValueChange = { nameState = it })
        OutlinedTextField(value = descriptionState, onValueChange = { descriptionState = it })
        OutlinedTextField(value = priceState,onValueChange = { priceState = it})



        Button(onClick = {
            val p = Product(
                productName = nameState,
                productDescription = descriptionState,
                productPrice = priceState.toDouble()
            )
            val newID = productRepository.saveProductList(p)

            Toast.makeText(context,"$newID", Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Salvar")
        }

        LazyColumn() {
            items(productListStates) {
                ProductCard(product = it)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProductList()
}