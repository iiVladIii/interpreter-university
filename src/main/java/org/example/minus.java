package org.example;

public class minus implements expression{
    expression first;
    expression second;
    @Override
    public int interpreted() {
        return first.interpreted()-second.interpreted();
    }
    public minus(expression first, expression second){
        this.second=second;
        this.first=first;
    }
}
