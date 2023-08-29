package com.example.ticmasproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)

class MainViewModelTest {

    // Para manejar tareas asíncronas en LiveData
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // El ViewModel a ser probado
    private lateinit var mainViewModel: MainViewModel

    // Mock del Observer para el resultado
    @Mock
    private lateinit var observer: Observer<String>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel()
        mainViewModel.result.observeForever(observer)
    }

    @Test
    fun testCompareTextsEqual() {
        // Arrange
        val text1 = "Hello"
        val text2 = "Hello"

        // Act
        mainViewModel.compareTexts(text1, text2)

        // Assert
        verify(observer).onChanged("Las cadenas son iguales")
    }

    @Test
    fun testCompareTextsDifferent() {
        // Arrange
        val text1 = "Hello"
        val text2 = "World"

        // Act
        mainViewModel.compareTexts(text1, text2)

        // Assert
        verify(observer).onChanged("Las cadenas son diferentes")
    }
}