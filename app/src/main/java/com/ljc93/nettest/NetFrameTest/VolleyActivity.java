package com.ljc93.nettest.NetFrameTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ljc93.nettest.R;

public class VolleyActivity extends AppCompatActivity {
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
    setContentView(R.layout.activity_draw_layout);
    ButterKnife.bind(this);
    RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
    StringRequest stringRequest = new StringRequest("http://www.baidu.com",
        new Response.Listener<String>() {
          @Override
          public void onResponse(final String response) {
            Log.i("TAG", response);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                tv_show.setMovementMethod(ScrollingMovementMethod.getInstance());
                tv_show.setText(response);
              }
            });
          }
        }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Log.e("TAG", error.getMessage(), error);
      }
    });
    mQueue.add(stringRequest);
    // tv_show.setText(123+"");

    // getSyncRequest();

  }

  //@OnClick(R.id.bt_get)
  void getSyncRequest() {

    StringRequest stringRequest = new StringRequest("http://www.baidu.com",
        new Response.Listener<String>() {
          @Override
          public void onResponse(final String response) {
            Log.i("TAG", response);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                tv_show.setMovementMethod(ScrollingMovementMethod.getInstance());
                tv_show.setText(response);
              }
            });
          }
        }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Log.e("TAG", error.getMessage(), error);
      }
    });
  }
}