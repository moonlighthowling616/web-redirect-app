package com.putinglobostudios.lcstudentportal;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings; // Import WebSettings

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    WebView myWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize WebView here, outside the listener
        myWeb = findViewById(R.id.myWeb);
        WebSettings webSettings = myWeb.getSettings();
        webSettings.setJavaScriptEnabled(true); // Ensure you understand the security implications
        myWeb.setWebViewClient(new WebViewClient());
        myWeb.loadUrl("https://student.lccdo.edu.ph/users/student/index.php");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            // This is crucial: return the insets.
            // This tells the system that these insets have been consumed by this view's padding.
            return insets;
        });
    }

    // It's good practice to handle the back button for WebView navigation
    @Override
    public void onBackPressed() {
        if (myWeb.canGoBack()) {
            myWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}