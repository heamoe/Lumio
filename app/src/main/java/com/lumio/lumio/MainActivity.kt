package com.lumio.lumio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.lumio.lumio.ui.theme.LumioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumioTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val items = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Upload", Icons.Default.Add),
        NavItem("Message", Icons.Default.Email),
        NavItem("Profile", Icons.Default.Person)
    )

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedIndex) {
                0 -> HomeScreen()
                1 -> UploadScreen()
                2 -> MessageScreen()
                3 -> ProfileScreen()
            }
        }
    }
}

data class NavItem(val label: String, val icon: ImageVector)

@Composable fun HomeScreen() { Text("Home Screen") }
@Composable fun UploadScreen() { Text("Upload Screen") }
@Composable fun MessageScreen() { Text("Message Screen") }
@Composable fun ProfileScreen() { Text("Profile Screen") }
