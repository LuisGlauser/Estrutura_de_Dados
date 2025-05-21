/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1brunaluis;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author 0031432512011
 */
public class Exercicio1BrunaLuis {
    public static void main(String[] args) {
        VerificadorPalindromo vp = new VerificadorPalindromo();
        vp.ehPalindromo(JOptionPane.showInputDialog("Informe a palavra"));
    }
    
}
