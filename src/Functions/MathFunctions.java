/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;
import virtual.machine.Variables;
/**
 *
 * @author knighty03
 */
public class MathFunctions {
         
    Variables var = new Variables();
    
    public MathFunctions(){
        System.out.println("Math Functions Library loaded");
    }
        
    public void analyzeValues(String a, String b, String c, int d){
        
        int f = 0; // 0 is int 
        int s = 0; // 1 is float
        /*if(a.contains(".")){
            f = 1;
        }
        if(b.contains(".")){
            s = 1;
        }*/        
        a = var.getValue(a);
        b = var.getValue(b);
        System.out.print(a + " " + b + " ");
        switch(d){
            case 0: //add
               
                    add(Float.parseFloat(a), Float.parseFloat(b), c);
              
                break;
            case 1: //sub
                sub(Float.parseFloat(a), Float.parseFloat(b), c);
                break;
            case 2: //mul
                mul(Float.parseFloat(a), Float.parseFloat(b), c);
                break;
            case 3: //div
                div(Float.parseFloat(a), Float.parseFloat(b), c);
                break;
            case 4: //pow
                pow(Float.parseFloat(a), Float.parseFloat(b), c);
                break;
            case 5: //inc
                inc(c);
                break; 
            case 6: //dec
                dec(c);
                break;        
            case 7: //sqrt
                square(Float.parseFloat(a),c);
                break;
        }
        /*if(f == 0 && s == 0){
            add(Float.parseFloat(a), Float.parseFloat(b), c);
        }
        else if(f == 0 && s == 1){
            add(Float.parseFloat(a), Float.parseFloat(b), c);
        }
        else if(f == 1 && s == 0){
            add(Float.parseFloat(a), Float.parseFloat(b), c);
        }
        else if(f == 1 && s == 1){
            add(Float.parseFloat(a), Float.parseFloat(b), c);
        }*/
        
    }
    
    
    
    public void add(int a, int b, String c){        
        int x = a + b;
        var.storeToVar(c, Float.toString(x));
    }
     
    public void add(float a, float b, String c){
        float x = a + b;
        var.storeToVar(c, Float.toString(x));
    }
    /*
    public void add(int a, float b, String c){
        float x = a + b;
        storeToVar(c, Float.toString(x));     
    }   
    
    public void add(float a, int b, String c){
        float x = a + b;
        storeToVar(c, Float.toString(x));       
    }
    */      
    
    public void sub(float a, float b, String c){        
        float x = a - b;
        var.storeToVar(c, Float.toString(x));
    }
    
    public void mul(float a, float b, String c){        
        float x = a * b;
        var.storeToVar(c, Float.toString(x));
    }
    
    public void div(float a, float b, String c){        
        float x = a / b;           
        var.storeToVar(c, Float.toString(x));
    }
    public void pow(float base, float exponent, String c) //
    {
        if (exponent > 0) {
            var.storeToVar(c, Float.toString(base * Pow(base, exponent - 1)));
    /*} else if (exponent < 0) {                                    //stackoverflow disagree
            return ((1 / (basis * Pow(basis, exponent + 1))));      //only works for positive exponent
    */  }
        else if(exponent < 0){
            var.storeToVar(c, Float.toString(1/Pow(base, -exponent)));
        } 
        else {
            var.storeToVar(c, "1");
        }
    }
    
    public float Pow(float base, float exponent){
        if (exponent > 0) {
            return (base * Pow(base, exponent - 1));
    /*} else if (exponent < 0) {                                    //stackoverflow disagree
            return ((1 / (basis * Pow(basis, exponent + 1))));      //only works for positive
    */  }
        else if(exponent < 0){
            return (1/Pow(base, -exponent));} 
        else {
            return 1;
        }
    }
    
    public void inc(String c){        
        float x = Float.parseFloat(var.getValue(c));
        x++;
        var.storeToVar(c, Float.toString(x));
    }
     
    public void dec(String c){        
        float x = Float.parseFloat(var.getValue(c));
        x--;          
        var.storeToVar(c, Float.toString(x));    
    }
     
    public void square(float a, String c){         
       var.storeToVar(c,Double.toString(Math.sqrt(a)));
    }  

    
    
}
