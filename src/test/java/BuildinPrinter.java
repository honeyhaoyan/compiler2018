import java.io.*;
public class BuildinPrinter {
    void printBuiltin(String name) throws IOException {
        String dir = "";
        OutputStream os = System.out;
        InputStream is = new FileInputStream("code/builtin_" + name + ".asm");
        int b;
        while((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
    }
}
