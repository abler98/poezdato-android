package net.poezdato.android.kotlin

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 27.09.2018.
 */

fun FragmentManager.addFragment(id: Int, fragment: Fragment): Fragment {
    beginTransaction().add(id, fragment).commit()
    return fragment
}

fun FragmentManager.ensureFragment(id: Int, onCreate: () -> Fragment): Fragment {
    return findFragmentById(id) ?: addFragment(id, onCreate())
}

fun AppCompatActivity.ensureFragment(id: Int, onCreate: () -> Fragment): Fragment {
    return supportFragmentManager.ensureFragment(id, onCreate)
}

fun ViewGroup.inflate(@LayoutRes resource: Int): View {
    return LayoutInflater.from(context).inflate(resource, this, false)
}
