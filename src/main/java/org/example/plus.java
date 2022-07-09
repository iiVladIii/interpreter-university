package org.example;

public class plus implements expression{
   expression first;
   expression second;
    @Override
    public int interpreted() {
        return first.interpreted()+second.interpreted();
    }
    public plus(expression first, expression second){
        this.second=second;
        this.first =first;
    }
}
