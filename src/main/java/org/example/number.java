package org.example;

public class number implements expression {
    int num;
    public number(int num){
        this.num=num;
    }
    @Override
    public int interpreted() {
        return num;
    }
}
