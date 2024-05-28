package com.example.littlelemonprojectfinal

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemonprojectfinal.ui.theme.LittleLemonFinalProjectColor

@Composable
fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()) {
    Column {
        WeeklySpecialCard()
        LazyColumn{
            itemsIndexed(dishes) {_, dish ->
                MenuDish(navController,dish)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Text(
            text = stringResource(id = R.string.weekly_special),
            style = MaterialTheme.typography.headlineLarge,
            modifier =
                Modifier
                    .padding(8.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Card(
        onClick =
        {
            Log.d("AAA","Click ${dish.id}")
            navController?.navigate(DishDetails.route + "/${dish.id}"){
                popUpTo(Home.route)
                launchSingleTop = true
            }
        },
        modifier = Modifier.fillMaxHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ){
            Column {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(top = 5.dp, bottom = 5.dp),
                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = dish.name,
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonFinalProjectColor.yellow
    )
}