package com.gulehri.pakistan;

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulehri.pakistan.ui.theme.FlagGreen

/*
 * Created by Shahid Iqbal on 8/14/2023.
 */

@Composable
fun MainScreen(mainViewModel: MainViewModel) {


    Column(
        modifier = Modifier
            .height(400.dp)
            .padding(20.dp)
    ) {


        PakistaniFlag()


        Text(
            text = "Happy Independence Day",

            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF4CAF50),
                        if (mainViewModel.theme) Color.White else Color.Black
                    ),
                    tileMode = TileMode.Clamp,
                ),
                fontSize = 30.sp
            ).copy(fontStyle = FontStyle.Italic),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.background(MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(20.dp))
                .padding(10.dp)
        ) {
            Text(
                text = "Night Mode", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1F),
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(modifier = Modifier.width(20.dp))
            Switch(
                checked = mainViewModel.theme,
                onCheckedChange = {
                    mainViewModel.updateTheme()
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = FlagGreen
                )
            )
        }
    }
}