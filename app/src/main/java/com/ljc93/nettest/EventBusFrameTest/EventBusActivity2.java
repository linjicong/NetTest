package com.ljc93.nettest.EventBusFrameTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ljc93.nettest.R;
import org.greenrobot.eventbus.EventBus;

public class EventBusActivity2 extends Activity {
  @BindView(R.id.btn_back)
  Button btn_back;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_eventbus_2);
    ButterKnife.bind(this);

  }

  @OnClick(R.id.btn_back)
  void post(){
    EventBus.getDefault().post(new FirstEvent("hello world"));
    Log.i("post","do post");
  }



}