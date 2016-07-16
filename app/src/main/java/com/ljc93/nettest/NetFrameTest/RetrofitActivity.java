package com.ljc93.nettest.NetFrameTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ljc93.nettest.Bean.User;
import com.ljc93.nettest.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
  @BindView(R.id.bt_get)
  Button bt_get;
  @BindView(R.id.bt_post)
  Button bt_post;
  @BindView(R.id.pb_show)
  ProgressBar pb_show;

  @BindView(R.id.tv_show)
  TextView tv_show;
  @BindView(R.id.wv_show)
  WebView wv_show;
  @BindView(R.id.iv_show)
  ImageView iv_show;
  public static final String BASE_URL= "https://api.github.com";  // BASE URL

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_draw_layout);
    ButterKnife.bind(this);




  }

  @OnClick(R.id.bt_get)
  void getSyncRequest() {
    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .create();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    MyApiEndpointInterface apiService =
        retrofit.create(MyApiEndpointInterface.class);
    String username = "sarahjean";
    Call<User> call = apiService.getUser(username);
    call.enqueue(new Callback<User>() {
      @Override
      public void onResponse(Call<User> call, Response<User> response) {
        int statusCode = response.code();
        User user = response.body();
        Log.i("TAG",statusCode+"  "+user.getName());
      }

      @Override
      public void onFailure(Call<User> call, Throwable t) {

      }

    });
    }





  }


