/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.machine;


/**
 *
 * @author knighty03
 */
public class ByteCodes {
    
    public static final short say = 0;
    public static final short get = 1;
    public static final short If = 2;
    public static final short Else = 3; 
    public static final short Endif = 4;
    public static final short Int = 5;    
    public static final short Phrase = 6;
    public static final short Add = 7; 
    public static final short Sub = 8; 
    public static final short Mul = 9; 
    public static final short Div = 10; 
    public static final short Function = 11; 
    public static final short Endfunc = 12; 
    public static final short Call = 13; 
    public static final short For = 14; 
    public static final short Endfor = 15;
    public static final short Pow = 16; 
    public static final short Comment = 17;
    public static final short Inc = 18; 
    public static final short Dec = 19; 
    public static final short Sqrt = 20;
    public static final short Decimal = 21;
    public static final short LineBreak = 22;
    public static final short Return = 23;
    public static final short Assign = 24;
    
    public static final String[] opcodes = {        
        "Say",          //0
        "Get",          //1
        "If",           //2
        "Else",         //3
        "Endif",        //4        
        "Integer",      //5  
        "Phrase",       //6
        "Add",          //7
        "Sub",          //8
        "Mul",          //9
        "Div",          //10
        "Function",     //11
        "Endfunc",      //12   
        "Call",         //13
        "For",          //14
        "Endfor",       //15
        "Pow",          //16
        "Comment:",     //17
        "Inc",          //18
        "Dec",          //19
        "Sqrt",         //20
        "Decimal",      //21
        "LineBreak",    //22
        "Return",       //23
        "Assign",       //24
    };
}
