package com.example.overvieworganization.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.overvieworganization.viewModel.AppViewModel

enum class EmployeeScreen {
    Employee
}

@Composable
fun EmployeeList(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    viewModel.setData("직원안내")

    Column(
        modifier = Modifier.fillMaxSize().padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(120.dp)
        ){
            TitleTextButton(onNavigate, "본청")
            TitleTextButton(onNavigate, "읍면동")
            Text(text = "검색하기", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right)
        }
        MainBody()
    }
}

@Composable
fun MainBody(){
    Column(
        modifier = Modifier.offset(x = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodyFirst()
        MainBodySecond()
        MainBodyThird()
    }
}

@Composable
fun MainBodyFirst(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodyFirstTitle()
        MainBodyFirstBody()
    }
}

@Composable
fun MainBodyFirstTitle(){
    Row(
        modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.onPrimary)
    ){
        Text(text = "구청장", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Composable
fun MainBodyFirstBody(){
    MainBodyFirstBodyText("행정문화국")
    MainBodyFirstBodyText("기획재정국")
    MainBodyFirstBodyText("미래경제국")
    MainBodyFirstBodyText("복지가족국")
    MainBodyFirstBodyText("도시관리국")
    MainBodyFirstBodyText("안전교통국")
    MainBodyFirstBodyText("균형발전전추진단")
    MainBodyFirstBodyText("보건소")
}

@Composable
fun MainBodyFirstBodyText(text: String){
    Row(
        modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.onSurface)
    ){
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Composable
fun MainBodySecond(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodySecondTitle()
        MainBodySecondBody()
    }
}

@Composable
fun MainBodySecondTitle(){
    Row(
        modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.onPrimary)
    ){
        Text(text = "부구청장", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Composable
fun MainBodySecondBody(){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodySecondBodyUi("행정지원과", "기획예산과", "지역경제과", "복지정책과", "주택과", "안전관리과", "도시전략과", "보건관리과")
        MainBodySecondBodyUi("자치행정과", "홍보소통과", "일자리정책과", "복지지원과", "건설관리과", "도로과", "도시계획과", "건강관리과")
    }
}

@Composable
fun MainBodySecondBodyUi(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodySecondBodyShape(text1)
        MainBodySecondBodyShape(text2)
        MainBodySecondBodyShape(text3)
        MainBodySecondBodyShape(text4)
        MainBodySecondBodyShape(text5)
        MainBodySecondBodyShape(text6)
        MainBodySecondBodyShape(text7)
        MainBodySecondBodyShape(text8)
    }
}

@Composable
fun MainBodySecondBodyShape(text: String){
    Row(modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.tertiary)){
        MainBodySecondBodyText(text)
    }
}

@Composable
fun MainBodySecondBodyText(text: String){
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
}

@Composable
fun MainBodyThird(){

}

@Composable
fun TitleTextButton(onNavigate: (String) -> Unit, text: String){
    TextButton(
        onClick = {}
    ) {
        TitleText(text)
    }
}

@Composable
fun TitleText(text: String){
    Text(text = text, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
}

