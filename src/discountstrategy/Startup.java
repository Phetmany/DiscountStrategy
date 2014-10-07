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
public class Startup {
    public static void main(String[] args) {
        Register register = new Register();
        
        register.startNewSale("A0001", new FakeDatabase(), new ReceiptConsoleOutput());
        register.addItem("P0001", 2);
        register.endSale();
    }
}
