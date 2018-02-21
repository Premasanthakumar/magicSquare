package com.example.prema.magicsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText in,in2,result;
    Button cal;
    String n;
    int m;
    //int[] a=new int[10];
    List<Integer> a=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in=(EditText)findViewById(R.id.input);
        in.setHint("Order of Matrix");
        in2=(EditText)findViewById(R.id.input2);
        in2.setHint("Set of Inputs");
        cal=(Button)findViewById(R.id.but_cal);
        result=(EditText)findViewById(R.id.out);
        result.setHint("Result");
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.removeAll(a);
                n=in.getText().toString();
                m=Integer.valueOf(n);
                String input=in2.getText().toString();
                String[] array=input.split(",");
                int mid;
                if(m%2==0) {
                    mid = (0 + array.length) / 2;
                    mid=(mid+(mid+1))/2;
                }
                else
                    mid = (0 + array.length) / 2;
                for(int i=0;i<array.length;i++){
                    a.add(Integer.valueOf(array[i]));

                }
                int i=0,j=array.length-1,c=0;
                int[] count=new int[a.size()];
                while((i!=mid)&&(j!=mid)){
                    count[c++]=a.get(i)+a.get(mid)+a.get(j);
                    i++;
                    j--;
                }
                int flag = 0;
                int first = count[0];
                for(int p = 1; p < c; p++)
                {
                    if (count[p] != first){
                        flag = 1;
                        break;
                    }
                }
                if(flag==1){
                    result.setText("Not a Magic Square");
                }
                else if(flag==0){
                    result.setText("Magic Square");
                }
            }
        });
    }
}
