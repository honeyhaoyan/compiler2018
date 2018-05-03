import java.util.HashMap;
import java.util.Map;

public class topScope extends Scope{
    //public Map<String, variable> globalVariable;
    //public Map<String, functionScope> globalFunction;
    public Map<String, classScope> classes;
    topScope(){
        //globalVariable = new HashMap<String, variable>();
        //globalFunction = new HashMap<String, functionScope>();
        classes = new HashMap<String, classScope>();
        scopleType = "top";
    }
}

