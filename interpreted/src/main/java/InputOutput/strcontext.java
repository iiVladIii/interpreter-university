package InputOutput;



public class strcontext {
    String evaluet(String s){
        String res= "";
        if(s.startsWith("input"))
        {   String str = s.substring(s.lastIndexOf("input")+6);
            if(str.contains(":")) {
                        String fisrt = str.substring(0,str.indexOf(":"));
                        String second = str.substring(str.indexOf(":")+1,str.length());
                        input input = new input(fisrt, second);
                        input.getValue(fisrt);
                        res = second;
                }
            else{
                //todo mistake not op assignment
            }
            }
        else if(s.startsWith("output")){
            String mystr = s.substring(s.lastIndexOf("output")+7);
            output output = new output(mystr);
            output.outputstr();
            res=mystr;
        }
        return res;
    }
}
