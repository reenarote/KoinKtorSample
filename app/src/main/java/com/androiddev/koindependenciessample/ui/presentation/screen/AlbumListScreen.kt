package com.androiddev.koindependenciessample.ui.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androiddev.koindependenciessample.ui.theme.KoinDependenciesSampleTheme

@Composable
fun AlbumListScreen() {
    Greeting(name = "Droid")
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinDependenciesSampleTheme {
        Greeting("Android")
    }
}