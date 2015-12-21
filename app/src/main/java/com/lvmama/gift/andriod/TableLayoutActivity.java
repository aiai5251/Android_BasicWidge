package com.lvmama.gift.andriod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lvmama.www.lvmamatest.R;

/**
 * Created by shiyaorong on 15/12/16.
 */
public class TableLayoutActivity extends Activity {

    private  String content= "您好";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablelayout);

        /*
        第二个页面什么时候给第一个页面回传数据

        会传第一个页面实际上是一个Intent对象
         */

        Button btn1 = (Button)findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data", content); //通过key 和 value传值，前面是key
                setResult(2, data);

                finish(); //结束当前页面,直接跳转到前一个页面
            }
        });

    }
}
