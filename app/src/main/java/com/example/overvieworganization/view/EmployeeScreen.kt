package com.example.overvieworganization.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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

    Row(
        modifier = Modifier.fillMaxSize().padding(100.dp),
        horizontalArrangement = Arrangement.spacedBy(120.dp)
    ){
        TitleTextButton(onNavigate, "본청")
        TitleTextButton(onNavigate, "읍면동")
    }
}

@Composable
fun TitleTextButton(onNavigate: (String) -> Unit, text: String){
    TextButton(
        onClick = {

        }
    ) {
        TitleText(text)
    }
}

@Composable
fun TitleText(text: String){
    Text(text = text, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)
}