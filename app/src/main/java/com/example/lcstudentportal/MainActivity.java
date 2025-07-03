package com.example.lcstudentportal;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient; // Import WebViewClient
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

        // Initialize and configure WebView
        myWeb = findViewById(R.id.myWeb);
        if (myWeb != null) { // Good practice to check if the view is found
            myWeb.getSettings().setJavaScriptEnabled(true);
            myWeb.setWebViewClient(new WebViewClient());
            myWeb.loadUrl("https://student.lccdo.edu.ph");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // This is now the last statement and returns the correct type.
        });
    }
}