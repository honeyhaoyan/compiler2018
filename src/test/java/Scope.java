import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Scope {
   // List<variable>scopeVariable;
    public Map<String,variable>variable;
    public Map<String, functionScope> function;
    List<String>name;
    Scope scopeFather;
    String scopleType;
    Scope(){
        //scopeVariable = new ArrayList<variable>();
        variable = new HashMap<String,variable>();
        function = new HashMap<String, functionScope>();
        name = new ArrayList<String>();
    }
    Scope findScopeFather(Scope self){
        return scopeFather;
    }
}
