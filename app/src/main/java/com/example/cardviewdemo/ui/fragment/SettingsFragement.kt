
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment


class SettingsFragement : BaseFragment() {
    fun newInstance(): SettingsFragement {
        return SettingsFragement()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_settings, null)
        return view;
    }


}
