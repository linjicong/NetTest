package com.ljc93.nettest.ImageFrameTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ljc93.nettest.R;
import com.squareup.picasso.Picasso;
import okhttp3.OkHttpClient;

public class PicassoActivity extends AppCompatActivity {
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
    Picasso.with(this).load("http://pic29.nipic.com/20130506/3822951_102005116000_2.jpg").into(iv_show);

  }


}