package com.mdc.android.poc.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mdc.android.poc.core.BuildConfig as CoreConfig

@Composable
fun SearchScreen() {

  ProvideTextStyle(MaterialTheme.typography.titleLarge) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "Search version : ${BuildConfig.VERSION_NAME}",
      )

      Text(
        text = "Core Screen : ${CoreConfig.VERSION_NAME}",
      )
    }
  }
}