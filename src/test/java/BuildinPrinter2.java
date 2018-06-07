import java.io.*;

public class BuildinPrinter2 {
    void printBuiltin(String name, PrintStream fout) throws IOException {
        String dir = "";
        OutputStream os = fout;
        InputStream is = new FileInputStream("code/builtin_" + name + ".asm");
        int b;
        while((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
    }
}
