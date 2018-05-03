import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
class functionScope extends Scope{
    String functionName;
    type returnType;
    //List<variable>inputVariable;
    Map<String,variable>inputVariable;
    functionScope(){
        super();
        returnType = new type();
        inputVariable = new HashMap<String, variable>();
        scopleType = "Function";
    }
}
