package GUI;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Stack;
import static virtual.machine.Compiler.*;
import static virtual.machine.ByteCodes.*;
import static virtual.machine.Variables.*;
import virtual.machine.Variables;


public class RunProgram extends javax.swing.JFrame {
    
    Variables var = new Variables();    
    
    public static int IP;                               
       
    static Functions.StandardFunctions standard = new Functions.StandardFunctions();
    static Functions.MathFunctions math = new Functions.MathFunctions();
    static Functions.BuiltInFunctions builtin = new Functions.BuiltInFunctions();
    
    int epal = 0;//para sa functions
    int tir;
    int tpr;
    int tdr;
    Stack<Integer> prevVA; //previous var address       

    Stack<String> arg; //arguments, sa call
    String ret;
    Stack<Boolean> rec; //function call waits for return value

    Stack<String> currentIf;        
    Stack<Boolean> currentIfTrue;     
    Stack<Integer> prevLine; //for method calling, para may babalikan;
    Stack<Integer> currentLoop; //save dito kung saan nagumpisa para malaman kung saan babalikan
    Stack<Boolean> currentLoopTrue; //Kelangan kasi true para pumasok
    Stack ifFails; //if na laman ng false na if
    boolean elseFlag = false;    //kung else naman         
    int elseAge = 0;
    
    String outputText;
    
    public RunProgram() {
        outputText = "";
        initComponents();                     
        output.setText(null);
        //setBounds(740, 40, 629, 700);
    }
    
    public void run(){   
        setIcon();
        System.out.println("Start at line: " + startline);
        System.out.println("End at line: " + endline);
        output.setText(null);
        //Declare uli lahat
        IP = startline;        
        //variables
        phraseIdentifier = new String[ip];
        intIdentifier = new String[ip];
        decimalIdentifier = new String[ip];
        phraseValue = new String[ip];
        intValue = new int[ip];       
        decimalValue = new float[ip];               
        intRange = new Stack();        
        phraseRange = new Stack();
        decimalRange = new Stack();
        //system
        currentIf = new Stack();        
        currentIfTrue = new Stack();   
        ifFails = new Stack();
        arg = new Stack();
        rec = new Stack();
        ret = "";
        prevLine = new Stack();
        prevVA = new Stack();
        currentLoop = new Stack();
        currentLoopTrue = new Stack();
        //allocate index range
        tir = funcInt[vIndex]; //temporary intteger range,  para hindi na i-pop// pang index pala
        tpr = funcPhrase[vIndex]; // ""     Phrase   ""
        tdr = funcDecimal[vIndex]; // ""     Phrase   ""
        intRange.push(funcInt[vIndex]);
        intRange.push(funcInt[vIndex+1]);        
        phraseRange.push(funcPhrase[vIndex]);
        phraseRange.push(funcPhrase[vIndex+1]);  
        decimalRange.push(funcDecimal[vIndex]);
        decimalRange.push(funcDecimal[vIndex+1]);          
        output.setContentType("text/html");
        for(int x=0;x<codes.length;x++){
            System.out.println("line: " + x + ",\tcommand: " + opcodes[codes[x]]);
        }        
        System.out.println("Program flow:");
        while(IP!=endline){            
            System.out.print(IP + ":\t");
            int opcode = codes[IP];                                 
            if(skipThisLine(opcode)){
                continue;
            }
            String[] wew = new String[5];
            try {                
                wew = arguments[IP].split(" ");                
            } catch (java.lang.NullPointerException e) {
            }
            switch(opcode){
                case say:                
                    System.out.print("Say: " + standard.say(arguments[IP]));
                    outputText += standard.say(arguments[IP]);
                    output.setText(outputText);                                        
                    break;
                case get:         
                    String temp = standard.get(arguments[IP]);
                    System.out.print("Get: " + temp);
                    outputText += temp;
                    output.setText(outputText);                    
                    break;
                case Int:                  
                    System.out.println("Declared Integer: " + wew[0] + " = " + wew[2]);
                    outputText += var.declareInt(tir, wew[0], wew[2], false);
                    output.setText(outputText);
                    
                    tir++;
                    break;
                case Decimal:                  
                    System.out.println("Declared Decimal: " + wew[0] + " = " + wew[2]);
                    outputText += var.declareDecimal(tdr, wew[0], wew[2], false);
                    output.setText(outputText);
                            tdr++;
                    break;
                case Phrase:
                    outputText += var.declarePhrase(tpr, wew[0], arguments[IP], false);
                    output.setText(outputText);
                    System.out.println("Declared Phrase: " + phraseIdentifier[tpr] + " = " + phraseValue[tpr]);                                        
                    tpr++;
                    break;
                case Add:                    
                    System.out.println("Add");
                    math.analyzeValues(wew[0], wew[2], wew[4], 0);                    
                    break;
                case Sub:                    
                    System.out.println("Sub");
                    math.analyzeValues(wew[0], wew[2], wew[4], 1);                    
                    break;
                case Mul:                    
                    System.out.println("Mul");
                    math.analyzeValues(wew[0], wew[2], wew[4], 2);                    
                    break;
                case Div:                    
                    System.out.println("Div");
                    math.analyzeValues(wew[0], wew[2], wew[4], 3);                    
                    break;
                case Pow:                    
                    System.out.println("Pow");
                    math.analyzeValues(wew[0], wew[2], wew[4], 4);                    
                    break;
                case Inc:
                    System.out.println("inc");
                    math.analyzeValues("0", "0", arguments[IP], 5);
                    break;
                case Dec:
                    System.out.println("dec");
                    math.analyzeValues("0", "0", arguments[IP], 6);
                    break;
                case Sqrt:
                    System.out.println("sqrt");
                    math.analyzeValues(wew[1], "0", arguments[IP], 7);
                    break;                    
                case If:                        
                    currentIfTrue.push(builtin.ifCondition(arguments[IP])); //check if if is true ahahahaha                                    
                    currentIf.push(arguments[IP]); //lagay sa stack, nasa loob na ng if ung program mapatrue or false man ito                                                             
                    System.out.println("If " + arguments[IP] + " == " + currentIfTrue.peek());
                    break;
                case Else:
                    System.out.println("Else false");
                    elseFlag = true; 
                    break;
                case Endif:                    
                    System.out.println("Endif forever's not enough for me to love you if na true");
                    elseFlag = false;                    
                    elseAge = 0;
                    currentIf.pop();
                    currentIfTrue.pop();                                        
                    break;
                case For:
                    currentLoopTrue.push(builtin.forLoopFalse(arguments[IP]));
                    currentLoop.push(IP);
                    break;
                case Endfor:
                    if(builtin.doStep() == false){
                        IP = currentLoop.peek();                        
                    }
                    else{
                        currentLoop.pop();
                        currentLoopTrue.pop();
                        builtin.forLoopEnd();
                    }
                    break;
                case LineBreak:
                    outputText += "<br>";
                    output.setText(outputText);
                
                   
                    break;
                case Function:
                    functionStart();
                    break;
                case Endfunc:                    
                    functionEnd();
                    break;
                case Return:
                    String retValue = "";
                    boolean hasReturn = false;
                    if(arguments[IP].length() > 0){                        
                        retValue = var.getValue(arguments[IP]);                        
                        hasReturn = true;
                    }
                    functionEnd();
                    if(hasReturn){
                        var.storeToVar(ret, retValue);
                    }
                    break;
                case Call:
                    functionCall();
                    break;                
                case Comment:
                    System.out.println("Comment");
                    break;
                case Assign:
                    var.storeToVar(wew[2], var.getValue(wew[0]));
                    break;
            }                        
            IP++;                       
        }
    }
    
