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
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.overvieworganization.screen.FirstList
import com.example.overvieworganization.screen.FirstScreen
import com.example.overvieworganization.screen.GroupList
import com.example.overvieworganization.screen.GroupScreen
import com.example.overvieworganization.screen.ImageList
import com.example.overvieworganization.screen.ImageScreen
import com.example.overvieworganization.screen.InfoList
import com.example.overvieworganization.screen.InfoScreen
import com.example.overvieworganization.screen.IntroduceList
import com.example.overvieworganization.screen.IntroduceScreen
import com.example.overvieworganization.screen.LocateList
import com.example.overvieworganization.screen.LocateScreen
import com.example.overvieworganization.ui.theme.OverviewOrganizationTheme

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

        topBar = {},

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

            composable(route = GroupScreen.Group.name) {
                GroupList()
            }

            composable(route = LocateScreen.Locate.name) {
                LocateList()
            }

            composable(route = ImageScreen.Image.name) {
                ImageList()
            }

            composable(route = InfoScreen.Info.name) {
                InfoList()
            }

            composable(route = IntroduceScreen.Introduce.name) {
                IntroduceList()
            }
        }
    }
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
                onNavigate(GroupScreen.Group.name)
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
                onNavigate(LocateScreen.Locate.name)
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
                onNavigate(ImageScreen.Image.name)
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
                onNavigate(InfoScreen.Info.name)
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
                onNavigate(IntroduceScreen.Introduce.name)
            }
        )
    }
}