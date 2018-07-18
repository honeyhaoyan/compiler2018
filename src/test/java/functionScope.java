import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
class functionScope extends Scope{
    String functionName;
    type returnType;
    //List<variable>inputVariable;
    //Map<int,variabl>inputVariable;
    List<type>inputVariable;
    boolean isClassFunction = false;
    functionScope(){
        super();
        returnType = new type();
        //inputVariable = new HashMap<String, variable>();
        inputVariable = new ArrayList<>();
        scopleType = "Function";
    }
}
