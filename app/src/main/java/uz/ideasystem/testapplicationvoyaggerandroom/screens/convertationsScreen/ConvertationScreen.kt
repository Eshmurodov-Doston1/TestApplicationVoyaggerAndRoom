package uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.ideasystem.testapplicationvoyaggerandroom.R

object ConvertationScreen:Tab {
    override val options: TabOptions
    @Composable
    get(){
        val title = stringResource(R.string.convertation_screen)
        val icon = rememberVectorPainter(Icons.Default.Call)
        return remember {
            TabOptions(
                index = 1u,
                title = title,
                icon = icon
            )
        }
    }

    @Composable
    override fun Content() {

    }
}

@Preview
@Composable
fun Convertation_PreView(){
    ConvertationScreen.Content()
}