package org.example;

public class division implements expression{
    expression first;
    expression second;
    @Override
    public int interpreted() {
        return first.interpreted()/second.interpreted();
        //тут должна быть ошибка если ноль
    }
    public division(expression first, expression second){
        this.second=second;
        this.first =first;
    }
}
