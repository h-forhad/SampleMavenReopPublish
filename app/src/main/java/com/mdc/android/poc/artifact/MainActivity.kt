package com.mdc.android.poc.artifact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdc.android.poc.artifact.ui.theme.AndroidArtifactJfrogTheme
import com.mdc.android.poc.search.SearchScreen
import com.mdc.android.poc.tasks.TasksScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AndroidArtifactJfrogTheme {
        TabScreen()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabScreen() {
  var tabIndex by remember { mutableStateOf(0) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Tab Screen") },
      )
    },
  ) { padding ->
    Column(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize()
        .padding(16.dp)
    ) {
      TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier.height(80.dp),
        indicator = { tabPositions ->
          SecondaryIndicator(
            Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
            color = MaterialTheme.colorScheme.primary
          )
        },
      ) {
        Tab(
          icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
          text = { Text("Search") },
          selected = tabIndex == 0,
          onClick = { tabIndex = 0 }
        )
        Tab(
          icon = { Icon(Icons.Filled.CheckCircle, contentDescription = "Tasks") },
          text = { Text("Tasks") },
          selected = tabIndex == 1,
          onClick = { tabIndex = 1 }
        )
      }
      when (tabIndex) {
        0 -> SearchScreen()
        1 -> TasksScreen()
      }
    }
  }
}

