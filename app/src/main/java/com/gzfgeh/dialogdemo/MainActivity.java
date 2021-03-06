package com.gzfgeh.dialogdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gzfgeh.iosdialog.IOSDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IOSDialog(MainActivity.this).builder()
                        .setCancelable(true)
                        .setTitle("相册", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMsg("相机", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "相机", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        Button content = (Button) findViewById(R.id.content);
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new IOSDialog(MainActivity.this).builder()
                        .setContentView(R.layout.pay_dialog, null)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        Button title = (Button) findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IOSDialog(MainActivity.this).builder()
                        .setTitle("选择", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMsg("消息")
                        .setMsgColor(R.color.colorPrimary)
                        .setMsgBackground(R.color.colorAccent)
                        .setTitleColor(R.color.colorAccent)
                        .setTitleBackground(R.color.colorPrimary)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        Button loading = (Button) findViewById(R.id.loading);
        loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOSDialog(MainActivity.this).builder()
                        .setLoadingView()
                .show();
            }
        });

        Button loadingColor = (Button) findViewById(R.id.loading_color);
        loadingColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOSDialog(MainActivity.this).builder()
                        .setLoadingView(R.color.colorAccent)
                .show();
            }
        });


        final SpannableStringBuilder builder = new SpannableStringBuilder("选择角色后不可跟换，确定选择 暖通公司 吗？");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        builder.setSpan(span, 15, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        Button btn = (Button) findViewById(R.id.no_title);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOSDialog(MainActivity.this, 0.9f).builder()
                        .setMsg(builder)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        Button nothingBtn = (Button) findViewById(R.id.nothing);
        nothingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOSDialog(MainActivity.this).builder()
                        .setContentView(R.layout.pay_dialog, null)
                        .show();
            }
        });
    }
}
