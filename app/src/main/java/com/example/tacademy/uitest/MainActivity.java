package com.example.tacademy.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout view1, view3;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1DP = 1px인 케이스는 160일대 이다.
        // 480이면 => 1dp가 3px이 된다. => 480/160 * y(PX) = 3*y(PX)
        // 가변으로 높이를 동적 계산시 사용된다.
        Log.i("DP", ""+this.getResources().getDisplayMetrics().density);
        Log.i("DP", ""+this.getResources().getDisplayMetrics().densityDpi);

        // xml에 정의된 view를 자바코드로 연결하는 부분
        view1 = (FrameLayout) findViewById(R.id.view1);
        view3 = (FrameLayout) findViewById(R.id.view3);
        //view 배경 처리 및 투명 처리
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // view1.setVisibility(View.VISIBLE);  // 보여라
                //view3.setVisibility(View.GONE);    // 안보여라(자리 차지하지 않고)
                view1.setBackgroundColor(0xFFFF0000);
                view3.setBackgroundColor(0x00FF00FF);
            }
        });
        button2.setOnClickListener(this);
        button3.setOnClickListener(MyClick);
    }

    View.OnClickListener MyClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            view3.setVisibility(View.VISIBLE);
           // view1.setVisibility(View.GONE);
            view1.setBackgroundColor(0x00FF0000);
            view3.setBackgroundColor(0xFFFF00FF);
        }
    };

    @Override
    public void onClick(View v) {

    }
}
