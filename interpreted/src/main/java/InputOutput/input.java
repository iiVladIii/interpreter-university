package InputOutput;

import java.util.HashMap;

public class input {
    String name;
    String value;
    static HashMap<String,String> buffer = new HashMap<>();

    public input(String name,String value) {
        this.name=name;
        this.value=value;
        buffer.put(name,value);
    }
    public input(String name) {
        this.name=name;
    }
    public String getValue(String name){
        return buffer.get(name);
    }

}
