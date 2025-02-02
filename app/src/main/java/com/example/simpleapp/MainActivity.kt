package com.example.simpleapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpleapp.ui.theme.SimpleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Тег для логов
        val TAG = "MainActivity"

        // Создаем список категорий
        val categories = listOf(
            Category(
                id = 1,
                name = "Времена года",
                description = "Слова, связанные с временами года",
                words = listOf("Весна", "Лето", "Осень", "Зима")
            ),
            Category(
                id = 2,
                name = "Приветствия",
                description = "Слова, связанные с приветствиями",
                words = listOf("Привет", "Здравствуйте", "Добрый день", "Добрый вечер")
            ),
            Category(
                id = 3,
                name = "Дни недели",
                description = "Слова, связанные с днями недели",
                words = listOf(
                    "Понедельник",
                    "Вторник",
                    "Среда",
                    "Четверг",
                    "Пятница",
                    "Суббота",
                    "Воскресенье"
                )
            )
        )

        // Логируем создание списка категорий
        Log.d(TAG, "Создан список категорий: $categories")

        setContent {
            SimpleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CategoryList(categories = categories, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = category.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = category.description, style = MaterialTheme.typography.bodyMedium)
        Text(text = "Слов: ${category.words.size}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun CategoryList(categories: List<Category>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(categories) { category ->
            CategoryItem(category = category)
        }
    }
}