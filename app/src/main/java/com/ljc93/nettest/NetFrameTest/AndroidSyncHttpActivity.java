package com.ljc93.nettest.NetFrameTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ljc93.nettest.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

public class AndroidSyncHttpActivity extends AppCompatActivity {
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
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    //getSyncRequest();

  }

  @OnClick(R.id.bt_get) void getSyncRequest() {
    Toast.makeText(this, "Button Click!", Toast.LENGTH_SHORT).show();
    AsyncHttpClient client = new AsyncHttpClient();
    client.get("http://www.baidu.com", new AsyncHttpResponseHandler() {
      @Override
      public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        final String res = new String(responseBody);
        Log.i("LJC", "" + new String(responseBody));
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            tv_show.setMovementMethod(ScrollingMovementMethod.getInstance());
            tv_show.setText(res);
          }
        });
      }

      @Override
      public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
          Throwable error) {

      }
    });
  }
}