package helloworld.example.administrator.wwduitangdemo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/8.
 */
public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcom);
        final TextView tvNum = (TextView) findViewById(R.id.tv_num);
        Typeface fontFace = Typeface.createFromAsset(getAssets(),"splash.ttf");
        tvNum.setTypeface(fontFace);
        //第一个参数是倒计时的总时间，第二个参数是倒计时的时间间隔，每个间隔中都会调用下面的两个方法
        CountDownTimer countDownTimer = new CountDownTimer(4200,1000) {
            int num = 3;
            @Override
            public void onTick(long millisUntilFinished) {
                tvNum.setText(String.valueOf(num));
                --num;
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }.start();
    }
}
