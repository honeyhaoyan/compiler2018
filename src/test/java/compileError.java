import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

public class compileError extends Exception {
    String errorType;
    compileError(String s){
        errorType = s;
    }
}
