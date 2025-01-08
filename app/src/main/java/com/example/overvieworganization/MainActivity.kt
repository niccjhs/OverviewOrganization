package com.example.overvieworganization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.overvieworganization.ui.theme.OverviewOrganizationTheme
import com.example.overvieworganization.view.EmployeeList
import com.example.overvieworganization.view.EmployeeScreen
import com.example.overvieworganization.view.HomeList
import com.example.overvieworganization.view.HomeScreen
import com.example.overvieworganization.view.ImageList
import com.example.overvieworganization.view.ImageScreen
import com.example.overvieworganization.view.InfoList
import com.example.overvieworganization.view.InfoScreen
import com.example.overvieworganization.view.LocateList
import com.example.overvieworganization.view.LocateScreen
import com.example.overvieworganization.view.PromoteList
import com.example.overvieworganization.view.PromoteScreen
import com.example.overvieworganization.view.TourList
import com.example.overvieworganization.view.TourScreen
import com.example.overvieworganization.viewModel.AppViewModel

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
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            TopBar {
                navController.navigate(it) {
                    launchSingleTop = true
                    popUpTo(it) {
                        inclusive = true
                    }
                }
            }
        },

        bottomBar = {
            BottomNavigationBar {
                navController.navigate(it) {
                    launchSingleTop = true
                    popUpTo(it) {
                        inclusive = true
                    }
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeScreen.Home.name,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = HomeScreen.Home.name) {
                HomeList{  navController.navigate(it) {
                    launchSingleTop = true
                    popUpTo(it) {
                        inclusive = true
                    }
                }}
            }

            composable(route = EmployeeScreen.Employee.name) {
                EmployeeList()
            }

            composable(route = LocateScreen.Locate.name) {
                LocateList()
            }

            composable(route = ImageScreen.Image.name) {
                ImageList()
            }

            composable(route = PromoteScreen.Promote.name) {
                PromoteList()
            }

            composable(route = InfoScreen.Info.name) {
                InfoList()
            }

            composable(route = TourScreen.Tour.name) {
                TourList()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    val data by viewModel.data.observeAsState("처음화면")

    TopAppBar(
        title = {
            when (data) {
                "처음화면" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),//텍스트와 아이콘 모두 오른쪽으로 이동
                        horizontalArrangement = Arrangement.spacedBy(20.dp)// 아이콘만 오른쪽으로 이동
                    ){
                        Text("처음화면", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "직원안내" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("직원안내", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "청사안내" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("청사안내", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "포토갤러리" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("포토갤러리", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "홍보컨텐츠" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("홍보컨텐츠", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "공지사항" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("공지사항", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
                "관광안내" -> {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .offset(x = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Text("관광안내", fontSize = 40.sp, fontWeight = FontWeight.Bold)

                        IconButton(
                            onClick = {
                                onNavigate(HomeScreen.Home.name)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "시작 아이콘",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(50.dp).offset(y = 5.dp)
                            )
                        }
                    }
                }
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "시작 아이콘",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {
            Text("2025.01.07.(화) 9:54 오전", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.secondary,
        ),
    )
}

@Composable
fun BottomNavigationBar(onNavigate: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            label = {
                Text("방문을 환영합니다.")
            },

            icon = {
            },
            selected = false,
            onClick = {
                onNavigate(HomeScreen.Home.name)
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
                onNavigate(HomeScreen.Home.name)
            }
        )

        NavigationBarItem(
            label = {
                Text("직원안내")
            },

            icon = {
                Icon(

                    Icons.Filled.DateRange,
                    contentDescription = "직원안내 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(EmployeeScreen.Employee.name)
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
                Text("홍보컨텐츠")
            },

            icon = {
                Icon(
                    Icons.Filled.PlayArrow,
                    contentDescription = "홍보컨텐츠 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(PromoteScreen.Promote.name)
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
                Text("관광안내")
            },

            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "관광안내 리스트 아이콘"
                )
            },
            selected = false,
            onClick = {
                onNavigate(TourScreen.Tour.name)
            }
        )
    }
}