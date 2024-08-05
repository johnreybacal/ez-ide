/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.machine;
import static GUI.RunProgram.*;

/**
 *
 * @author AJPiquero
 */
public class Errors {
    public static boolean error;

    public Errors() {
        error = false;
    }
    
    public void hasError(){
        error = true;
        IP = Compiler.endline;
    }
    
}
