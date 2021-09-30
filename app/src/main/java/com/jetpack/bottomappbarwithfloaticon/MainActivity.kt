package com.jetpack.bottomappbarwithfloaticon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.bottomappbarwithfloaticon.ui.theme.BottomAppBarWithFloatIconTheme
import com.jetpack.bottomappbarwithfloaticon.ui.theme.Purple500
import com.jetpack.bottomappbarwithfloaticon.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBarWithFloatIconTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BottomAppBarWithFab()
                }
            }
        }
    }
}

@Composable
fun BottomAppBarWithFab() {
    val content = remember { mutableStateOf("Home Screen") }
    val selectedItem = remember { mutableStateOf("home") }
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bottom App Bar with FAB"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            content.value = "Navigation Drawer"
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                },
                backgroundColor = Purple500,
                elevation = AppBarDefaults.TopAppBarElevation
            )
        },

        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(15.dp)
            ) {
                Text(
                    text = content.value,
                    color = Color.Black,
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.Center)
                )

                FloatAlertDialog(openDialog = openDialog)
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog.value = true
                },
                shape = RoundedCornerShape(50),
                backgroundColor = Teal200
            ) {
                Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center, //if its not set, it's show default position

        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = selectedItem.value == "home",
                            onClick = {
                                content.value = "Home Screen"
                                selectedItem.value = "home"
                            },
                            icon = {
                                Icon(Icons.Filled.Home, contentDescription = "home")
                            },
                            label = { Text(text = "Home") },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            selected = selectedItem.value == "Setting",
                            onClick = {
                                content.value = "Setting Screen"
                                selectedItem.value = "setting"
                            },
                            icon = {
                                Icon(Icons.Filled.Settings, contentDescription = "setting")
                            },
                            label = { Text(text = "Setting") },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        }
    )
}





















