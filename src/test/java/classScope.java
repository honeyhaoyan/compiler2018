import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class classScope extends Scope{
    String className;
    //List<functionScope>classFunction;
    //Map<String,functionScope>classFunction;
    classScope(){
        //classFunction = new HashMap<String,functionScope>();
        super();
        scopleType = "class";
    }
}
