package com.example.cardviewdemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardviewdemo.R;
import com.example.cardviewdemo.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class PDFActivity extends BaseActivity implements DownloadFile.Listener {
    LinearLayout root;
    RemotePDFViewPager remotePDFViewPager;
    PDFPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        root = (LinearLayout) findViewById(R.id.remote_pdf_root);
        setDownloadButtonListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (adapter != null) {
            adapter.close();
        }
    }

    protected void setDownloadButtonListener() {
        final Context ctx = this;
        final DownloadFile.Listener listener = this;
        remotePDFViewPager = new RemotePDFViewPager(ctx, getUrlFromEditText(), listener);
        remotePDFViewPager.setId(R.id.pdfViewPager);
    }

    protected String getUrlFromEditText() {
        return "https://arxiv.org/pdf/1910.14060.pdf";
    }

    public static void open(Context context) {
        Intent i = new Intent(context, PDFActivity.class);
        context.startActivity(i);
    }


    public void updateLayout() {
        root.removeAllViewsInLayout();
        root.addView(remotePDFViewPager,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);
        updateLayout();
    }

    @Override
    public void onFailure(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pdf;
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}

