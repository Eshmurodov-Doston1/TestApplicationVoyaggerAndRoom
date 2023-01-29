package uz.ideasystem.testapplicationvoyaggerandroom.utils.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import uz.ideasystem.testapplicationvoyaggerandroom.R
import uz.ideasystem.testapplicationvoyaggerandroom.models.drawableItem.Drawable
import uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen.ConversionScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.homeScreen.HomeScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.settings.SettingScreen

@Composable
fun getDrawerLis():List<Drawable>{
   return listOf(
        Drawable(
            painterResource(id = R.drawable.baseline_home_24), stringResource(id = R.string.home_screen),
            HomeScreen
        ),
        Drawable(
            painterResource(id = R.drawable.baseline_change_circle_24), stringResource(id = R.string.convertation_screen),
            ConversionScreen
        ),
        Drawable(
            painterResource(id = R.drawable.baseline_settings_suggest_24), stringResource(id = R.string.settings_screen),
            SettingScreen
        )
    )
}