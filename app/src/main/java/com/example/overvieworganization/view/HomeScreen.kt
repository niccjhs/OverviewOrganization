package com.example.overvieworganization.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.overvieworganization.viewModel.AppViewModel

enum class HomeScreen {
    Home
}

@Composable
fun HomeList(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    viewModel.setData("처음화면")
    Row(
        modifier = Modifier.fillMaxSize().padding(150.dp),
        horizontalArrangement = Arrangement.spacedBy(350.dp)
        //text와 카드로 구분
    ) {
        Column(
            modifier = Modifier.size(width = 430.dp, height = 220.dp).offset(x = 50.dp, y = 50.dp)
            //text 안에 있는 text들 구분
        ) {
            FirstKorText("한눈에")
            FirstKorText("새로운 세상을")
            FirstKorText("만나다.")
            Row(
                //text에 영어 글자 폰트 구분
            ){
                FirstEngText("Meet a new World ", FontWeight.Normal)
                FirstEngText("at a glance.", FontWeight.Bold)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp)
            //카드 안에 있는 카드1과 카드2로 구분
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
                //카드1에 있는 2가지 버튼을 구분
            ){
                SecondTextButton(onNavigate, TourScreen.Tour.name, MaterialTheme.colorScheme.tertiary, "관광 안내", "민원실 좌석 배치도 및 직원 정보를", "한눈에 알아볼 수 있도록 소개합니다.", MaterialTheme.colorScheme.primary, Icons.Filled.Person, MaterialTheme.colorScheme.onSurface)
                SecondTextButton(onNavigate, EmployeeScreen.Employee.name, MaterialTheme.colorScheme.secondary, "직원안내", "좌석배치도 및 담당자의 주요 업무를", "소개합니다.", MaterialTheme.colorScheme.tertiary, Icons.Filled.DateRange, MaterialTheme.colorScheme.onSurface)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
                //카드2에 있는 3가지 버튼을 구분
            ) {
                ThirdTextButton(onNavigate, ImageScreen.Image.name, "포토갤러리", "Photo Gallery",  Icons.Filled.Favorite)
                ThirdTextButton(onNavigate, LocateScreen.Locate.name, "청사안내", "Hall Information",  Icons.Filled.LocationOn)
                ThirdTextButton(onNavigate, InfoScreen.Info.name, "공지사항", "Notice & News",  Icons.Filled.Info)
            }
        }
    }
}

@Composable
fun SecondTextButton(onNavigate: (String) -> Unit, route: String, color: Color, titleText: String, bodyFirstText: String, bodySecondText: String,textColor: Color, icon: ImageVector, iconColor: Color){
    TextButton(
        modifier = Modifier.size(width = 400.dp, height = 220.dp).offset(y = 50.dp).background(color),
        onClick = {
            onNavigate(route)
        }
    ){
        Column(
            modifier = Modifier.offset(x = (-30).dp, y = (-30).dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
            //카드1에 관광안내 버튼에서 제목과 소제목 구분
        ){
            SecondTitleText(titleText, textColor)
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp)
                //카드1에 관광안내 버튼에서 소제목을 구분
            ){
                SecondBodyText(bodyFirstText, textColor)
                SecondBodyText(bodySecondText, textColor)
            }
        }
        Icon(
            imageVector = icon,
            contentDescription = "아이콘",
            tint = iconColor,
            modifier = Modifier.size(60.dp).offset(x = 30.dp, y = 50.dp)
        )
    }
}

@Composable
fun ThirdTextButton(onNavigate: (String) -> Unit, route: String, titleText: String, bodyText: String, icon: ImageVector){
    TextButton(
        modifier = Modifier.width(width = 250.dp).height(height = 140.dp).offset(y = 50.dp).background(MaterialTheme.colorScheme.primary),
        onClick = {
            onNavigate(route)
        }
    ){
        Column(
            modifier = Modifier.offset(x = 50.dp)
            //카드2에 포토갤러리 버튼에서 제목과 소제목으로 구분
        ){
            ThirdText(titleText, 25.sp, FontWeight.Bold)
            ThirdText(bodyText, 15.sp, FontWeight.Normal)
        }
        Icon(
            imageVector = icon,
            contentDescription = "아이콘",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(40.dp).offset(x = (-120).dp, y = (0).dp)
        )
    }
}

@Composable
fun FirstKorText(text: String) {
    Text(text = text, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
}

@Composable
fun FirstEngText(text: String, bold: FontWeight) {
    Text(text = text, fontSize = 30.sp, fontWeight = bold, color = MaterialTheme.colorScheme.tertiary)
}

@Composable
fun SecondTitleText(text: String, color: Color) {
    Text(text = text, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = color)
}

@Composable
fun SecondBodyText(text: String, color: Color) {
    Text(text = text, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = color)
}

@Composable
fun ThirdText(text: String, size: TextUnit, weight: FontWeight) {
    Text(text = text, fontSize = size, fontWeight = weight, color = MaterialTheme.colorScheme.tertiary)
}