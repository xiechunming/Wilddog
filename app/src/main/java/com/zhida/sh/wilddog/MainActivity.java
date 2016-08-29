package com.zhida.sh.wilddog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wilddog.client.DataSnapshot;
import com.wilddog.client.ValueEventListener;
import com.wilddog.client.Wilddog;
import com.wilddog.client.WilddogError;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * @author xcm
     * created at 2016/8/29 11:28
     * 邮箱991947352@qq.com
     * 在create里面初始化，在application里做比较合理，这里不讲究
     * 后面的url就是你的数据地址
     * key自定义.
     */
    private Wilddog ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wilddog.setAndroidContext(this);
        ref = new Wilddog("https://xcmtest.wilddogio.com/key");
    }
    /**
     *
     * @author xcm
     * created at 2016/8/29 11:34
     * 邮箱991947352@qq.com
     * 需要read权限，在野狗应用管理设置
     * 获取并监听key的值，第一次调用触发onDataChange(),后面后端数据每变化一次onDataChange（）执行一次
     *
     */
    public void readclick(View view){
        ref.addValueEventListener(new ValueEventListener(){
            public void onDataChange(DataSnapshot snapshot){
                System.out.println(snapshot.getValue()); //打印key这个字段的值,没有就null
                Log.i("valus",snapshot.getValue()+"");
            }

            public void onCancelled(WilddogError error){
                if(error != null){
                    System.out.println(error.getCode());
                }
            }

        });
    }


    /**
     *
     * @author xcm
     * created at 2016/8/29 11:37
     * 邮箱991947352@qq.com
     * 需要write权限，在野狗应用管理设置
     * 为key字段赋值
     */
    public  void writeclick(View view){
        ref.setValue("hello world!!!");
    }
}
