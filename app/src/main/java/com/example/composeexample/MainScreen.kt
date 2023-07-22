package com.example.composeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MainScreen() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Compose App") },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                }
            })
    },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                val selectedItem = remember { mutableStateOf(0) }

                val items = listOf(
                    Triple(Icons.Filled.Home, "Home", "Home screen"),
                    Triple(Icons.Filled.Person, "Profile", "Person profile"),
                    Triple(Icons.Filled.Settings, "Settings", "Settings")

                )
                
                items.forEachIndexed { index, triple ->
                    BottomNavigationItem(
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index },
                        icon = { Icon(triple.first, contentDescription = triple.third) },
                        label = { Text(text = triple.second) },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.primary,
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                //.verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(260.dp)
                        //.clip(CircleShape)
                        //.background(Color.White)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.tree_of_life_flat_vector),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.image_description),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(modifier = Modifier.width(100.dp),
                    onClick = {}) {
                    Text(text = stringResource(id = R.string.go))
                }
                Button(modifier = Modifier.width(100.dp),
                    onClick = {}) {
                    Text(text = stringResource(id = R.string.exit))
                }
            }
        })
}
