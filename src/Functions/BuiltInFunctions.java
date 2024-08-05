/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.util.Stack;
import static virtual.machine.Variables.*;
/**
 *
 * @author knighty03
 */
public class BuiltInFunctions {
    
    //for for loop hahaha
    public static Stack<Integer> step = new Stack();
    public static Stack<String> variable = new Stack();
    public static Stack<Integer> first = new Stack();
    public static Stack<Integer> second = new Stack();    
    
    public boolean ifCondition(String ic){
        int f = 0;//0 for phrase 1 for integer
        int s = 0;
        int ix = intRange.pop(); //last address
        int iy = intRange.pop(); //start address
        int px = phraseRange.pop(); //last address
        int py = phraseRange.pop(); //start address
        intRange.push(iy);
        intRange.push(ix);
        phraseRange.push(py);
        phraseRange.push(px);
        String[] ifC = ic.split(" ");
        if(ifC.length > 3){
            String[] temp = valuesHaveSpace(ifC, ic);            
            ifC = temp;
        }
        int x = 0;
        int z = 0;
        if(isInteger(ifC[0])){
            f = 1;
            x = Integer.parseInt(ifC[0]);
        }
        if(isInteger(ifC[2])){
            s = 1;
            z = Integer.parseInt(ifC[2]);
        }
        if(ifC[0].charAt(0) == '$'){
            for(int y=iy;y<ix;y++){
                if(ifC[0].substring(1).equals(intIdentifier[y])){                            
                    x = intValue[y];
                    f = 1;
                }
            }
            for(int y=py;y<px;y++){
                if(ifC[0].substring(1).equals(phraseIdentifier[y])){                                                
                    f = 0;
                }
            }
            for(int y=0;y<gi;y++){
                if(ifC[0].substring(1).equals(globalII[y])){                            
                    x = globalIV[y];
                    f = 1;
                }
            }
            for(int y=0;y<gp;y++){
                if(ifC[0].substring(1).equals(globalII[y])){                                                
                    f = 0;
                }
            }
        }
        if(ifC[2].charAt(0) == '$'){
            for(int y=iy;y<ix;y++){
                if(ifC[2].substring(1).equals(intIdentifier[y])){                            
                    x = intValue[y];
                    f = 1;
                }
            }
            for(int y=py;y<px;y++){
                if(ifC[2].substring(1).equals(phraseIdentifier[y])){                                                
                    f = 0;
                }
            }
            for(int y=0;y<gi;y++){
                if(ifC[2].substring(1).equals(globalII[y])){                            
                    x = globalIV[y];
                    f = 1;
                }
            }
            for(int y=0;y<gp;y++){
                if(ifC[2].substring(1).equals(globalII[y])){                                                
                    f = 0;
                }
            }
        }
        int ww = 0;
        switch(ifC[1]){           
            case "==":  ww = 0;  break;             
            case "!=":  ww = 1;  break;             
            case ">":   ww = 2;  break;             
            case "<":   ww = 3;  break;             
            case ">=":  ww = 4;  break;             
            case "<=":  ww = 5;  break;                             
        }                
        //phrase equals
        if(f == 0 && ww == 0 && s == 0){
            if(ifC[0].equals(ifC[2])){
                return true;
            }
        }                
        //phrase not equals
        if(f == 0 && ww == 1 && s == 0){
            if(!ifC[0].equals(ifC[2])){
                return true;
            }
        }        
        //int equals
        if(f == 1 && ww == 0 && s == 1){
            if(x == z){
                return true;
            }
        }        
        //int not equals
        if(f == 1 && ww == 1 && s == 1){
            if(x != z){
                return true;
            }
        }
        //int greater than
        if(f == 1 && ww == 2 && s == 1){
            if(x > z){
                return true;
            }
        }
        //int less than       
        if(f == 1 && ww == 3 && s == 1){
            if(x < z){
                return true;
            }
        }        
        //int greater than or equals
        if(f == 1 && ww == 4 && s == 1){
           if(x >= z){
                return true;
            }
        }
        //int less than or equals
        if(f == 1 && ww == 5 && s == 1){
            if(x <= z){
                return true;
            }
        }
        
        return false;
    }   
    
