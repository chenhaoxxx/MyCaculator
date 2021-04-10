package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mycaculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;//store
    private  MyViewModel myViewModel;//data model
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);//get
        myViewModel  = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);

//listener
        //事件监听
        myViewModel.getMainNum().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {//数值发生了改变
                binding.myTextView.setText(myViewModel.getMainNum().getValue());//让 myTextView 显示新的数值

                //让 textView 显示式子
                if(myViewModel.sign2.equals("")) {
                    if (myViewModel.sign1.equals("")) {
                        binding.textView.setText(myViewModel.getMainNum().getValue());
                    } else {//如果是像 a+b 这种形式的式子
                        binding.textView.setText(myViewModel.num[0] + myViewModel.sign1 + myViewModel.getMainNum().getValue());
                    }
                }else{//如果是像 a+b*c 这种形式的式子
                    binding.textView.setText(myViewModel.num[0] + myViewModel.sign1 + myViewModel.num[1] + myViewModel.sign2 + myViewModel.getMainNum().getValue());
                }
            }
        });
        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("0");
            }
        });
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("1");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("2");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("3");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("4");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("5");
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("6");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("7");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("8");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("9");
            }
        });
        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setMainNum("0");
            }
        });
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myViewModel.havepoint){
                    myViewModel.getMainNum().setValue(myViewModel.getMainNum().getValue() + ".");
                    myViewModel.havepoint = true;
                }
            }
        });
        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.sign1.equals("")){
                        myViewModel.sign1="+";
                        myViewModel.num[0]= myViewModel.getMainNum().getValue();
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint= false;
                }else if (myViewModel.sign2.equals("")){
                        myViewModel.num[0] = myViewModel.mainNumwithNum_0Tocal();
                        myViewModel.sign1="+";
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint= false;
                }else {
                        myViewModel.getMainNum().setValue(myViewModel.mainNumWithNum_1_TOCal());
                        myViewModel.sign2="";
                        myViewModel.num[1]="";
                        myViewModel.num[0]=myViewModel.mainNumwithNum_0Tocal();
                        myViewModel.sign1="+";
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint=false;
                }
            }
        });
        binding.buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myViewModel.sign1.equals("")){
                    myViewModel.sign1="-";
                    myViewModel.num[0]= myViewModel.getMainNum().getValue();
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint= false;
                }else if (myViewModel.sign2.equals("")){
                    myViewModel.num[0] = myViewModel.mainNumwithNum_0Tocal();
                    myViewModel.sign1="-";
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint= false;
                }else {
                    myViewModel.getMainNum().setValue(myViewModel.mainNumWithNum_1_TOCal());
                    myViewModel.sign2="";
                    myViewModel.num[1]="";
                    myViewModel.num[0]=myViewModel.mainNumwithNum_0Tocal();
                    myViewModel.sign1="-";
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint=false;
                }
            }
        });
        binding.buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewModel.sign1.equals("")){
                    myViewModel.sign1="*";
                    myViewModel.num[0] = myViewModel.getMainNum().getValue();
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint=false;
                }else if (myViewModel.sign2.equals("")){
                    if (myViewModel.sign1.equals("")){
                        myViewModel.num[0] = myViewModel.mainNumwithNum_0Tocal();
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint=false;
                    }else {
                        myViewModel.num[1] = myViewModel.getMainNum().getValue();
                        myViewModel.sign2="*";
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint=false;
                    }
                }else {
                    myViewModel.num[1] = myViewModel.mainNumWithNum_1_TOCal();
                    myViewModel.sign2="*";
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint=false;
                }
            }
        });
        binding.buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewModel.sign1.equals("")){
                    myViewModel.sign1="/";
                    myViewModel.num[0] = myViewModel.getMainNum().getValue();
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint=false;
                }else if (myViewModel.sign2.equals("")){
                    if (myViewModel.sign1.equals("")){
                        myViewModel.num[0] = myViewModel.mainNumwithNum_0Tocal();
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint=false;
                    }else {
                        myViewModel.num[1] = myViewModel.getMainNum().getValue();
                        myViewModel.sign2="/";
                        myViewModel.getMainNum().setValue("0");
                        myViewModel.havepoint=false;
                    }
                }else {
                    myViewModel.num[1] = myViewModel.mainNumWithNum_1_TOCal();
                    myViewModel.sign2="/";
                    myViewModel.getMainNum().setValue("0");
                    myViewModel.havepoint=false;
            }
            }
        });
        binding.buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.sign2="";
                myViewModel.num[1]="";
                myViewModel.sign1="";
                myViewModel.num[0]="";
                myViewModel.getMainNum().setValue("0");
                myViewModel.havepoint=false;
            }
        });
        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewModel.sign2.equals("")){
                    if (!myViewModel.sign1.equals("")){
                        myViewModel.getMainNum().setValue(myViewModel.mainNumwithNum_0Tocal());
                        if (myViewModel.getMainNum().getValue().contains("."))
                            myViewModel.havepoint=true;
                        else
                            myViewModel.havepoint=false;
                        myViewModel.num[0]="";
                        myViewModel.sign1="";
                    }
                }else {//when a + b * c
                    myViewModel.getMainNum().setValue(myViewModel.mainNumWithNum_1_TOCal());
                    myViewModel.num[1]="";
                    myViewModel.sign2="";
                    myViewModel.getMainNum().setValue(myViewModel.mainNumwithNum_0Tocal());
                    if (myViewModel.getMainNum().getValue().contains("."))
                        myViewModel.havepoint=true;
                    else
                        myViewModel.havepoint=false;
                    myViewModel.num[0]="";
                    myViewModel.sign1="";


                }
                binding.textView.setText(myViewModel.getMainNum().getValue());
            }
        });
            binding.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!myViewModel.getMainNum().getValue().equals("0")){
                        myViewModel.getMainNum().setValue(myViewModel.getMainNum().getValue().substring(0,myViewModel.getMainNum().getValue().length()-1));
                        if (myViewModel.getMainNum().getValue().equals(""))
                            myViewModel.getMainNum().setValue("0");
                    }
                }
            });
    }
}