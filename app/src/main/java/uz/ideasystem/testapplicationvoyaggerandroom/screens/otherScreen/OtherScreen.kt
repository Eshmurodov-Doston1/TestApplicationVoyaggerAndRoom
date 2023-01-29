package uz.ideasystem.testapplicationvoyaggerandroom.screens.otherScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen.ConversionScreen

data class OtherScreen(val title:String):Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ViewMethode(navigator = navigator)
    }

    @Composable
    fun ViewMethode(navigator:Navigator){
        val tabNavigator = LocalTabNavigator.current
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, modifier = Modifier.clickable {
                tabNavigator.current = ConversionScreen
            })
        }
    }
}
@Preview
@Composable
fun OtherScreen_PreView(){
    OtherScreen("Blah").Content()
}