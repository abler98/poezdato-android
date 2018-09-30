package net.poezdato.android.view.timetable

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hannesdorfmann.fragmentargs.FragmentArgs
import com.hannesdorfmann.fragmentargs.annotation.Arg
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import net.poezdato.android.R
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.Timetable
import net.poezdato.android.mvp.timetable.TimetablePresenter
import net.poezdato.android.mvp.timetable.TimetableView
import net.poezdato.android.view.base.DaggerMvpLceFragment
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 27.09.2018.
 */

@FragmentWithArgs
class TimetableFragment :
    DaggerMvpLceFragment<RecyclerView, Timetable, TimetableView, TimetablePresenter>(),
    TimetableView {

    @Inject
    lateinit var mPresenter: TimetablePresenter

    @Arg
    lateinit var route: Route

    override fun onCreate(savedInstanceState: Bundle?) {
        FragmentArgs.inject(this)
        super.onCreate(savedInstanceState)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentView.setHasFixedSize(true)
        contentView.layoutManager = LinearLayoutManager(context)
        loadData(false)
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadTimetable(route, pullToRefresh)
    }

    override fun setData(data: Timetable) {
        contentView.adapter = TimetableAdapter(data)
    }

    override fun getErrorMessage(e: Throwable, pullToRefresh: Boolean): String {
        return e.message ?: getString(R.string.error_undefined)
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}
