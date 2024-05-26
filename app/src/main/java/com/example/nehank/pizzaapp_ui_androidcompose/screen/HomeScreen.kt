package com.example.nehank.pizzaapp_ui_androidcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.pizzaapp_ui_androidcompose.R
import com.example.nehank.pizzaapp_ui_androidcompose.common_ui.CustomIconButton
import com.example.nehank.pizzaapp_ui_androidcompose.common_ui.SpacerHeight
import com.example.nehank.pizzaapp_ui_androidcompose.data.Pizza
import com.example.nehank.pizzaapp_ui_androidcompose.data.chipsList
import com.example.nehank.pizzaapp_ui_androidcompose.data.pizzaList
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.BackgroundColor
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.DarkBlackColor
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.LightGrayColor
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.RedColor
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.YellowColor

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader()
        ChipsLayout()
        PizzaList()
    }
}

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .background(RedColor), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CustomIconButton(
                    icon = R.drawable.menu,
                    imageTitle = "Menu",
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {}
                Text(text = "App Title", style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
            CustomIconButton(
                icon = R.drawable.search,
                imageTitle = "Search",
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {}
        }
    }

}

@Composable
fun ChipsLayout() {

    var isSelectedState by remember {
        mutableIntStateOf(0)
    }

    LazyRow {
        items(chipsList.size) { index ->
            Row {
                ChipsLayoutItem(
                    chipName = chipsList[index],
                    isSelected = isSelectedState == index
                ) {
                    isSelectedState = index
                }
            }
        }
    }
}

@Composable
fun PizzaList() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(start = 4.dp, end = 4.dp)) {
        items(pizzaList) {
            PizzaLayoutItem(pizzaItem = it)
        }
    }
}

@Composable
fun CustomFloatingActionButton() {
    Box(modifier = Modifier.clip(RoundedCornerShape(40.dp)).background(DarkBlackColor)){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "£60.40",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp,
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(painter = painterResource(id = R.drawable.pizza), contentDescription = "pizza")
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
}

@Composable
fun PizzaLayoutItem(pizzaItem: Pizza) {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundColor)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = pizzaItem.image),
                contentDescription = pizzaItem.name
            )
            SpacerHeight()
            Text(text = pizzaItem.price, style = TextStyle(color = RedColor, fontSize = 16.sp))
            SpacerHeight()
            Text(
                text = pizzaItem.name,
                style = TextStyle(
                    color = DarkBlackColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1
            )
            SpacerHeight()
            Text(
                text = pizzaItem.description,
                style = TextStyle(
                    color = LightGrayColor,
                    fontSize = 14.sp,
                ),
                maxLines = 2
            )
            SpacerHeight()
            Button(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = YellowColor)) {
                Text(text = "Add", style = TextStyle(color = Color.White))
            }

        }
    }
}

@Composable
fun ChipsLayoutItem(
    chipName: String,
    isSelected: Boolean,
    onChipSelected: (String) -> Unit
) {
    Box(modifier = Modifier.background(color = BackgroundColor))
    TextButton(
        onClick = { onChipSelected(chipName) },
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .background(
                color = if (isSelected) YellowColor else Color.Transparent,
                shape = RoundedCornerShape(50.dp)
            ),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = chipName, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else DarkBlackColor,
            )
        )
    }
}
