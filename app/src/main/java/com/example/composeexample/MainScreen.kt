package com.example.composeexample

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
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
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                }
            })
    },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                BottomNavigationItem(selected = true, onClick = { },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home screen") },
                    label = { Text(text = "Home") })
                BottomNavigationItem(selected = false, onClick = { },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Person profile") },
                    label = { Text(text = "Profile") })
                BottomNavigationItem(selected = false, onClick = { },
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text(text = "Settings") })

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
                    Text(modifier = Modifier
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
