package com.ljc93.nettest.Dao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {


  private OkHttpClient mOkHttpClient;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.ljc93.nettest.R.layout.activity_main);
    ButterKnife.bind(this);

  }

  private void getSyncRequest() {

  }

}