package com.gulehri.pakistan

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import com.gulehri.pakistan.ui.theme.FlagGreen
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PakistaniFlag() {

    Canvas(
        modifier =
        Modifier
            .shadow(elevation = 20.dp)
            .size(width = 400.dp, height = 270.dp)
    ) {

        drawRect(color = FlagGreen)

        drawRect(
            color = Color.White,
            size = Size(100.dp.toPx(), height = 270.dp.toPx())
        )

        drawCircle(color = Color.White, radius = 200F, center = Offset(600F, 380F))

        drawCircle(color = FlagGreen, radius = 200F, center = Offset(690F, 380F))

        drawStar()
    }

}

private fun DrawScope.drawStar() {
    val centerX = 700
    val centerY = size.height / 2.0f
    val outerRadius = 100f
    val innerRadius = 25F
    val numVertices = 5
    val angleIncrement = 360f / numVertices

    val starPath = Path()
    for (i in 0 until numVertices * 2) {
        val radius = if (i % 2 == 0) outerRadius else innerRadius
        val angleRad = Math.toRadians(i * angleIncrement.toDouble())
        val x = centerX + (radius * cos(angleRad)).toFloat()
        val y = centerY + (radius * sin(angleRad)).toFloat()
        if (i == 0) starPath.moveTo(x, y) else starPath.lineTo(x, y)
    }
    starPath.close()

    drawPath(
        path = starPath,
        color = Color.White,
        style = Fill,
    )
}


