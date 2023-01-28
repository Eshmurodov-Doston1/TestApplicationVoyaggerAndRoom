package uz.ideasystem.testapplicationvoyaggerandroom.screens.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.ideasystem.testapplicationvoyaggerandroom.R

object SettingScreen:Tab {
    override val options: TabOptions
    @Composable
    get() {
        val title = stringResource(R.string.settings_screen)
        val icon = rememberVectorPainter(Icons.Default.Settings)
        return remember {
            TabOptions(
                index = 2u,
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
fun SettingsScreen_PreView(){
    SettingScreen.Content()
}