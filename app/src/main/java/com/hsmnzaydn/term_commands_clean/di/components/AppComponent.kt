package com.basefy.burger_king.di.components

import TermApplication
import com.basefy.burger_king.di.modules.AppModule
import com.hsmnzaydn.term_commands_clean.di.modules.ActivityInjectorModules
import com.hsmnzaydn.term_commands_clean.di.modules.NetworkModule
import com.hsmnzaydn.term_commands_clean.di.modules.ViewModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityInjectorModules::class,
        NetworkModule::class,
        ViewModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: TermApplication): Builder

        fun build(): AppComponent

    }

    fun inject(app: TermApplication)
}