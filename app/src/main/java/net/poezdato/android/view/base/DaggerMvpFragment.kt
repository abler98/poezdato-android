package net.poezdato.android.view.base

import android.content.Context
import android.support.v4.app.Fragment
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 27.09.2018.
 */

abstract class DaggerMvpFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>(),
    HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return this.childFragmentInjector
    }

}