    public void functionStart(){
        if(arguments[IP].contains("receives")){
            String[] parameter = arguments[IP].substring(epal + 1).replace("receives", "").split(",");
            System.out.println("Function: " + Arrays.toString(parameter));
            for(String param : parameter){                                                
                String[] p = param.substring(1).split(" ");
                System.out.println(Arrays.toString(p));
                switch(p[0]){
                    case "Integer":
                        intIdentifier[tir] = p[1];
                        intValue[tir] = Integer.parseInt(arg.pop());
                        System.out.println(intIdentifier[tir] + " " + intValue[tir]);
                        tir++;
                        break;
                    case "Phrase":
                        phraseIdentifier[tpr] = p[1];
                        phraseValue[tpr] = arg.pop();
                        tpr++;
                        break;
                    case "Decimal":
                        decimalIdentifier[tdr] = p[1];
                        decimalValue[tdr] = Float.parseFloat(arg.pop());
                        tdr++;
                        break;
                }
                System.out.println(Arrays.toString(intIdentifier) + "\n" + Arrays.toString(intValue));                            
            }
        }
    }
    
    public void functionEnd(){
        //to do: destroy all local variables declared
        if(!prevLine.isEmpty()){ //kapag empty na ito tapos na ung main, tapos na ung program
            IP = prevLine.pop(); //balik kung saan tinawag ung function
            int ix = intRange.pop();
            int iy = intRange.pop();
            int px = phraseRange.pop();
            int py = phraseRange.pop();
            int dx = decimalRange.pop();
            int dy = decimalRange.pop();
            //destroy all local variables;
            for(;iy<ix;iy++){
                intIdentifier[iy] = "";
                intValue[iy] = 0;
            }
            for(;py<px;py++){
                phraseIdentifier[py] = "";
                phraseValue[py] = "";
            }
            for(;dy<dx;dy++){
                phraseIdentifier[dy] = "";
                phraseValue[dy] = "";
            }
            tdr = prevVA.pop();
            tpr = prevVA.pop();
            tir = prevVA.pop();
        }
        System.out.println("Return to line " + IP);
    }
    
