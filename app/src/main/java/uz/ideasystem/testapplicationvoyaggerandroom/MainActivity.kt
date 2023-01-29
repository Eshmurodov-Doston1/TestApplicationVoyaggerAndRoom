package uz.ideasystem.testapplicationvoyaggerandroom

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import kotlinx.coroutines.launch
import uz.ideasystem.testapplicationvoyaggerandroom.models.drawableItem.Drawable
import uz.ideasystem.testapplicationvoyaggerandroom.screens.DrawableUI
import uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen.ConversionScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.homeScreen.HomeScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.settings.SettingScreen
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.Purple40
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.Purple80
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.TestApplicationVoyaggerAndRoomTheme
import uz.ideasystem.testapplicationvoyaggerandroom.utils.extension.getDrawerLis

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            TabNavigator(tab = HomeScreen){ tabNavigator->
                androidx.compose.material.Scaffold(
                    content = {
                       CurrentTab()
                    },
                    topBar = {
                        TopAppBar(
                            title = {Text(tabNavigator.current.options.title, color = Color.White)},
                            contentColor = contentColorFor(backgroundColor = Purple80),
                            backgroundColor = Purple40,
                            navigationIcon = {
                                if (tabNavigator.current == HomeScreen){
                                    androidx.compose.material.IconButton(onClick = {
                                        coroutineScope.launch { scaffoldState.drawerState.open() }
                                    }) {
                                        Icon(Icons.Filled.Menu , "backIcon", tint = Color.White)
                                    }
                                } else {
                                    androidx.compose.material.IconButton(onClick = {
                                        tabNavigator.current = HomeScreen
                                    }) {
                                        Icon(Icons.Filled.ArrowBack , "backIcon", tint = Color.White)
                                    }
                                }
                            }
                        )
                    },
                    drawerContent = {
                        DrawableUI(scope = coroutineScope,scaffoldState, getDrawerLis())
                    },
                    scaffoldState = scaffoldState,
                    drawerContentColor = Color.White,
                    drawerBackgroundColor = Color.White,
                    drawerShape = RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp),
                    drawerGesturesEnabled = true,
                    bottomBar = {
                        BottomNavigation(backgroundColor = Purple40) {
                            TabNavigationItem(HomeScreen,tabNavigator)
                            TabNavigationItem(ConversionScreen,tabNavigator)
                            TabNavigationItem(SettingScreen,tabNavigator)
                        }
                    }
                )
            }
        }
    }
}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab,tabNavigator: TabNavigator) {
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            androidx.compose.material.Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title
            )
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.5F),
        label = {
            Text(text = tab.options.title,
                color = if ( tabNavigator.current == tab) Color.White else Color.Gray,
                fontSize = 10.sp)
        },
        alwaysShowLabel = false
    )
}





@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestApplicationVoyaggerAndRoomTheme {
        Greeting("Android")
    }
}