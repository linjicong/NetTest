package com.ljc93.nettest.ImageFrameTest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.ljc93.nettest.R;

public class FrescoActivity extends AppCompatActivity {
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fresco.initialize(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Uri uri = Uri.parse("http://images.55bbs.com/day_090902/20090902_63eace74688416cb0d08Tp0EHFFZ2zpE.jpg");
   // SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
   // draweeView.setImageURI(uri);
  }


}