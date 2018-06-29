package com.wys.wanandroid.activity;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseActivity;


/**
 * Created by yas on 2018/6/29.
 */

public class WebViewActivity extends BaseActivity {
    private ImageView imgBack;
    private TextView tvTitle;
    private WebView webView;

    private String url;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initExtras() {
        url=getIntent().getStringExtra("Link");
    }

    @Override
    protected void initLayout() {

        webView= (WebView) this.findViewById(R.id.webView);
        tvTitle= (TextView) this.findViewById(R.id.tv_title);
        imgBack= (ImageView) this.findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果当前页面可以回退则进行回退操作，否则关闭本页面
                if (webView!=null&&webView.canGoBack()){
                    webView.goBack();
                }else{
                    finish();
                }
            }
        });

        webView.setWebViewClient(webViewClient);
        webView.setWebChromeClient(chromeClient);
//		mWebView.setIWebViewListener(iWebViewListener);
        //设置可缩放
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        //打开js开关
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //cache信息
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);

        webView.getSettings().setDefaultTextEncodingName("UTF -8");
        //
        WebSettings webSetting = webView.getSettings();
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.loadUrl(url);

    }
    private WebViewClient webViewClient = new WebViewClient() {
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
        }

        public void onPageFinished(WebView view, String url) {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//			super.onReceivedSslError(view, handler, error);
            //handler.cancel(); // Android superde 默认的处理方式
            handler.proceed();  // 接受所有网站的证书
        }
    };


    private WebChromeClient chromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            tvTitle.setText(title);
        }
    };
}
