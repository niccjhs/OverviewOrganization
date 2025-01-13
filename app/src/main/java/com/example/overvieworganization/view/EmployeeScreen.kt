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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.overvieworganization.viewModel.AppViewModel

enum class EmployeeScreen {
    Employee,
    Dong
}

@Composable
fun EmployeeList(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    viewModel.setData("직원안내")
    viewModel.setEmployee("본청")

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
fun DongList(onNavigate: (String) -> Unit) {
    val viewModel: AppViewModel = AppViewModel.getInstance()
    viewModel.setData("직원안내")
    viewModel.setEmployee("읍면동")

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
        DongBody()
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
fun DongBody(){
    Column(
        modifier = Modifier.offset(x = 100.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        DongBodyFirst()
        DongBodySecond()
        DongBodyThird()
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
fun DongBodyFirst(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        DongBodyText("염창동")
        DongBodyText("화곡4동")
        DongBodyText("등촌2등")
        DongBodyText("등촌3등")
        DongBodyText("화곡본동")
        DongBodyText("화곡본동")
        DongBodyText("화곡본동")
        DongBodyText("화곡본동")
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
fun DongBodySecond(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        DongBodyText("화곡4동")
        DongBodyText("화곡6동")
        DongBodyText("화곡8동")
        DongBodyText("우장산동")
        DongBodyText("기양1동")
        DongBodyText("기양1동")
        DongBodyText("기양1동")
        DongBodyText("기양1동")
    }
}

@Composable
fun MainBodyThird(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodyThirdTitle()
        MainBodyThirdBody()
    }
}

@Composable
fun DongBodyThird(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        DongBodyText("공항동")
        DongBodyText("방화1동")
        DongBodyText("방화2동")
        DongBodyText("방화3동")
    }
}

@Composable
fun DongBodyText(text: String){
    Row(
        modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.tertiary)
    ){
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
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
fun MainBodySecondBodyText(text: String){
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
}

@Composable
fun MainBodyThirdTitle(){
    Row(
        modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.primary)
    ){
        Text(text = "감사담당관", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Composable
fun MainBodyThirdBody(){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodyThirdBodyUi("문화예술과", "재무과", "자원순환과", "생활보장과", "도시디자인과", "물관리과", "도시재생과", "의약과")
        MainBodyThirdBodyUi("체육관광과", "세무관리과", "녹색환경과", "출산보육과", "건축과", "교통행정과", "신청사건립추진과", "위생관리과")
        MainBodyThirdBodyUi("교육지원과", "재산세과", "스마트정보과", "아동청소년과", "공원녹지과", "주차관리과", "", "")
        MainBodyThirdBodyUi("민원여권과", "지방소득세과", "", "장애인복지과", "부동산정보과", "안전체험관", "", "")
        MainBodyThirdBodyUi("", "", "", "어르신복지과", "", "", "", "")
    }
}

@Composable
fun MainBodyThirdBodyText(text: String){
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.primary, modifier = Modifier.offset(y = 10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
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
fun MainBodyThirdBodyUi(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        MainBodyThirdBodyShape(text1)
        MainBodyThirdBodyShape(text2)
        MainBodyThirdBodyShape(text3)
        MainBodyThirdBodyShape(text4)
        MainBodyThirdBodyShape(text5)
        MainBodyThirdBodyShape(text6)
        MainBodyThirdBodyShape(text7)
        MainBodyThirdBodyShape(text8)
    }
}

@Composable
fun MainBodySecondBodyShape(text: String){
    Row(modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.tertiary)){
        MainBodySecondBodyText(text)
    }
}

@Composable
fun MainBodyThirdBodyShape(text: String){
    if(text != ""){
        Row(modifier = Modifier.size(width = 180.dp, height = 50.dp).background(MaterialTheme.colorScheme.tertiary)){
            MainBodyThirdBodyText(text)
        }
    }
    else{
        Row(modifier = Modifier.size(width = 180.dp, height = 50.dp)){

        }
    }
}

@Composable
fun TitleTextButton(onNavigate: (String) -> Unit, text: String){
    TextButton(
        onClick = {
            if(text == "읍면동"){
                onNavigate(EmployeeScreen.Dong.name)
            }
            else if(text == "본청"){
                onNavigate(EmployeeScreen.Employee.name)
            }
        }
    ) {
        TitleText(text)
    }
}

@Composable
fun TitleText(text: String){
    val viewModel: AppViewModel = AppViewModel.getInstance()

    if((text == "본청" && viewModel.employee.value.toString() == "본청")||(text == "읍면동" && viewModel.employee.value.toString() == "읍면동")){
        Text(text = text, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.tertiary)
    }
    else{
        Text(text = text, fontSize = 30.sp, fontWeight = FontWeight.Thin, color = MaterialTheme.colorScheme.tertiary)
    }
}