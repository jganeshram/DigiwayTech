package com.digiwaytech.httpwww.digiwaytech;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private WebView webviewmy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getSupportActionBar().hide();
        webviewmy = (WebView) findViewById(R.id.webview1);
        webviewmy.setWebViewClient(new WebViewClient());
        webviewmy.loadUrl("http://www.digiwaytech.com");
        WebSettings webSettings = webviewmy.getSettings();
        webSettings.setJavaScriptEnabled(true);
       // webView.getSettings().setPluginsEnabled(true);
        webviewmy.getSettings().setMediaPlaybackRequiresUserGesture(true);
        webviewmy.getSettings().supportZoom();

    }
    @Override
    public void onBackPressed() {
        if(webviewmy.canGoBack() == true){
            webviewmy.goBack();
        } else {
            //finish()
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }
    }
}
