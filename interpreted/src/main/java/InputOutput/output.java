package InputOutput;

import java.util.HashMap;

public class output {
    String string;
    public output(String myString) {

        this.string=myString;
    }
    public String outputstr() {
        if(string.startsWith("'")&&string.endsWith("'")){
             System.out.println(string.replaceAll("'",""));
            return string.replaceAll("'","");
        }
        else{
            input input = new input(string);
            System.out.println(input.getValue(string));
            return input.getValue(string);
        }
    }
}
