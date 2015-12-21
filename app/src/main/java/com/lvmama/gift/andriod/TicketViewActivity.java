package com.lvmama.gift.andriod;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.lvmama.www.lvmamatest.R;

/**
 * Created by shiyaorong on 15/12/14.
 */
public class TicketViewActivity extends Activity {

    private AutoCompleteTextView autoTextView;
    private String[] res = {"beijing1", "beijing2", "beijing3", "beijing4", "shanghai1", "shanghai2"};

    private MultiAutoCompleteTextView macTextView;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_ticketview);

        /*
        AutoCompleteTextView :
        第一步：初始化
        第二步：需要一个适配器
        第三步：初始化数据源－－－这数据源去匹配文本框输入的内容
        第四步：将adpter与当前AutoCompleteTextView绑定
         */
        autoTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, res);
        autoTextView.setAdapter(adapter);

        /*
        MultiAutoCompleteTextView : 支持多选
        第一步：初始化
        第二步：需要一个适配器
        第三步：初始化数据源－－－这数据源去匹配文本框输入的内容
        第四步：将adpter与当前AutoCompleteTextView绑定
        第五步：设置分隔符
         */
        macTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
        //设置逗号为结束符
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        macTextView.setAdapter(adapter);
    }

}



