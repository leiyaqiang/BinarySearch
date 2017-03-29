package com.android4.lenovo.binarysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText ed_shu;
    private TextView tv;
    private Button button;
    private ArrayList<Integer> list;
    private int s2;
    private int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ed_shu= (EditText) findViewById(R.id.ed_shu);
        tv= (TextView) findViewById(R.id.tv);
        button= (Button) findViewById(R.id.button);
        list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=ed_shu.getText().toString();
                int s=Integer.parseInt(str);
                int myint=ff(list,s,0,list.size());
                ff2(list,s,0,list.size());
                tv.setText(myint+"========="+s+"=========="+s2+"============"+sum);
            }


        });
    }

    private void ff2(ArrayList<Integer> list, int s, int i, int size) {
        if (list!=null){
            int min=(size+i)/2;
            sum++;

            if (s==min){
                s2=min;
            }else if (s<min){
                size=min-1;
                ff2(list,s,i,size);
            }else if (s>min){
                i=min+1;
                ff2(list,s,i,size);
            }
        }
    }

    private int ff(ArrayList<Integer> list, int s, int i, int size) {
        if (list!=null){
            while (i<=size){
//                sum++;
                int min=(size+i)/2;
                if (s==min){
                    return min;
                }else if (s<min){
                    size=min-1;
                }else if (s>min){
                    i=min+1;
                }
            }
        }
        return -1;
    }
}
