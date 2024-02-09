package com.example.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeemasters.Pages.InfoPage
import com.example.coffeemasters.Pages.MenuPage
import com.example.coffeemasters.Pages.OffersPage
import com.example.coffeemasters.Pages.OrderPage
import com.example.coffeemasters.ui.theme.Primary

//@Preview
//@Composable
//fun App_Preview() {
//    CoffeeMastersTheme {
//        App()
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    val selectedRoute = remember {
        mutableStateOf("menu")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Primary
                ),
                title = {
                AppTitle()
            })
        },content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
                when (selectedRoute.value) {
                    Routes.MenuPage.route -> MenuPage(dataManager)
                    Routes.OffersPage.route -> OffersPage()
                    Routes.OrderPage.route -> OrderPage(dataManager)
                    Routes.InfoPage.route -> InfoPage()
                }
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = {
                    selectedRoute.value = it
            })
        },
        containerColor = Color.White
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Master Logo"
        )
    }
}

@Preview
@Composable
fun pr() {
    AppTitle()
}