package com.example.popularlibs

import android.os.Bundle
import com.example.popularlibs.counters.CounterScreen
import com.example.popularlibs.databinding.ActivityMainBinding
import com.example.popularlibs.exponentiation.ExponentiationScreen
import com.example.popularlibs.login.LoginScreen
import com.example.popularlibs.navigate.CustomNavigator
import com.example.popularlibs.users.UsersScreen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navigator = CustomNavigator(this, R.id.container)

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        App.instance.component.inject(this)

        if (savedInstanceState == null) {
            router.replaceScreen(UsersScreen)
        }

        binding.fabCounter.setOnClickListener {
            router.replaceScreen(CounterScreen)
        }

        binding.fabLogin.setOnClickListener {
            router.replaceScreen(LoginScreen)
        }

        binding.fabExponentiation.setOnClickListener {
            router.replaceScreen(ExponentiationScreen)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}

//-------------------------------------------------------------------------------------------
//    Возвращаемся к GitHubApi и UsersFragment -> UserFragment
//
//    На первом экране, как и прежде получаем список user
//    На втором экране получаем список репозиториев пользователя
//    (GitHubApi -> метод fetchUserRepositories).
//    И кэшируем список репозиториев в Room.
//    (Структуру можно взять отсюда https://api.github.com/users/mojombo/repos
//    необзяательно прописывать все поля)
//    Чтобы закешировать список репозиториев необходима новая таблица в Room и Dao, а также новый репозиторий.
//
//    Заинжектите новый репозиторий в презентер через отдельный SubComponent, чтобы новый repository
//    и dao имели время жизни как у subComponent
//-------------------------------------------------------------------------------------------
//    Перевести проект с предыдущего домашнего задания (про Room) на dagger
//
//-------------------------------------------------------------------------------------------
//    Импортировать в проект Room и при первом обращении к БД записать ответ сервера в Базу данных.
//
//    Далее при нажатии на элемент списка с помощью cicrone перекинуть на второй экран.
//    На втором экране вместо похода в сеть , взять список GitHubUsers
//    из базы данных и отоюразить любое поле в единственном TextView
//    https://github.com/Lime94/GeekBrains_PopularLib/tree/roomDatabase/app/src - код с урока.
//    Не забывайте нажимать MakeProject после каждого обновления структуры БД
//-------------------------------------------------------------------------------------------
//    Мы договорились взять пример из второго урока с двумя фрагментами users и user за основу.
//
//    После клика по одному из пользователей на первом экране, переходим на второй экран.
//    На втором экране, используя presenter, надо сделать серверный запрос и получить результат.
//    и любое поле из ответа сервера отобразить в textView
//    https://api.github.com/users
//-------------------------------------------------------------------------------------------
//    Написать следующий экран на MVP
//    EditText
//    Кнопка ОК.
//    Логика: В текстовое поле вводится число.
//    По нажатию на кнопку, берем значение из EditText
//    и идем с ним в презентер.
//    Перемножаем число само на себя (возводим в квадрат)
//    и возвращаем результат на View.
//
//    Условие: Запускать цепочку логики надо через Subject
//    (какой сабджект выбрать - решать вам), через метод onNext()
//    Математическое вычисление должно быть на фоновом потоке
//    (какой именно Scheduler использовать - решать вам)
//-------------------------------------------------------------------------------------------
//    Новые рельсы, чтобы была некая модель(репозиторий) который содержит возможные пары
//    "логин/пароль" с помощью RxJava. Чтобы презентер ходил в модель и забирал оттуда данные с помощью Observable
//
//    Переделайте взаимодействие модели и логики в коде из второго урока на Rx-паттерн.
//    * Самостоятельно изучите оператор switchMap. Разберитесь, как он работает и чем отличается от flatMap.
//    Сформулируйте и напишите ответ в комментарии к практическому заданию. Для экспериментов воспользуйтесь
//    приведённым на уроке примером с flatMap, замените его на switchMap, а остальное оставьте без изменений.
//-------------------------------------------------------------------------------------------
//    Делаем простую форму авторизации.
//    Сверстайте два fragment'a. Первый содержит два EditText:
//    1) editText логина
//    2) editText пароля
//    3) кнопка продолжить
//    По нажатию на кнопку продолжить логин и пароль пересылаются в презентер 1 фрагмента.
//    Презентер1 валидирует введенные данные, что они не пустые и с помощью чичероне кидает на второй экран.
//    На втором экране прокинуть и отобразить в textView логин, который мы ввели editText на предыдущем экране.
//    Обязательный стек технологий: viewBinding, moxy, cicerone и все это с одним activity
//-------------------------------------------------------------------------------------------
//    В проекте урока есть серьёзная неточность, что делает презентер не тестируемым:
//    ссылки на Android-фреймворк. В методе buttonClick используются конструкции типа
//    R.id.btnCounter1, которых не должно быть в презентере. Переделайте код этого метода,
//    а также вызывающего метода представления так, чтобы в презентере остался только чистый
//    Kotlin-код.