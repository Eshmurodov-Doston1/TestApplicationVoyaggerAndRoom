package uz.ideasystem.testapplicationvoyaggerandroom.screens.homeScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.ideasystem.testapplicationvoyaggerandroom.R

object HomeScreen:Tab {
    override val options: TabOptions
    @Composable
    get() {
        val title = stringResource(R.string.home_screen)
        val icon = rememberVectorPainter(Icons.Default.Home)
        return remember {
            TabOptions(
                index = 0u,
                title = title,
                icon = icon
            )
        }
    }

    @Composable
    override fun Content() {
        Column(modifier =
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "HomeScreen")
        }
    }
}

@Composable
@Preview
fun HomeScreen_PreView(){
    HomeScreen.Content()
}