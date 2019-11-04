
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment


class CreditFragement : BaseFragment() {
    fun newInstance(): CreditFragement {
        return CreditFragement()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_credit, null)
        return view;
    }


}
