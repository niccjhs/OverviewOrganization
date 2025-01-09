package com.example.overvieworganization

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
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
import java.text.SimpleDateFormat
import java.util.Calendar

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
                navController.navigate(it) {}
            }
        },
        bottomBar = {
            BottomNavigationBar {
                navController.navigate(it) {}
            }
        },
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = HomeScreen.Home.name, modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = HomeScreen.Home.name) {
                HomeList() { navController.navigate(it) {} }
            }
            composable(route = EmployeeScreen.Employee.name) {
                EmployeeList() { navController.navigate(it) {} }
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

@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    val data by viewModel.data.observeAsState("처음화면")
    TopAppBar(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.09F),
        title = {
            when (data) {
                "처음화면" -> { TopTitleView("처음화면",onNavigate) }
                "직원안내" -> { TopTitleView("직원안내",onNavigate) }
                "청사안내" -> { TopTitleView("청사안내",onNavigate) }
                "포토갤러리" -> { TopTitleView("포토갤러리",onNavigate) }
                "홍보컨텐츠" -> { TopTitleView("홍보컨텐츠",onNavigate) }
                "공지사항" -> { TopTitleView("공지사항",onNavigate) }
                "관광안내" -> { TopTitleView("관광안내",onNavigate) }
            }
        },
        navigationIcon = {
            Row(
                modifier = Modifier.offset(y = 25.dp)
            ){
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "시작 아이콘", tint = MaterialTheme.colorScheme.onSurface, modifier = Modifier.size(40.dp))
                }
            }
        },
        actions = {
            val calendar: Calendar = Calendar.getInstance()
            val sdf = SimpleDateFormat("yyyy.MM.dd.(E) HH:mm a")
            val result = sdf.format(calendar.time)
            Row(
                modifier = Modifier.offset(y = 25.dp)
            ){
                Text(result, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),
    )
}

@Composable
fun TopTitleView(text: String,onNavigate: (String) -> Unit) {
    Row(
        modifier = Modifier.offset(x = 15.dp, y = 20.dp),//텍스트와 아이콘 모두 오른쪽으로 이동
        horizontalArrangement = Arrangement.spacedBy(20.dp)// 아이콘만 오른쪽으로 이동
    ) {
        Text(text, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        IconButton(
            onClick = {
                onNavigate(HomeScreen.Home.name)
            }
        ) {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "시작 아이콘", tint = MaterialTheme.colorScheme.onSurface, modifier = Modifier.size(50.dp).offset(y = 5.dp))
        }
    }
}

@Composable
fun BottomNavigationBar(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    val data by viewModel.data.observeAsState()

    NavigationBar(
        modifier = Modifier.fillMaxHeight(0.09F),
        containerColor = MaterialTheme.colorScheme.primary,

    ) {
        NavigationBarItem(
            label = { Text("방문을 환영합니다.", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary) },
            icon = {},
            selected = false,
            onClick = { onNavigate(HomeScreen.Home.name) }
        )
        NavigationBarItem(
            label = { },
            icon = { },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "처음화면"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("처음으로") },
            icon = { BottomIconView("처음으로", Icons.Filled.Home) },
            selected = false,
            onClick = { onNavigate(HomeScreen.Home.name) }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "직원안내"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("직원안내") },
            icon = { BottomIconView("직원안내", Icons.Filled.DateRange) },
            selected = false,
            onClick = { onNavigate(EmployeeScreen.Employee.name) }
        )
        NavigationBarItem(label = { BottomTextView("청사안내") },
            modifier = Modifier.background(
                if(data == "청사안내"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            icon = { BottomIconView("청사안내", Icons.Filled.LocationOn) },
            selected = false,
            onClick = { onNavigate(LocateScreen.Locate.name) }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "포토갤러리"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("포토갤러리") },
            icon = { BottomIconView("포토갤러리", Icons.Filled.Favorite) },
            selected = false,
            onClick = { onNavigate(ImageScreen.Image.name) }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "홍보컨텐츠"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("홍보컨텐츠") },
            icon = { BottomIconView("홍보컨텐츠", Icons.Filled.PlayArrow) },
            selected = false,
            onClick = { onNavigate(PromoteScreen.Promote.name) }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "공지사항"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("공지사항") },
            icon = { BottomIconView("공지사항", Icons.Filled.Info) },
            selected = false,
            onClick = { onNavigate(InfoScreen.Info.name) }
        )
        NavigationBarItem(
            modifier = Modifier.background(
                if(data == "관광안내"){
                    MaterialTheme.colorScheme.secondary
                }
                else {
                    MaterialTheme.colorScheme.primary
                }
            ),
            label = { BottomTextView("관광안내") },
            icon = { BottomIconView("관광안내", Icons.Filled.Person) },
            selected = false,
            onClick = { onNavigate(TourScreen.Tour.name) }
        )
    }
}

@Composable
fun BottomIconView(text: String, icon: ImageVector) {
    Icon(
        icon,
        contentDescription = "${text} 리스트 아이콘",
        modifier = Modifier.size(40.dp).background(color = MaterialTheme.colorScheme.tertiary)
    )
}

@Composable
fun BottomTextView(text: String) {
    Text(text, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
}