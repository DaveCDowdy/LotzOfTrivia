package com.udemytrainings.lotzoftrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.udemytrainings.lotzoftrivia.screens.TriviaHome
import com.udemytrainings.lotzoftrivia.ui.theme.LotzOfTriviaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LotzOfTriviaTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TriviaHome()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LotzOfTriviaTheme {

    }
}