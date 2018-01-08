package com.example.a75293.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String[] testName = {"One,One", "One,Two", "One,Three", "One,Four", "Two,One",
            "Two,Two", "Two,Three", "Two,Four", "Three,One", "Three,Two", "Three,Three", "Three,Four",
            "Four,One", "Four,Two", "Four,Three", "Four,Four"};

    private LinearLayout contentView;
    private View.OnClickListener btnOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        contentView = (LinearLayout) findViewById(R.id.contentView);// contentView的布局
        initView();
    }

    private void initView() {
        LinearLayout parentLL = (LinearLayout) contentView;
        int size = testName.length;// 添加Button的个数
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);// 每行的水平LinearLayout

        layoutParams.setMargins(10, 3, 10, 3);

        ArrayList<Button> childBtns = new ArrayList<Button>();
        int totoaiBtns = 0;

        for (int i = 0; i < size; i++) {
            String item = testName[i];
            LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            
            itemParams.weight = 1;
            totoaiBtns++;

            itemParams.width = 0;
            itemParams.setMargins(5, 5, 5, 5);

            Button childBtn = (Button) LayoutInflater.from(this).inflate(R.layout.button, null);
            childBtn.setText(item);
            childBtn.setTag(item);
            childBtn.setLayoutParams(itemParams);
            childBtns.add(childBtn);

            if(totoaiBtns>=4){
                LinearLayout horizLL=new LinearLayout(this);
                horizLL.setOrientation(LinearLayout.HORIZONTAL);
                horizLL.setLayoutParams(layoutParams);

                for(Button addBtn:childBtns){
                    horizLL.addView(addBtn);
                }
                parentLL.addView(horizLL);
                childBtns.clear();
                totoaiBtns=0;
            }
        }
        //最后一行添加一下
        if(!childBtns.isEmpty()){
            LinearLayout horizLL=new LinearLayout(this);
            horizLL.setOrientation(LinearLayout.HORIZONTAL);
            horizLL.setLayoutParams(layoutParams);

            for(Button addBtn:childBtns){
                horizLL.addView(addBtn);
            }
            parentLL.addView(horizLL);
            childBtns.clear();
            totoaiBtns=0;
        }
    }
}
