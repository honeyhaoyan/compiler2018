import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        InputStream is = new FileInputStream ("code/testProgram.txt");
        //String pathname = "//testProgram.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
       // File filename = new File(pathname); // 要读取以上路径的input。txt文件
       // InputStreamReader is = new InputStreamReader(
       //         new FileInputStream(filename));
        ANTLRInputStream input = new ANTLRInputStream (is);
        MxLexer lexer = new MxLexer (input);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        MxParser parser = new MxParser (tokens);
        ParseTree tree = parser.program();

        //System.out.print("123");
        ASTbuilder ASTtree = new ASTbuilder();
        //System.out.println("build ASTtree success");
        Program root = ASTtree.visitProgram((MxParser.ProgramContext) tree);
        //System.out.println("build root success");
        //System.out.println("===========================================================");
        ASTvisitor visitor = new ASTvisitor();
        try { visitor.visit(root); }
        catch(Exception exp) {
            throw exp;
        }
        //root.visit();
        //System.out.println(root.functionSons.toString());


    }
}

//reference:https://blog.csdn.net/sherrywong1220/article/details/53697737
//help:https://github.com/dreamATD/MastarCpler.git