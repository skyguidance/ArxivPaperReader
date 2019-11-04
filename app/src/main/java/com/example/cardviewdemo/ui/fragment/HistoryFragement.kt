
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment


class HistoryFragement : BaseFragment() {
    fun newInstance(): HistoryFragement {
        return HistoryFragement()
    }

    override fun initView(): View? {
        var view = View.inflate(context, R.layout.fragment_history, null)
        return view;
    }


}
