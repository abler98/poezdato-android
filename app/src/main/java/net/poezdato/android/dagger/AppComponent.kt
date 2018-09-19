package net.poezdato.android.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.poezdato.android.PoezdatoApplication

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<PoezdatoApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PoezdatoApplication>()
}
