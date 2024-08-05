/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.machine;

import GUI.RunProgram;
import Functions.methodCaller;
import com.sun.deploy.uitoolkit.impl.fx.ui.ErrorPane;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;
/**
 *
 * @author knighty03
 */
public class Variables {
    
    public static String[] intIdentifier;
    public static int[] intValue;
        
    public static String[] phraseIdentifier;
    public static String[] phraseValue;
    
    public static String[] decimalIdentifier;
    public static float[] decimalValue;
    
    public static String[] globalII; //global int identifier
    public static int[] globalIV;  //gloval int value
    public static int gi; //global int index
    
    public static String[] globalPI; //phrase version
    public static String[] globalPV; 
    public static int gp; //global phrase index
    
    public static String[] globalDI; 
    public static float[] globalDV; 
    public static int gd;
    
    public static Stack<Integer> intRange;
    public static Stack<Integer> phraseRange;
    public static Stack<Integer> decimalRange;
    
    boolean varFound = false;
    
    methodCaller mc = new methodCaller();
    Errors errors = new Errors();
    
    
    int iy;
    int ix;
    int py;
    int px;
    int dy;
    int dx;
    
    public Variables(){
        intRange = new Stack();
        phraseRange = new Stack();
        decimalRange = new Stack();
    }
    
    public void getLocalAddress(){
        ix = intRange.pop(); //last address
        iy = intRange.pop(); //start address
        px = phraseRange.pop(); //last address
        py = phraseRange.pop(); //start address
        dx = decimalRange.pop();
        dy = decimalRange.pop();
        intRange.push(iy);
        intRange.push(ix);
        phraseRange.push(py);
        phraseRange.push(px);
        decimalRange.push(dy);
        decimalRange.push(dx);
    }
    
    public String getValue(String value){               
        getLocalAddress();                
        if(value.charAt(0) == '$'){                                    
            for(int y=iy;y<ix;y++){ 
                if(value.equals(intIdentifier[y])){
                    varFound = true;
                    return Integer.toString(intValue[y]);                        
                }
            }                    
            for(int y=0;y<gi;y++){                
                if(value.equals(globalII[y])){ 
                    varFound = true;
                    return Integer.toString(globalIV[y]);                         
                }
            }    
            for(int y=py;y<px;y++){
                if(value.equals(phraseIdentifier[y])){
                    varFound = true;
                    return phraseValue[y];
                }
            }
            for(int y=0;y<gp;y++){
                if(value.equals(globalPI[y])){  
                    varFound = true;
                    return globalPV[y];
                }
            }
            for(int y=dy;y<dx;y++){                
                System.out.println(value + " " + decimalIdentifier[y]);
                if(value.equals(decimalIdentifier[y])){
                    varFound = true;
                    return Float.toString(decimalValue[y]);                        
                }
            }
            for(int y=0;y<gd;y++){                
                if(value.equals(globalDI[y])){  
                    varFound = true;
                    return Float.toString(globalDV[y]);                    
                }
            }
            if(!varFound){//feps
                errors.hasError();    
                return "<html><font color = \"red\">Variable '" + value + "' not found</font></html>";
            }//feps
        }
        return value;  
    }
    
