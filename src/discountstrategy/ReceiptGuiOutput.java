/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package discountstrategy;
import javax.swing.JOptionPane;
/**
 *
 * @author psent_000
 */
public class ReceiptGuiOutput implements ReceiptOutputStrategy {

    @Override
    public void printReceipt(String receipt) {
        JOptionPane.showMessageDialog(null, receipt);
    }

    @Override
    public void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
