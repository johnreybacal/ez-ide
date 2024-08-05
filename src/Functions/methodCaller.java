/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

/**
 *
 * @author knighty03
 */
public class methodCaller {
    
    PhraseFunctions pf = new PhraseFunctions();
    
    public static String phraseReturn = "";
    public static int integerReturn = 0;            
    
    public void call(String method, String value){
        switch(method){
            case ".length":
                System.out.println(value);
                integerReturn = pf.length(value);
                break;
        }
    }
    
    public int returnInteger(){
        return integerReturn;
    }
    
    public String returnPhrase(){
        return phraseReturn;
    }
}
