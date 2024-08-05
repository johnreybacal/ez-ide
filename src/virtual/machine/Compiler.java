/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.machine;

import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;
import static virtual.machine.ByteCodes.*;
import static virtual.machine.Variables.*;

/**
 *
 * @author knighty03
 */
public class Compiler {
    
    Variables var = new Variables();
    
    public static int[] codes; 
    public static int ip = 0;
        
    public static String[] functionName;
    public static int[] funcRange; //start and end of functions
    public static int[] funcInt; //local variables
    public static int[] funcPhrase; //also serves as range for variables
    public static int[] funcDecimal;
    public static int funcIndex = 0;
    public static int frIndex = 0;//func range
    public static int vIndex = 0;//send to RunProgram to know initial method for local variables
        
    public static String[] callValues;
    public static int[] callFrom;
    public static int callIndex = 0;        
    
    public static String[] arguments;
    
    public static int startline;
    public static int endline;
    
    public static String errors = "";
    public void compile(String[] codeLine){
        boolean compileError = false;
        errors = "";
        int nof = getAllFunctions(codeLine);
        //declare uli lahat para hindi magamit ung last time                    
        int wow = codeLine.length;
        codes = new int[wow];          
        functionName = new String[nof];
        callValues = new String[wow];
        callFrom = new int[wow];
        arguments = new String[wow];  
        globalII = new String[wow];
        globalIV = new int[wow];
        globalPI = new String[wow];
        globalPV = new String[wow];
        globalDI = new String[wow];
        globalDV = new float[wow];
        ip = 0;                
        gi = 0;
        gp = 0;
        funcIndex = 0;
        callIndex = 0;
        Stack forStack = new Stack();
        Stack ifStack = new Stack();
        Stack<String> latestStack = new Stack();
        boolean iof = true; //is outside functions
        for(String line : codeLine){                        
            String[] pppp = line.split(" ");
            String command = pppp[0];//kunin ung command            
            for(int a=0;a<opcodes.length;a++){                        
                if(command.equals(opcodes[a])){                                 
                    codes[ip] = a; //assign ung index ng opcodes                             
                    //System.out.println(line.substring(opcodes[codes[ip]].length()));                                        
                    break;
                }
            }                       
            switch(codes[ip]){
                case say:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        int c = 0x2c2;
                        arguments[ip] = line.substring(4).replaceAll("<",Character.toString((char) c));  
                    }
                    break;
                case get:    
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);    
                    }
                    break;
                case If: 
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(3);     
                        ifStack.push(0);
                        latestStack.push("if");
                    }
                    break;             
                case Endif:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{     
                        try{
                            if(latestStack.pop().equals("if")){
                                    ifStack.pop();
                            }
                            else{
                                errors += "<html><font color = \"red\">Error on line " + ip + ": Nesting error\n";
                            }
                        }catch(Exception e){
                            errors += "<html><font color = \"red\">Error on line " + ip + ": Enexpected Endif\n";
                        }
                    }
                    break;
                case For:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);
                        forStack.push(0);
                        latestStack.push("for");
                    }
                    break;
                case Endfor:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{     
                        try{
                            if(latestStack.pop().equals("for")){
                                    forStack.pop();
                            }
                            else{
                                errors += "<html><font color = \"red\">Error on line " + ip + ": Nesting error\n";
                            }
                        }catch(Exception e){
                            errors += "<html><font color = \"red\">Error on line " + ip + ": Unexpected Endfor\n";
                        }
                    }
                    break;
                case Decimal:    
                    if(iof){//global decimal
                        String[] wew = line.substring(8).split(" ");
                        errors += "<html><font color = \"red\">Error on line " + (ip +1) + ": " + var.declareDecimal(gd, wew[0], line.substring(8), true);
                    }
                    System.out.println(line);
                    arguments[ip] = line.substring(8);                                                                                                            
                    break;
                case Int:      
                    if(iof){//global int
                        String[] wew = line.substring(8).split(" ");
                        errors += "<html><font color = \"red\">Error on line " + (ip +1) + ": " + var.declareInt(gi, wew[0], line.substring(8), true);
                    }
                    else{
                        arguments[ip] = line.substring(8);                                                                                                            
                    }
                    break;
                case Phrase:                                                                            
                    if(iof){//global phrase
                        String[] wew = line.substring(7).split(" ");
                        errors += "<html><font color = \"red\">Error on line " + (ip +1) + ": " + var.declarePhrase(gp, wew[0], line.substring(8), true);
                    }
                    arguments[ip] = line.substring(7);                                                                    
                    break;
                
                case Add:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4); 
                    }
                    break;
                case Sub:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);
                    }
                    break;
                case Mul:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4); 
                    }
                    break;
                case Div:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);                                                
                    }
                    break;
                case Pow:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);   
                    }
                    break;
                case Inc:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);
                    }
                    break;
                case Dec:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(4);
                    }
                    break;
                case Sqrt:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        arguments[ip] = line.substring(5);
                    }
                    break;
                case Function:
                    if(!iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + ": Unexpected Function Definition\n";
                    }
                    else{
                        iof = false;
                        String[] tempFunc = line.substring(9).split(" ");
                        arguments[ip] = line.substring(9);
                        functionName[funcIndex++] = tempFunc[0];                            
                        functionName[funcIndex++] = "end of " + tempFunc[0]; 
                    }
                    break;
                case Endfunc:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + ": Unexpected Endfunc\n";
                    }
                    else{
                        iof = true;
                    }                    
                    break;
                case Call:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n";
                    }
                    else{
                        callValues[callIndex] = line.substring(5);                            
                        callFrom[callIndex++] = ip;
                    }
                    break;   
                case Comment:
                    break;
                case LineBreak:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n"; 
                    }
                    break;
                case Return:
                    if(iof){
                        errors += "<html><font color = \"red\">Error on line " + (ip + 1) + "\n"; 
                    }
                    else{
                        if(line.length() > 6){
                            arguments[ip] = line.substring(7);
                            System.out.println(arguments[ip]);
                        }
                    }
                    break;
                case Assign:
                    arguments[ip] = line.substring(7);
            }                    
            ip++;   
        }        
        if(!ifStack.isEmpty()){
            errors += "Endif Expected\n";
        }
        if(!forStack.isEmpty()){
            errors += "Endfor Expected\n";
        }
        searchForMain();
        //errors += "";
        if(errors.length() > 0){
            JOptionPane.showMessageDialog(null, errors, "Compilation Error", JOptionPane.ERROR_MESSAGE);
            endline = startline;
        }
        System.out.println("last ip: " + ip);        
    }
    
    public int getAllFunctions(String[] codeLine){ 
        boolean iof = true;
        int nof = 0;//number of functions
        for (String codeLine1 : codeLine) { //loop para bilangin kung gano karami functions
            String[] line = codeLine1.split(" ");
            if(line[0].equals(opcodes[Function])){ 
                nof++;
            }
        }
        funcRange = new int[nof*2];
        funcInt = new int[nof*2];
        funcPhrase = new int[nof*2];
        funcDecimal = new int [nof*2];
        frIndex = 0;
        for(int x=0;x<codeLine.length;x++){ //loop para kunin kung saan nagsimula at saan matatapos ang function
            String[] line = codeLine[x].split(" ");
            if(line[0].equals(opcodes[Function])){ 
                iof = false;
                funcRange[frIndex] = x;
                if(frIndex == 0){ //Address allocation for local variables
                    funcInt[frIndex] = 0;
                    funcPhrase[frIndex] = 0;
                    funcDecimal[frIndex] = 0;
                   
                    funcInt[frIndex + 1] = 0;
                    funcPhrase[frIndex + 1] = 0;
                    funcDecimal[frIndex+ 1] = 0;
                }
                else{
                    funcInt[frIndex] = funcInt[frIndex-1] + 1;
                    funcPhrase[frIndex] = funcPhrase[frIndex-1] + 1;
                    funcDecimal[frIndex] = funcDecimal[frIndex-1] + 1;
                    
                    funcInt[frIndex + 1] = funcInt[frIndex-1] + 1;
                    funcPhrase[frIndex + 1] = funcPhrase[frIndex-1] + 1;
                    funcDecimal[frIndex + 1] = funcDecimal[frIndex-1] + 1;
                }
                frIndex++;                
                String[] temp = codeLine[x].split(" ");                
                if(codeLine[x].contains("receives")){ 
                    String[] parameters = codeLine[x].substring(9 + temp[1].length() + 9).split(",");   
                    System.out.println(Arrays.toString(parameters));
                    for(String p : parameters){
                        String[] param = p.substring(1).split(" ");
                        System.out.println(Arrays.toString(param));
                        switch(param[0]){
                            case "Integer":
                                funcInt[frIndex]++;
                                break;
                            case "Phrase":
                                funcPhrase[frIndex]++;
                                break;
                            case "Decimal":
                                funcDecimal[frIndex]++;
                                break;
                        }
                    }
                }

            }
            if(line[0].equals(opcodes[Int]) && !iof){
                funcInt[frIndex]++;
            } 
            if(line[0].equals(opcodes[Phrase]) && !iof){
                funcPhrase[frIndex]++;
            }
            if(line[0].equals(opcodes[Decimal]) && !iof){
                funcDecimal[frIndex]++;
            }
            if(line[0].equals(opcodes[Endfunc])){   
                try{
                    funcRange[frIndex++] = x;       
                    iof = true;
                }catch(Exception e){
                    //errors += "<html><font color = \"red\">Endfunc unexpected";
                }
            }
        }
        System.out.println("Integer:\t" + Arrays.toString(funcInt));
        System.out.println("Phrase:\t" + Arrays.toString(funcPhrase));
        System.out.println("Decimal:\t" + Arrays.toString(funcDecimal));
        return nof*2;
    }
    
    public void searchForMain(){
        startline = 0;
        endline = 0;
        boolean mainFound = false;
        for(int x=0;x<functionName.length;x++){ //obvious naman, para malaman kung saan maguumpisa ung code
            if(functionName[x].equals("main")){
                vIndex = x;
                startline = funcRange[x];
                endline = funcRange[x+1];
                mainFound = true;
            }
        }
        if(!mainFound){
            Errors error = new Errors();
            errors += "<html><font color = \"red\">main function not found\n";
            error.hasError();
        }
    }
}
