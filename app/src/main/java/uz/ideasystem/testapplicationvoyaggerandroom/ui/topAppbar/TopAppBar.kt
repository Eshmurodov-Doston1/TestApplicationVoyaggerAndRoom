package uz.ideasystem.testapplicationvoyaggerandroom.ui.topAppbar

import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.ideasystem.testapplicationvoyaggerandroom.R
import uz.ideasystem.testapplicationvoyaggerandroom.screens.homeScreen.HomeScreen
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.Purple40
import uz.ideasystem.testapplicationvoyaggerandroom.ui.theme.Purple80

@Composable
fun TopAppBar(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    tabNavigator: TabNavigator
){
    androidx.compose.material.TopAppBar(
        title = { Text(tabNavigator.current.options.title, color = Color.White) },
        contentColor = contentColorFor(backgroundColor = Purple80),
        backgroundColor = Purple40,
        navigationIcon = {
            if (tabNavigator.current == HomeScreen) {
                IconButton(onClick = {
                    coroutineScope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(Icons.Filled.Menu, "backIcon", tint = Color.White)
                }
            } else {
                IconButton(onClick = {
                    tabNavigator.current = HomeScreen
                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
                }
            }
        },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_filter_list_24), contentDescription = "Search Icon",
                tint = Color.White)
            }
            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon",
                    tint = Color.White)
            }
        }
    )
}

@Composable
@Preview
fun TopAppBar_PreView(){
    TopAppBar(scaffoldState = rememberScaffoldState(), coroutineScope = rememberCoroutineScope(), tabNavigator = LocalTabNavigator.current)
}