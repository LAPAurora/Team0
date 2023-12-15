package com.example.bankapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        imageView.setVisibility(View.VISIBLE);

        // 显示图片 1 秒钟
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.GONE);

                // 在此处执行您的应用程序逻辑
            }
        }, 1000); // 延迟 1000 毫秒，即 1 秒钟
    }
}
