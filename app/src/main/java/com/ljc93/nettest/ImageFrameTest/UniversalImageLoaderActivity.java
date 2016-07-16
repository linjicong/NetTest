package com.ljc93.nettest.ImageFrameTest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ljc93.nettest.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import okhttp3.OkHttpClient;

public class UniversalImageLoaderActivity extends AppCompatActivity {
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

    //创建默认的ImageLoader配置参数
    ImageLoaderConfiguration configuration = ImageLoaderConfiguration
        .createDefault(this);

    //Initialize ImageLoader with configuration.
    ImageLoader.getInstance().init(configuration);


    String imageUrl = "http://www.wallcoo.com/animal/MX069_Pretty_Puppies_puppy_garden_adventure/wallpapers/1920x1080/Garden_adventure_of_the_little_puppy_photos_pictures_puppy_MIL56021.jpg";

    ImageLoader.getInstance().loadImage(imageUrl, new ImageLoadingListener() {

      @Override
      public void onLoadingStarted(String imageUri, View view) {

      }

      @Override
      public void onLoadingFailed(String imageUri, View view,
          FailReason failReason) {

      }

      @Override
      public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        Log.i("onLoadingComplete",loadedImage.toString());
        iv_show.setImageBitmap(loadedImage);
      }

      @Override
      public void onLoadingCancelled(String imageUri, View view) {

      }
    });
  }


}