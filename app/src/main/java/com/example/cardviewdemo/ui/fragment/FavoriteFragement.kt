
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment


class FavoriteFragement : BaseFragment() {
    fun newInstance(): FavoriteFragement {
        return FavoriteFragement()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_favorite, null)
        return view;
    }

}
