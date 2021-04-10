package com.example.mycaculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
//save data
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> mainNum;

    public String num[]={"",""};// store num
    public String sign1="",sign2=""; // store +_*/
    public boolean havepoint=false; // 0.1



    public MutableLiveData<String> getMainNum(){
        if(mainNum == null){
            mainNum = new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }
    public void setMainNum(String n){
        if(mainNum.getValue().equals("0")){
            mainNum.setValue(n);
        }else {
            mainNum.setValue(mainNum.getValue() + n);
        }
    }
    public  String mainNumwithNum_0Tocal(){
        String value = "0";
        if (mainNum.getValue().contains(".") || num[0].contains(".")){
            switch (sign1){
                case "+":
                    value = String.valueOf( Double.valueOf(num[0]) + Double.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf( Double.valueOf(num[0]) - Double.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf( Double.valueOf(num[0]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0"))
                            mainNum.setValue("1");
                    value = String.valueOf( Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
            }
        }else { // if 2 number were integer
            switch (sign1){
                case "+":
                    value = String.valueOf( Integer.valueOf(num[0]) + Integer.valueOf(mainNum.getValue()));
                    break;
                case "-":
                    value = String.valueOf( Integer.valueOf(num[0]) - Integer.valueOf(mainNum.getValue()));
                    break;
                case "*":
                    value = String.valueOf( Integer.valueOf(num[0]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0"))
                            mainNum.setValue("1");
                    value = String.valueOf( Double.valueOf(num[0]) / Double.valueOf(mainNum.getValue()));
            }

        }
        return value;
    }
    public String mainNumWithNum_1_TOCal(){
        String value = "0";
        if (mainNum.getValue().contains(".") || num[1].contains(".")){
            switch (sign2){

                case "*":
                    value = String.valueOf( Double.valueOf(num[1]) * Double.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0"))
                        mainNum.setValue("1");
                    value = String.valueOf( Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }
        }else { // if 2 number were integer
            switch (sign2){

                case "*":
                    value = String.valueOf( Integer.valueOf(num[1]) * Integer.valueOf(mainNum.getValue()));
                    break;
                case "/":
                    if (mainNum.getValue().equals("0"))
                        mainNum.setValue("1");
                    value = String.valueOf( Double.valueOf(num[1]) / Double.valueOf(mainNum.getValue()));
            }

        }
        return value;
    }
}
