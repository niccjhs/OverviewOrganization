package com.example.overvieworganization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.overvieworganization.ui.theme.OverviewOrganizationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OverviewOrganizationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            TopBar()
        },

        bottomBar = {
            BottomNavigationBar{
                navController.navigate(it){
                    launchSingleTop = true
                    popUpTo(it){
                        inclusive = true
                    }
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FirstScreen.First.name,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = FirstScreen.First.name) {
                FirstList()
            }

            composable(route = FirstScreen.Group.name) {
                GroupList()
            }

            composable(route = FirstScreen.Location.name) {
                LocationList()
            }

            composable(route = FirstScreen.Image.name) {
                ImageList()
            }

            composable(route = FirstScreen.Information.name) {
                InformationList()
            }

            composable(route = FirstScreen.Introduce.name) {
                IntroduceList()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    val scope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        title = {
            Text("한눈에 조직도")
        },

        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {

                    }
                }
            ){

            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun BottomNavigationBar(onNavigate: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            label = {
                Text("어서오세요. 방문을 환영합니다.")
            },

            icon = {
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.First.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("처음으로")
            },

            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "처음으로 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.First.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("부서조직도")
            },

            icon = {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "부서조직도 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.Group.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("청사안내")
            },

            icon = {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "청사안내 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.Location.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("포토갤러리")
            },

            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "포토갤러리 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.Image.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("공지사항")
            },

            icon = {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "공지사항 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.Information.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("부서소개")
            },

            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "부서소개 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(FirstScreen.Introduce.name)
            }
        )
    }
}