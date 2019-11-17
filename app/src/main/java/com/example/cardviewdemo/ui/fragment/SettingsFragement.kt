
import android.view.View
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.view.*


class SettingsFragement : BaseFragment() {
    fun newInstance(): SettingsFragement {
        return SettingsFragement()
    }

    override fun initView(): View? {

        var view = View.inflate(context, R.layout.fragment_settings, null)
        view.btn_change_username.setOnClickListener {

        }
        view.btn_change_password.setOnClickListener {
        }
        view.btn_exit_login.setOnClickListener {
        }
//        view.btn_regesister.setOnClickListener {
//        }

        return view;

    }


}
