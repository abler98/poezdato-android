package net.poezdato.android.view.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import kotlinx.android.synthetic.main.fragment_timetable.*
import net.poezdato.android.R
import net.poezdato.android.data.entity.Route
import net.poezdato.android.mvp.timetable.TimetablePresenter
import net.poezdato.android.mvp.timetable.TimetableView
import net.poezdato.android.view.base.DaggerMvpFragment
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 27.09.2018.
 */

@FragmentWithArgs
class TimetableFragment : DaggerMvpFragment<TimetableView, TimetablePresenter>(), TimetableView {

    @Inject
    lateinit var mPresenter: TimetablePresenter

    @Arg
    lateinit var route: Route

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentArgs.inject(this)
        presenter.loadTimetable(route)
    }

    override fun createPresenter(): TimetablePresenter {
        return mPresenter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timetable, container, false)
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        timetableTextView.text = message
    }

}
