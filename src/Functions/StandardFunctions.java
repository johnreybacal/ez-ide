/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import javax.swing.JOptionPane;
import static virtual.machine.Variables.*;
import virtual.machine.Variables;

/**
 *
 * @author knighty03
 */
public class StandardFunctions {
    
    Variables var = new Variables();
    
    public StandardFunctions(){
        System.out.println("Standard Functions Library loaded");
    }
    
    public String say(String sayValue){
        String varName = "$";        
        String output = "";
        try{
            for(int x=0;x<sayValue.length();x++){                        
                if(sayValue.charAt(x) == '$'){                                            
                    for(int y=x+1;y<sayValue.length();y++){
                        if(Character.isWhitespace(sayValue.charAt(y)) || sayValue.charAt(y)=='$'){
                            break;
                        }
                        else
                            varName += sayValue.charAt(y);                            
                    }                
                    output += var.getValue(varName);               
                    x += varName.length() - 1;
                    varName = "$";                
                }
                /*if(isTemp){
                    if(sayValue.charAt(x) == 'n'){
                        output += "\n";
                    }
                    if(sayValue.charAt(x) == 't'){
                        output += "\t";
                    }
                    else{
                        output += temp;                    
                    }
                    isTemp = false;
                    continue;
                }
                if(sayValue.charAt(x) == '\\'){
                    temp = "\\";
                    isTemp = true;                
                }*/
                else
                    output += sayValue.charAt(x);
            }
        }catch(Exception e){
            virtual.machine.Errors err = new virtual.machine.Errors();
            err.hasError();
            return "<html><font color = \"red\">Variable might not have been declared</font></html>"; 
        }
        return output + "\n";
    }
    
    public String get(String getValue){
        int ix = intRange.pop(); //last address
        int iy = intRange.pop(); //start address
        int px = phraseRange.pop(); //last address
        int py = phraseRange.pop(); //start address
        int dx = decimalRange.pop(); //last address
        int dy = decimalRange.pop(); //start address
        intRange.push(iy);
        intRange.push(ix);
        phraseRange.push(py);
        phraseRange.push(px);
        decimalRange.push(dy);
        decimalRange.push(dx);
        String value = JOptionPane.showInputDialog("Input value of "+getValue);        
        for(int y=iy;y<ix;y++){
            if(getValue.equals(intIdentifier[y])){                            
                intValue[y] = Integer.parseInt(value);
            }
        }
        for(int y=dy;y<dx;y++){
            if(getValue.equals(decimalIdentifier[y])){                            
                decimalValue[y] = Float.parseFloat(value);
            }
        }
        for(int y=py;y<px;y++){
            if(getValue.equals(phraseIdentifier[y])){                            
                phraseValue[y] = value;
            }
        }
        for(int y=0;y<gi;y++){
            if(getValue.equals(globalII[y])){                            
                globalIV[y] = Integer.parseInt(value);
            }
        }
        for(int y=0;y<gd;y++){
            if(getValue.equals(globalDI[y])){                            
                globalDV[y] = Float.parseFloat(value);
            }
        }
        for(int y=0;y<gp;y++){
            if(getValue.equals(globalPI[y])){                            
                globalPV[y] = value;
            }
        }                
        return value + "\n";
    }
    
    
}
