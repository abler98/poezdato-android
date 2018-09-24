package net.poezdato.android.mvp.timetable

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.repository.TimetableRepository
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class TimetablePresenterImpl @Inject constructor(private val repository: TimetableRepository) :
    MvpBasePresenter<TimetableView>(), TimetablePresenter {

    private val disposable = CompositeDisposable()

    override fun detachView() {
        super.detachView()
        disposable.clear()
    }

    override fun loadTimetable(route: Route) {
        disposable.add(
            repository.findByRoute(route)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    ifViewAttached { it.showToast(result.toString()) }
                }, { error ->
                    ifViewAttached { it.showToast(error.javaClass.name) }
                })
        )
    }

}
