package com.example.cardviewdemo.ui.activity

import androidx.appcompat.widget.Toolbar
import com.example.cardviewdemo.R
import com.example.cardviewdemo.base.BaseActivity
import com.example.cardviewdemo.model.PaperBean
import com.example.cardviewdemo.util.ToolBarManager
import io.github.kbiakov.codeview.classifier.CodeProcessor
import kotlinx.android.synthetic.main.activity_paper_detail.*
import org.jetbrains.anko.find
import org.scilab.forge.jlatexmath.core.AjLatexMath

class PaperDetailActivity : BaseActivity(),ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_paper_detail
    }


    override fun initData() {
        val paperDetailBean = intent.getParcelableExtra<PaperBean>("item")
        initPaperDetailToolbar(paperDetailBean,UID)
        AjLatexMath.init(this)
        CodeProcessor.init(this)
        setData(paperDetailBean)
        //println("itemBean=$paperDetailBean")
    }

    fun setData(data:PaperBean){
        article_title.setText(data.Title.replace("\n",""))
        article_authors.setText(data.Author)
        article_date_submit.setText("Submitted:"+data.UpdateTime)
        article_id.setText("ID:"+data.ArxivID)
        article_type.setText(data.Catorgary)
        article_abstract.setText(data.Abstract.replace("\n",""))
    }

    //Icon change
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.paper_detail,menu);
//        return true;
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item?.itemId) {
//            R.id.favourite -> {
//                return true
//            }
//            R.id.favourited -> {
//                return true
//            }
//            R.id.pdf -> {
//                return true
//            }
//            R.id.renderLatex -> {
//                return true
//            }
//            R.id.setting -> {
//                gotoSettings()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
//        invalidateOptionsMenu();
//        menu.findItem(R.id.favourite).isVisible=false;
//        menu.findItem(R.id.favourited).isVisible=true;
//        return super.onPrepareOptionsMenu(menu);
//    }

}