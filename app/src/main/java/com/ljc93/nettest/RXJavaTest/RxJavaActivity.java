package com.ljc93.nettest.RXJavaTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ljc93.nettest.R;
import com.socks.library.KLog;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

public class RxJavaActivity extends AppCompatActivity {
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
    setContentView(R.layout.activity_draw_layout);
    ButterKnife.bind(this);
    // 创建observable
    Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> subscriber) {
        subscriber.onNext("Hello RxJava");
        subscriber.onCompleted();
      }
    });

    // 创建subscriber
    Subscriber<String> subscriber = new Subscriber<String>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {

      }
      @Override
      public void onNext(String s) {
        KLog.d(s);
      }
    };

    // 订阅
    observable.subscribe(subscriber);
  }

  private void getSyncRequest() {

  }

}