    public String declareInt(int index, String varName, String value, boolean isGlobal){
        if(varName.charAt(0) != '$'){
            errors.hasError();
            return "<html><font color = \"red\">Must place a '$' before the '" + varName + "'</font></html>";
        }
        if(!Character.isAlphabetic(varName.charAt(1))){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' must start with a letter</font></html>";
        }
        if(isAlreadyDeclared(varName)){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' was already declared</font></html>";
        }
        else{
            if(!isGlobal){
                intIdentifier[index] = varName;
                try{
                    intValue[index] = Integer.parseInt(value);
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
            else{
                globalII[index] = varName;
                try{
                    globalIV[index] = Integer.parseInt(value);
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
        }
        return "";
    }
    
    public String declareDecimal(int index, String varName, String value, boolean isGlobal){
        if(varName.charAt(0) != '$'){
            errors.hasError();
            return "<html><font color = \"red\">Must place a '$' before the '" + varName + "'</font></html>";
        }
        if(!Character.isAlphabetic(varName.charAt(1))){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' must start with a letter</font></html>";
        }
        if(isAlreadyDeclared(varName)){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' was already declared</font></html>";
        }
        else{
            if(!isGlobal){
                decimalIdentifier[index] = varName;
                try{
                    decimalValue[index] = Float.parseFloat(value);
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
            else{
                globalDI[index] = varName;
                try{
                    globalDV[index] = Float.parseFloat(value);
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
           
        }
        return "";
    }
    
    public String declarePhrase(int index, String varName, String value, boolean isGlobal){        
        if(varName.charAt(0) != '$'){
            errors.hasError();
            return "<html><font color = \"red\">Must place a '$' before the '" + varName + "'</font></html>";
        }
        if(!Character.isAlphabetic(varName.charAt(1))){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' must start with a letter</font></html>";
        }
        boolean Found = false;
        for(int y=py;y<px;y++){ 
            if(varName.equals(phraseIdentifier[y])){
                for(int d=0;d<value.length();d++){
                        char a = value.charAt(d);
                        if(!Character.isWhitespace(a)){
                            phraseIdentifier[index] += a;
                        }
                        else{
                            d+=4;
                            phraseValue[index] = value.substring(d);
                            break;
                        }
                    }
                Found = true;                        
            }
        }                    
        for(int y=0;y<gp;y++){                
            if(varName.equals(globalPI[y])){ 
                Found = true;                        
            }
        }
        if(Found){
            errors.hasError();
            return "<html><font color = \"red\">Variable '" + varName + "' was already declared</font></html>";
        }
        else{
            if(!isGlobal){
                phraseIdentifier[index] = varName;
                try{
                    phraseValue[index] = value;
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
            else{
                globalPI[index] = varName;
                try{
                    globalPV[index] = value;
                }catch(Exception e){
                    errors.hasError();
                    return "<html><font color = \"red\">Data type mismatch</font></html>";
                }
            }
        }
        return "";
    }
    
    public boolean isAlreadyDeclared(String varName){
        boolean Found = false;
        for(int y=iy;y<ix;y++){ 
            if(varName.equals(intIdentifier[y])){
                Found = true;                        
            }
        }                    
        for(int y=0;y<gi;y++){                
            if(varName.equals(globalII[y])){ 
                Found = true;                        
            }
        }
        for(int y=dy;y<dx;y++){ 
            if(varName.equals(decimalIdentifier[y])){
                Found = true;                        
            }
        }                    
        for(int y=0;y<gd;y++){                
            if(varName.equals(globalDI[y])){ 
                Found = true;                        
            }
        }
        for(int y=dy;y<dx;y++){ 
            if(varName.equals(decimalIdentifier[y])){
                Found = true;                        
            }
        }                    
        for(int y=0;y<gd;y++){                
            if(varName.equals(globalDI[y])){ 
                Found = true;                        
            }
        }
        return Found;
    }
    
    public void storeToVar(String varName, String value){
        System.out.println(value);
        getLocalAddress();
        boolean found = false;
        for(int y=iy;y<ix;y++){
            if(varName.equals(intIdentifier[y])){     
                if(value.contains(".")){
                    intValue[y] = (int) Float.parseFloat(value);
                }
                else{
                    intValue[y] = Integer.parseInt(value);
                }
                found = true;
            }
        }        
        for(int y=0;y<gi;y++){
            if(varName.equals(intIdentifier[y])){     
                if(value.contains(".")){
                    intValue[y] = (int) Float.parseFloat(value);
                }
                else{
                    intValue[y] = Integer.parseInt(value);
                }
                found = true;
            }
           
        }        
        for(int y=dy;y<dx;y++){
            if(varName.equals(decimalIdentifier[y])){                     
                decimalValue[y] = Float.parseFloat(value);
                found = true;
            }
        }        
        for(int y=0;y<gd;y++){
            if(varName.equals(globalDI[y])){                     
                globalDV[y] = Float.parseFloat(value);
                found = true;
            }
        }
        for(int y=py;y<px;y++){
            if(varName.equals(phraseIdentifier[y])){                     
                phraseValue[y] = value;
                found = true;
            }
        }        
        for(int y=0;y<gp;y++){
            if(varName.equals(globalPI[y])){                     
                globalPV[y] = value;
                found = true;
            }
        }
        if(!found){
            errors.hasError();
        }
    }        
    
   
}