    public void functionCall(){
        prevLine.push(IP); //para may babalikan, kasi masakit kapag hindi binalikan tanginamo gago, jollibee pa puta    
        boolean found = false;
        String func = "";
        for(int x=0;x<callValues.length;x++){
            if(callFrom[x] == IP){ //malaman ung position
                func = callValues[x];
                for(int y=0;y<functionName.length;y++){                                
                    try{// to do: push mula dulo ung arguments gawin ko muna ung variables shit
                        String[] cv = callValues[x].split(" ");//kasi baka may sends
                        System.out.println(Arrays.toString(callValues[x].split(" ")) + " " + functionName[y]);
                        if(cv[0].equals(functionName[y])){
                            if(callValues[x].contains("receives")){
                                ret = cv[cv.length - 1];
                                callValues[x] = callValues[x].substring(0, callValues[x].indexOf(" receives"));
                                System.out.println("Without return: " + callValues[x] +";" + ret);
                            }
                            epal = functionName[y].length();
                            if(callValues[x].contains("sends")){ //kapag may isesend
                                cv = callValues[x].substring(cv[0].length() + 6).split(",");
                                System.out.println(Arrays.toString(cv));
                                for(int i=cv.length-1;i>=0;i--){ //pass ng value sa tinatawag na function
                                    System.out.println(cv[i].substring(1));                                                
                                    String value = var.getValue(cv[i].substring(1));                                                
                                    arg.push(value);
                                }
                            }
                            found = true;
                            prevVA.push(tir);//lagay muna sa stack ung pang index in int
                            prevVA.push(tpr);// """"""" phrase
                            prevVA.push(tdr);// """"""" phrase
                            IP = funcRange[y];//jump sa line ng tinawag na function
                            tir = funcInt[y];//start address na na-allocate sa int 
                            tpr = funcPhrase[y];// """"" phrase
                            tdr = funcDecimal[y];// """"" phrase
                            intRange.push(funcInt[y]);// range ng int start
                            intRange.push(funcInt[y+1]);//range ng int last
                            phraseRange.push(funcPhrase[y]);//""" phrase ""
                            phraseRange.push(funcPhrase[y+1]);//""" phrase ""
                            decimalRange.push(funcDecimal[y]);//""" phrase ""
                            decimalRange.push(funcDecimal[y+1]);//""" phrase ""
                            System.out.println("Called function " + functionName[y] + ", Go to line " + IP);                            
                            IP--;
                            break;
                        }
                    }catch(java.lang.NullPointerException e){                                    
                    }
                }
            }
        }
        if(!found){
            outputText += "<html><font color = \"red\">The function '" + func + "' may not have been defined</font></html>";
            output.setText(outputText);
        }
    }
    
    public boolean skipThisLine(int opcode){
        if(!currentIf.isEmpty()){ //kung walang laman ung if stack
            if(currentIfTrue.lastElement() == false){ //kapag false hind magpa-process kasi nga false wtf
                switch(opcode){             
                    case If:
                        ifFails.push(0);
                        break;
                    case Else:                                   
                        if(ifFails.isEmpty()){ // para hindi gamitin ung else ng if na laman ng false na if
                            System.out.println("Else true");
                            elseFlag = true; //kapag false ung if syempre else                                                       
                        }
                        break;
                    case Endif: //pop ung nasa stack, lalabas ng if      
                        System.out.println("Endif forever's not enough for me to love you false na if");
                        if(!ifFails.isEmpty()){
                            ifFails.pop();                            
                        }
                        else{
                            currentIf.pop();
                            currentIfTrue.pop();                                                        
                            elseFlag = false;                            
                            elseAge = 0;
                        }
                        break;
                    default:
                        if(elseFlag == false){
                            System.out.println("This line was not processed if is not true");
                        }
                }
                if(elseAge!=0){                        
                }
                else{
                    if(elseFlag == true){
                        elseAge++;
                    }
                    IP++;
                    return true;
                }
            }                
        }                        
        if(elseFlag == true && currentIfTrue.peek() == true){ //kapag true ung if, false ung else                
            String effortbeshie;
            if(codes[IP] == Endif){
                effortbeshie = "Endif forever's not enough for me to love you if na true";
                elseFlag = false;                            
                elseAge = 0;
                currentIf.pop();
                currentIfTrue.pop();                                                                            
            }
            else{
                effortbeshie = "This line was not processed if is true";
            }
            System.out.println(effortbeshie);
            IP++;                                
            return true; //hindi na ipa-process ung sumusunod sa else hanggang mag endif
        }
        if(!currentLoop.isEmpty()){
            if(currentLoopTrue.peek() == false){
                if(opcode == Endfor){
                    currentLoop.pop();                        
                    System.out.println("endfor hindi pumasok sa for");
                }
                IP++;
                return true;
            }
        }
        return false;
    }
   
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("6.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextPane();

        setTitle("Output - " + IDE.currentFile);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        output.setEditable(false);
        jScrollPane1.setViewportView(output);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane output;
    // End of variables declaration//GEN-END:variables

    
}
