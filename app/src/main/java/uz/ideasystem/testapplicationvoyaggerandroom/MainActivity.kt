package uz.ideasystem.testapplicationvoyaggerandroom

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import kotlinx.coroutines.launch
import uz.ideasystem.testapplicationvoyaggerandroom.screens.convertationsScreen.ConvertationScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.homeScreen.HomeScreen
import uz.ideasystem.testapplicationvoyaggerandroom.screens.settings.SettingScreen
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.TestApplicationVoyaggerAndRoomTheme

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
                            title = {Text("Application Toolbar", color = Color.White)},
                            navigationIcon = {
                                IconButton(onClick = {

                                }) {
                                    androidx.compose.material.IconButton(onClick = {
                                        coroutineScope.launch { scaffoldState.drawerState.open() }
                                    }) {
                                        Icon(Icons.Filled.Menu, "backIcon",
                                            tint = Color.White)
                                    }

                                }
                            }
                        )
                    },
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 32.dp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(126.dp)
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
                        }
                    },
                    drawerContentColor = Color.White,
                    drawerBackgroundColor = Color.White,
                    drawerShape = RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp),
                    drawerGesturesEnabled = true,
                    bottomBar = {
                        BottomNavigation {
                            TabNavigationItem(HomeScreen)
                            TabNavigationItem(ConvertationScreen)
                            TabNavigationItem(SettingScreen)
                        }
                    }
                )
            }
        }
    }
}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            androidx.compose.material.Icon(
                painter = tab.options.icon!!,
                contentDescription = tab.options.title
            )
        },
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