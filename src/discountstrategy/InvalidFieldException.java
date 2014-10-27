/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author nok
 */
public class InvalidFieldException extends IllegalArgumentException {
    private static String msg = "Sorry, field cannot be null or zero length.";
    
    public InvalidFieldException() {
        super(msg);
    }

    public InvalidFieldException(String s) {
        super(msg);
    }
    
    public InvalidFieldException(String message, Throwable cause) {
        super(msg, cause);
    }
    
    public InvalidFieldException(Throwable cause) {
        super(msg, cause);
    }
}
