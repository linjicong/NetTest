package com.ljc93.nettest.EventBusFrameTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ljc93.nettest.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity1 extends Activity {
  @BindView(R.id.btn_getView)
  Button btn_getView;
  @BindView(R.id.tv_notify)
  TextView tv_notify;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_eventbus_1);
    EventBus.getDefault().register(this);
    ButterKnife.bind(this);


  }

  @OnClick(R.id.btn_getView)
  void transfer() {
    Intent intent = new Intent(this, EventBusActivity2.class);
    startActivity(intent);
  }



  @Subscribe
  public void onEvenMainThread(FirstEvent event) {
    String msg = "onEvent收到了消息：" + event.getMsg();
    Log.i("getMsg", msg);
    tv_notify.setText(msg);
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i("doDestory","dodestory");
    EventBus.getDefault().unregister(this);
  }

}