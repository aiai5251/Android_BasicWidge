package com.lvmama.www.lvmamatest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.lvmama.gift.andriod.CheckBoxDemo;
import com.lvmama.gift.andriod.FrameLayoutActivity;
import com.lvmama.gift.andriod.TicketViewActivity;

public class WelcomeActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    private Button myFirstButton = null;
    private ImageButton loginImageButton;
    private TextView myLabel = null;

    private ToggleButton toggleButton;
    private ImageView addTravelImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        myFirstButton = (Button)findViewById(R.id.firstButton);
        myLabel = (TextView)findViewById(R.id.firstlabel);
        loginImageButton = (ImageButton)findViewById(R.id.firstimageButton);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton1);
        addTravelImg = (ImageView)findViewById(R.id.imageView2);

        /*
        toggleButton设置监听器// implements CompoundButton.OnCheckedChangeListener
         */
        toggleButton.setOnCheckedChangeListener(this);



        /*
         * 1.监听事件：
         * （1）匿名内部类
         */
//        myFirstButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.print("我的button被点击了");
//            }
//        });

        /*
         * 1.监听事件：
         * （2）外部类
         */
//        myFirstButton.setOnClickListener(new  MyOnClickListener(){
//            @Override
//            public void onClick(View v) {
//                super.onClick(v);
//
//                Toast.makeText(WelcomeActivity.this, "bt1要执行的逻辑", 1).show();
//            }
//
//        });

        /*
         * 2.通过实现一个接口的方式实现监听事件
         */
//        loginImageButton.setOnClickListener(this);

        Button btn7 = (Button)findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, FrameLayoutActivity.class);
                WelcomeActivity.this.startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //方法2：第二步
    public void buttonClicked(View v) {
        myFirstButton.setText("hello");
        myLabel.setText("景点门票");

//        <!-- 跳转需要申明 activity-->
//        <activity android:name="com.lvmama.gift.andriod.TicketViewActivity"></activity>

//        Intent intent = new Intent();
//        intent.setClass(WelcomeActivity.this, TicketViewActivity.class);
//        startActivity(intent);

        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, CheckBoxDemo.class);
        startActivity(intent);

    }

    public  void imageButtonClicked(View v) {

        Log.i("TAG", "imageButton点击打电话");

        // 使用这个要在AndroidManifest.xml中，加上 <uses-permission android:name="android.permission.CALL_PHONE" />
        //ACTION_DIAL: 调出拨打电话程序， ACTION_CALL：直接拨打出去，模拟器会crash
        Uri uri = Uri.parse("tel:08000000123");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }

    /*
     * 2. 有implements View.OnClickListener，则需要写
     */
//    @Override
//    public void onClick(View v) {
//        Log.i("TAG", "接口方式实现的监听");
//    }


    /*
        toggleButton方法
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*
        当tb被点击的时候，当前方法会执行，
        buttonView －－ 代表被点击控件的本身
        ischecked  －－ 代表被点击的控件的状态
         */

        addTravelImg.setBackgroundResource(isChecked ? R.mipmap.addtravelpersonbutton : R.mipmap.addtravelpersonicon);

    }

}


/*
 * 1.监听事件：
 * （2）外部类
 * OnClickListener 是一个接口，不能通过继承实现
 */
//class  MyOnClickListener implements View.OnClickListener {
//    @Override
//    public void onClick(View v) {
//        //让所有使用当前外部类的点击事件的按钮都要做出一个动作
//        Log.i("tag", "父类的onclick事件");
//
//        v.setAlpha(0.5f);
//    }
//}