    public String[] valuesHaveSpace(String[] ifC, String ic){
        ifC = new String[3];
        String temp = "";
        for(int x=0;x<ic.length();x++){
            char a = ic.charAt(x);
            temp += a;
            if(Character.isWhitespace(a)){
                boolean flag = false;
                int back = 0;
                switch(temp){
                    case "==":  ifC[1] = temp;  flag = true;    back = 3;   break;             
                    case "!=":  ifC[1] = temp;  flag = true;    back = 3;   break;             
                    case ">":   ifC[1] = temp;  flag = true;    back = 2;   break;             
                    case "<":   ifC[1] = temp;  flag = true;    back = 2;   break;             
                    case ">=":  ifC[1] = temp;  flag = true;    back = 3;   break;             
                    case "<=":  ifC[1] = temp;  flag = true;    back = 3;   break;
                }
                if(flag){
                    ifC[0] = ic.substring(back);
                    ifC[2] = ic.substring(x);                    
                    break;
                }                                
                temp = "";
            }            
        }
        return ifC;
    } 
    
    public boolean isInteger(String x){
        for(char a : x.toCharArray()){
            if(!Character.isDigit(a)){
                return false;
            }
        }
        return true;
    }
    
    public boolean forLoopFalse(String x){
        int ix = intRange.pop();
        int iy = intRange.pop();
        intRange.push(iy);
        intRange.push(ix);
        String[] condition = x.split(" ");        
        int f = 0;
        int s = getValue(condition[4]);        
        for(int y=iy;y<ix;y++){            
            if(condition[0].equals(intIdentifier[y])){
                if(condition[2].contains("$")){
                    for(int z=iy;z<ix;z++){
                        if(condition[2].equals(intIdentifier[z])){
                            intValue[y] = intValue[z];
                        }
                    }
                }
                else{
                    intValue[y] = Integer.parseInt(condition[2]);
                }
                f = intValue[y];
            }                                
        }
        for(int y=0;y<gi;y++){            
            if(condition[0].equals(globalII[y])){
                if(condition[2].contains("$")){
                    for(int z=iy;z<ix;z++){
                        if(condition[2].equals(globalII[z])){
                            globalIV[y] = globalIV[z];
                        }
                    }
                }
                else{
                    globalIV[y] = Integer.parseInt(condition[2]);
                }
                f = intValue[y];
            }                                
        }
        variable.push(condition[0]);
        first.push(f);
        second.push(s);
        step.push(getValue(condition[6]));
        return f != s;
    }
    
    public int getValue(String condition){
        int ix = intRange.pop();
        int iy = intRange.pop();
        intRange.push(iy);
        intRange.push(ix);
        int value = 0;        
        for(int y=iy;y<ix;y++){            
            if(condition.contains("$")){
                if(condition.substring(1).equals(intIdentifier[y])){
                    value = intValue[y];
                }
            }
            else{
                value = Integer.parseInt(condition);
            }
        }
        for(int y=0;y<gi;y++){            
            if(condition.contains("$")){
                if(condition.substring(1).equals(globalII[y])){
                    value = globalIV[y];
                }
            }
            else{
                value = Integer.parseInt(condition);
            }
        }
        return value;
    }
    
    public boolean doStep(){
        int ix = intRange.pop();
        int iy = intRange.pop();
        intRange.push(iy);
        intRange.push(ix);
        int f = first.pop();        
        f += step.peek();
        first.push(f);        
        int s = second.peek();
        for(int x=iy;x<ix;x++){
            if(variable.peek().equals(intIdentifier[x])){
                intValue[x] = f;
            }
        }
        return f == s;
    }
    
    public void forLoopEnd(){
        first.pop();
        second.pop();
        step.pop();
    }
    
   // public static void main(String[] args){
    //    String q = "1+1";
     //   System.out.println(Integer.parseInt(q));
    //}
}
