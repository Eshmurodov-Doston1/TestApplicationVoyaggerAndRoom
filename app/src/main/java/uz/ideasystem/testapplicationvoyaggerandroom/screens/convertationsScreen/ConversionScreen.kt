package uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.ideasystem.testapplicationvoyaggerandroom.R

object ConversionScreen:Tab {
    override val options: TabOptions
    @Composable
    get(){
        val title = stringResource(R.string.convertation_screen)
        val icon = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.baseline_change_circle_24))
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "ConversionScreen")
        }
    }
}

@Preview
@Composable
fun Convertation_PreView(){
    ConversionScreen.Content()
}