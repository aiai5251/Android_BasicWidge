package com.lvmama.gift.andriod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lvmama.www.lvmamatest.R;

/**
 * Created by shiyaorong on 15/12/15.
 */
public class CheckBoxDemo extends Activity {

    private CheckBox checkBox;
    private RadioGroup rg;
    private TextView returnTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        returnTextView = (TextView)findViewById(R.id.returnTextView);

        checkBox = (CheckBox)findViewById(R.id.checkBox1);

        // 通过设置CheckBox的监听事件，来对checkBox处理
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String text = checkBox.getText().toString();
                    checkBox.setText("篮球");
                    Log.i("tag", text);
                } else  {
                    checkBox.setText("羽毛球");
                    Log.i("tag", "没有选中");
                }
            }
        });


        rg = (RadioGroup)findViewById(R.id.radioGroup1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        Log.i("tag", "man");
                        break;
                    case R.id.radioButton2:
                        Log.i("tag", "women");
                        break;
                    default:
                        break;
                }
            }
        });

        Button returnButton1 = (Button)findViewById(R.id.returnButton1);
        returnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式一： 传值   从CheckBoxDemo 跳转到 TableLayoutActivity
                /*
                startActivity

                Intent: 第一个参数，上下文对象this；  第二个参数：目标文件
                 */
                Intent intent = new Intent(CheckBoxDemo.this, TableLayoutActivity.class);
                startActivity(intent);

            }
        });


        /*
        通过starActivityForresult
        第一个参数是Intent对象
        第二个参数是请求的一个标识
         */
        Button returnButton2 = (Button)findViewById(R.id.returnButton2);
        returnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式二： 传值   从CheckBoxDemo 跳转到 TableLayoutActivity
                Intent intent = new Intent(CheckBoxDemo.this, TableLayoutActivity.class);
                startActivityForResult(intent, 1);

            }
        });



        Button returnButton3 = (Button)findViewById(R.id.returnButton3);
        returnButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式三： 传值   从CheckBoxDemo 跳转到 TableLayoutActivity


            }
        });

    }

    /*
    通过通过starActivityForresult跳转，接收返回数据的方法
    requestCode: 请求的标识
    resultCode : 第二个页面返回的标识
    data       : 第二个页面回传的数据
    */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 2) {
            String content = data.getStringExtra("data");

            Log.i("tag", content);

            returnTextView.setText(content);
        }

    }


}
