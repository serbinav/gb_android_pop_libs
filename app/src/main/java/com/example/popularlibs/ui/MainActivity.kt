package com.example.popularlibs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popularlibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, CounterFragment())
                .commitNow()
        }
    }
}

//    Напомню ДЗ мы договорились делать отличное от методички:
//    Делаем простую форму авторизации.
//    Сверстайте два fragment'a. Первый содержит два EditText:
//    1) editText логина
//    2) editText пароля
//    3) кнопка продолжить
//    По нажатию на кнопку продолжить логин и пароль пересылаются в презентер 1 фрагмента.
//    Презентер1 валидирует введенные данные, что они не пустые и с помощью чичероне кидает на второй экран.
//    На втором экране прокинуть и отобразить в textView логин, который мы ввели editText на предыдущем экране.
//    Обязательный стек технологий: viewBinding, moxy, cicerone и все это с одним activity
//    В прикрепленных файлах ссылка на гит с кодом урока в помощь
//-------------------------------------------------------------------------------------------
//    В проекте урока есть серьёзная неточность, что делает презентер не тестируемым:
//    ссылки на Android-фреймворк. В методе buttonClick используются конструкции типа
//    R.id.btnCounter1, которых не должно быть в презентере. Переделайте код этого метода,
//    а также вызывающего метода представления так, чтобы в презентере остался только чистый
//    Kotlin-код.