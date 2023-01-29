package uz.ideasystem.testapplicationvoyaggerandroom.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.ideasystem.testapplicationvoyaggerandroom.R
import uz.ideasystem.testapplicationvoyaggerandroom.models.drawableItem.Drawable
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.Purple40
import uz.ideasystem.testapplicationvoyaggerandroom.utils.extension.getDrawerLis

@Composable
fun DrawableUI(
    scope:CoroutineScope,
    scaffoldState:ScaffoldState,
    listItems:List<Drawable>){
    uiData(scope,scaffoldState,listItems)
}

@Composable
fun uiData(
    scope:CoroutineScope,
    scaffoldState:ScaffoldState,
    listItems:List<Drawable>
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier
                    .matchParentSize(),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
            )
            Image(
                modifier = Modifier
                    .scale(1.4f),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        val currentRoute = LocalNavigator.current

        listItems.forEach { item->
            ItemDrawer(drawable = item, selected = currentRoute?.lastItem == item.screen, onClick = {
                currentRoute?.push(it.screen)
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
    }
}

@Composable
fun ItemDrawer(
    drawable: Drawable,
    selected:Boolean,
    onClick:(Drawable)->Unit){
    Row(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .wrapContentHeight()
            .background(if (selected) Purple40 else Color.White, shape = RoundedCornerShape(5.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = if (selected) Color.White else Purple40
                ),
                onClick = {
                    onClick.invoke(drawable)
                }
            )
            .padding(vertical = 8.dp)
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = drawable.image,
            contentDescription = "Application Circle", colorFilter = ColorFilter.tint(if (selected) Color.White else Color.Black),
            modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = drawable.title, color = if (selected) Color.White else Color.Black)
    }
}

@Preview
@Composable
fun DrawableUI_PreView(){
    uiData(rememberCoroutineScope(), rememberScaffoldState(), getDrawerLis())
}