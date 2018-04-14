package top.test.fnine59.test;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    EditText editText;
    ImageButton searchBtn;
    String searchStr;
    String proClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] arr = getResources().getStringArray(R.array.catArr);
        //将列表中的产品种类去重放入List，并绑定到Spinner中
        final List classList = new ArrayList();
        for(int i=0; i<arr.length; i++){
            if(!classList.contains(arr[i])){
                classList.add(arr[i]);
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_layout,classList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //取到EditText组件
                editText = (EditText) findViewById(R.id.searchText);
                if (!(editText.getText().toString()).equals("") && editText!=null){//如果切换spinner选项时有关键字则匹配显示
                    //处理spinner的选择事件，点击它应该筛选出对应类别的产品
                    //设置ListView
                    proClass = classList.get(position).toString();
                    listView = (ListView) findViewById(R.id.listview);
                    //首先处理ListView需要用到的数据
                    ArrayList proList = new ArrayList();
                    String[] products = getResources().getStringArray(R.array.prodArr);
                    String[] proClasses = getResources().getStringArray(R.array.catArr);
                    TypedArray proImg = getResources().obtainTypedArray(R.array.prodImg);
                    for(int i=0; i<products.length; i++){
                        if(classList.get(position).equals(proClasses[i]) && products[i].indexOf(editText.getText().toString()) != -1){
                            HashMap hm = new HashMap();
                            hm.put("name", products[i]);
                            hm.put("class", proClasses[i]);
                            hm.put("img", proImg.getResourceId(i, 0));//这里获取图片资源获取的不对
                            proList.add(hm);
                        }
                    }
                    //实例化简单适配器
                    SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, proList, R.layout.listview_layout, new String[]{"name", "class", "img"}, new int[]{R.id.tv_proname, R.id.tv_proclass, R.id.iv_proimg});
                    listView.setAdapter(simpleAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //处理ListView点击事件，题目要求中没有提到
                        }
                    });
                }else{//如果切换spinner选项时没有关键字则无需匹配
                    //处理spinner的选择事件，点击它应该筛选出对应类别的产品
                    //设置ListView
                    proClass = classList.get(position).toString();
                    listView = (ListView) findViewById(R.id.listview);
                    //首先处理ListView需要用到的数据
                    ArrayList proList = new ArrayList();
                    String[] products = getResources().getStringArray(R.array.prodArr);
                    String[] proClasses = getResources().getStringArray(R.array.catArr);
                    TypedArray proImg = getResources().obtainTypedArray(R.array.prodImg);
                    for(int i=0; i<products.length; i++){
                        if(classList.get(position).equals(proClasses[i])){
                            HashMap hm = new HashMap();
                            hm.put("name", products[i]);
                            hm.put("class", proClasses[i]);
                            hm.put("img", proImg.getResourceId(i, 0));//这里获取图片资源获取的不对
                            proList.add(hm);
                        }
                    }
                    //实例化简单适配器
                    SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, proList, R.layout.listview_layout, new String[]{"name", "class", "img"}, new int[]{R.id.tv_proname, R.id.tv_proclass, R.id.iv_proimg});
                    listView.setAdapter(simpleAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //处理ListView点击事件，题目要求中没有提到
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //获取查找按钮
        searchBtn = (ImageButton) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView = (ListView) findViewById(R.id.listview);
                editText = (EditText) findViewById(R.id.searchText);
                searchStr = editText.getText().toString();
                ArrayList proList = new ArrayList();
                String[] products = getResources().getStringArray(R.array.prodArr);
                String[] proClasses = getResources().getStringArray(R.array.catArr);
                TypedArray proImg = getResources().obtainTypedArray(R.array.prodImg);
                for(int i=0; i<products.length; i++){
                    if(products[i].indexOf(searchStr) != -1 && proClasses[i].equals(proClass)){
                        HashMap hm = new HashMap();
                        hm.put("name", products[i]);
                        hm.put("class", proClasses[i]);
                        hm.put("img", proImg.getResourceId(i, 0));//这里获取图片资源获取的不对
                        proList.add(hm);
                    }
                }
                //实例化简单适配器
                SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, proList, R.layout.listview_layout, new String[]{"name", "class", "img"}, new int[]{R.id.tv_proname, R.id.tv_proclass, R.id.iv_proimg});
                listView.setAdapter(simpleAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //处理ListView点击事件，题目要求中没有提到
                    }
                });
            }
        });

    }
}
