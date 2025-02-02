package com.example.simpleapp

import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    val words: List<String>,
    val icon: ImageVector // Добавляем поле icon
)
