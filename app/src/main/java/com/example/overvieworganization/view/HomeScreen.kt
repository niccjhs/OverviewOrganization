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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
        modifier = Modifier.padding(250.dp).background(color = MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.spacedBy(400.dp),
        //text와 카드로 구분
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
            //text 안에 있는 text들 구분
        ) {
            Column(
                //text에 한글 글자 폰트 구분
            ){
                Text(text = "한눈에", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(text = "새로운 세상을", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(text = "만나다.", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Row(
                //text에 영어 글자 폰트 구분
            ){
                Text(text = "Meet a new World ", fontSize = 30.sp, fontWeight = FontWeight.Normal, color = Color.White)
                Text(text = "at a glance.", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
        Row(
            modifier = Modifier.size(width = 300.dp, height = 1000.dp),
            horizontalArrangement = Arrangement.spacedBy(100.dp)
            //카드 안에 있는 카드1과 카드2로 구분
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
                //카드1에 있는 2가지 버튼을 구분
            ){
                TextButton(
                    onClick = {
                        onNavigate(TourScreen.Tour.name)
                    },
                    modifier = Modifier.size(width = 300.dp, height = 200.dp).background(color = Color.White).offset(y = (-20).dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                        //카드1에 관광안내 버튼에서 제목과 소제목 구분
                    ){
                        Text(text = "관광 안내", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                        Column(
                            verticalArrangement = Arrangement.spacedBy(0.dp)
                            //카드1에 관광안내 버튼에서 소제목을 구분
                        ){
                            Text(text = "민원실 좌석 배치도 및 직원 정보를", fontSize = 15.sp, fontWeight = FontWeight.Normal)
                            Text(text = "한눈에 알아볼 수 있도록 소개합니다.", fontSize = 15.sp, fontWeight = FontWeight.Normal)
                        }
                    }
                }
                TextButton(
                    onClick = {
                        onNavigate(EmployeeScreen.Employee.name)
                    },
                    modifier = Modifier.size(width = 300.dp, height = 700.dp).background(MaterialTheme.colorScheme.secondary)
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                        //카드1에 직원안내 버튼에서 제목과 소제목 구분
                    ) {
                        Text(
                            text = "직원 안내",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(0.dp)
                            //카드1에 직원안내 버튼에서 소제목을 구분
                        ){
                            Text(
                                text = "좌석배치도 및 담당자의 주요 업무를",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "소개합니다.",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
                //카드2에 있는 3가지 버튼을 구분
            ) {
                TextButton(
                    onClick = {
                        onNavigate(ImageScreen.Image.name)
                    }
                ){
                    Column(
                        modifier = Modifier.padding(0.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                        //카드2에 포토갤러리 버튼에서 제목과 소제목으로 구분
                    ){
                        Text(
                            text = "포토갤러리",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Photo Gallery",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                        )

                    }
                }
                TextButton(
                    onClick = {
                        onNavigate(LocateScreen.Locate.name)
                    }
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                        //카드2에 청사안내 버튼에서 제목과 소제목으로 구분
                    ){
                        Text(
                            text = "청사안내",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Hall Information",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
                TextButton(
                    onClick = {
                        onNavigate(InfoScreen.Info.name)
                    }
                ){
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                        //카드2에 공지사항 버튼에서 제목과 소제목으로 구분
                    ){
                        Text(
                            text = "공지사항",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Notice & News",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }
        }
    }
}