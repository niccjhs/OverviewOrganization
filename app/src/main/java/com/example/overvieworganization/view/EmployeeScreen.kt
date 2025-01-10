package com.example.overvieworganization.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

