package com.ljc93.nettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;



public class MainActivity extends AppCompatActivity {
  @BindView(R.id.bt_get)
  Button bt_get;
  @BindView(R.id.bt_post)
  Button bt_post;
  @BindView(R.id.tv_show)
  TextView tv_show;
  @BindView(R.id.wv_show)
  WebView wv_show;
  @BindView(R.id.iv_show)
  ImageView iv_show;

  private OkHttpClient mOkHttpClient;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

  }

  private void getSyncRequest() {

  }

}