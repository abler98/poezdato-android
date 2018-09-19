package net.poezdato.android

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.poezdato.android.dagger.DaggerApplicationComponent

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class PoezdatoApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

}
