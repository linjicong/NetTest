package com.ljc93.nettest.NetFrameTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ljc93.nettest.R;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {
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

    tv_show.setText("hello");
    // bt_get = (Button) findViewById(R.id.bt_get);
    // bt_post = (Button) findViewById(R.id.bt_post);
    // tv_show = (TextView) findViewById(R.id.tv_show);
    //iv_show= (ImageView) findViewById(R.id.iv_show);
    //wv_show= (WebView) findViewById(R.id.wv_show);

    // tv_show.setText(123+"");

    // getSyncRequest();

  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.bt_get:

        getSyncRequest();
    }
  }

  private void getSyncRequest() {
    //创建okHttpClient对象
    OkHttpClient mOkHttpClient = new OkHttpClient();
    //创建一个Request
    final Request request = new Request.Builder()
        .url("https://www.taobao.com/")
        .build();
    //new call
    Call call = mOkHttpClient.newCall(request);
    //请求加入调度
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        final String res = response.body().string();
        Log.i("LJC", res);
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            tv_show.setMovementMethod(ScrollingMovementMethod.getInstance());
            tv_show.setText(res);
          }
        });
      }
    });
  }
}