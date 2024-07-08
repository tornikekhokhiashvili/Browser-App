package com.example.browserapp

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var edittext: EditText
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        init()
        loadWeb()
        webView.webViewClient=object :WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                toolbar.title=view?.title
            }
        }
    }
    private fun init(){
        button=findViewById(R.id.button)
        edittext=findViewById(R.id.editText)
        webView=findViewById(R.id.webview)
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWeb(){
        webView.webViewClient=WebViewClient()
        webView.settings.javaScriptEnabled = true
        button.setOnClickListener {
            val url=edittext.text.toString()
            if (url.isNotEmpty()){
                webView.loadUrl(url)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        val orientation = resources.configuration.orientation
        if(orientation==Configuration.ORIENTATION_PORTRAIT){
            inflater.inflate(R.menu.menu_portrait,menu)
        }else if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            inflater.inflate(R.menu.menu_landscape,menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_green -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.green))
                true
            }

            R.id.menu_blue -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.blue))
                true
            }

            R.id.menu_violet -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.violet))
                true
            }
            R.id.menu_brown -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.brown))
                true
            }
            R.id.menu_yellow -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))
                true
            }
            R.id.menu_orange -> {
                button.setBackgroundColor(ContextCompat.getColor(this,R.color.orange))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
