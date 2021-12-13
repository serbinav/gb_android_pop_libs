package com.example.popularlibs.view

import android.os.Bundle
import com.example.popularlibs.App
import com.example.popularlibs.R
import com.example.popularlibs.databinding.ActivityMainBinding
import com.example.popularlibs.navigate.CustomNavigator
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(){

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navigator = CustomNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) App.instance.router.replaceScreen(LoginScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigationHolder.removeNavigator()
        super.onPause()
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