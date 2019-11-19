
import android.view.View
import com.example.cardviewdemo.base.BaseFragment
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element





class CreditFragement : BaseFragment() {
    fun newInstance(): CreditFragement {
        return CreditFragement()
    }

    override fun initView(): View? {
        var string: String = context?.getResources()!!.getString(
            com.example.cardviewdemo.R.string.credit_text);
        var view = AboutPage(context)
            .isRTL(true)
            .setDescription(string)
            .addItem(Element().setTitle("Version 1.0"))
            .create()
        return view;
    }


}
