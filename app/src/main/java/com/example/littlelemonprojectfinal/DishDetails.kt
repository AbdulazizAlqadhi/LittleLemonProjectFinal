package com.example.littlelemonprojectfinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemonprojectfinal.ui.theme.LittleLemonFinalProjectColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishDetails(id: Int, navController: NavHostController, paddingValues: PaddingValues) {
    val dish = requireNotNull(DishRepository.getDish(id))
    var counter by remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            TopAppBar()
            Box {
                Image(
                    painter = painterResource(id = dish.imageResource),
                    contentDescription = dish.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )
                FilledIconButton(
                    onClick = {
                        navController.navigateUp()
                    },
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = LittleLemonFinalProjectColor.yellow,
                        contentColor = LittleLemonFinalProjectColor.green
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back To Home Icon",
                    )
                }
            }
            Column {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyLarge
                )
                //Counter Composable moved here to make the add For Button responsiveness
                //Counter Start Here
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    TextButton(
                        onClick = {
                            if (counter > 1) counter--
                        }
                    ) {
                        Text(
                            text = "-",
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                    Text(
                        text = counter.toString(),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(16.dp),
                    )
                    TextButton(
                        onClick = {
                            counter++
                        }
                    ) {
                        Text(
                            text = "+",
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }//End of Counter Composable
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LittleLemonFinalProjectColor.yellow,
                        contentColor = LittleLemonFinalProjectColor.green
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.add_for) +
                                " $${counter * dish.price}",
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}