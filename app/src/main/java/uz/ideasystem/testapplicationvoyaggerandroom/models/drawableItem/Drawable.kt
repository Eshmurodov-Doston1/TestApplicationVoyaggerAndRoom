package uz.ideasystem.testapplicationvoyaggerandroom.models.drawableItem

import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.core.screen.Screen

data class Drawable(
    val image:Painter,
    val title:String,
    val screen:Screen)
