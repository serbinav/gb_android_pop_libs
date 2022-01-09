package com.example.popularlibs.di

import com.example.popularlibs.user.di.UserComponent
import dagger.Module

@Module(subcomponents = [UserComponent::class])
class AppModule
