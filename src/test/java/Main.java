import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        //InputStream is = new FileInputStream ("program.txt");
        InputStream is = new FileInputStream ("program.txt");
        //String pathname = "//testProgram.txt";
       // File filename = new File(pathname);
       // InputStreamReader is = new InputStreamReader(
       //         new FileInputStream(filename));
        ANTLRInputStream input = new ANTLRInputStream (is);
        MxLexer lexer = new MxLexer (input);
        CommonTokenStream tokens = new CommonTokenStream (lexer);
        //parser.setErrorHandler( new BailErrorStrategy());
        MxParser parser = new MxParser (tokens);
        parser.setErrorHandler( new BailErrorStrategy());
        ParseTree tree = parser.program();

        //System.out.print("123");
        ASTbuilder ASTtree = new ASTbuilder();
        //System.out.println("build ASTtree success");
        Program root = ASTtree.visitProgram((MxParser.ProgramContext) tree);
        //System.out.println("build root success");
        //System.out.println("===================================================================================================");
        ASTvisitor visitor = new ASTvisitor();
        try { visitor.visit(root); }
        catch(Exception exp) {
            throw exp;
        }
        //System.out.println("===================================================================================================");
        IRBuilder irBuilder = new IRBuilder();
        irBuilder.visit(root);
        IRRoot irRoot = irBuilder.getIRRoot();
        //irRoot.print();

        //System.out.println("========================================================");
        /*LivenessAnalysis registerAllocate = new LivenessAnalysis(irRoot);
        registerAllocate.run();*/

        PrintStream ps = null ;
        registerRename rename = new registerRename();
        rename.visit(irRoot,ps);

        LivenessAnalysis registerAllocate = new LivenessAnalysis(irRoot);
        registerAllocate.run();
        //irRoot.print();

        //PrintStream ps = null ;
        ps = new PrintStream("code/out.asm");
        codeGenerator generator = new codeGenerator();
        //Generator generator = new Generator();
        generator.visit(irRoot,ps);
        //IRPrinter irPrinter = new IRPrinter();
        //irPrinter.print(irRoot);
        //root.visit();
        //System.out.println(root.functionSons.toString());


    }
}

//reference:https://blog.csdn.net/sherrywong1220/article/details/53697737
//help:https://github.com/dreamATD/MastarCpler.git