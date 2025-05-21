/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1brunaluis;

import javax.swing.JOptionPane;

/**
 *
 * @author 0031432512011
 */
public class VerificadorPalindromo {
    public void ehPalindromo(String palavra){
       boolean palin = true;
       palavra = palavra.replace(" ", "");
       char[] c = palavra.toCharArray();
       Pilha p = new Pilha(c.length); 
       Pilha p2 = new Pilha(c.length);
       
       while(!p.cheia()){
           for (int i = 0; i < c.length; i++) {
               p.empilhar(c[i]);
           }
           for (int i = c.length-1; i >= 0; i--) {
               p2.empilhar(c[i]);
           }
       }
       
      
        for (int i = 0; i < c.length; i++) {
            if(p.desempilhar() == p2.desempilhar()) {

            } else {palin = false;}
        }
        
        if (palin) {
            JOptionPane.showMessageDialog(null, "A palavra é um Palíndromo");
        } else {JOptionPane.showMessageDialog(null, "A palavra não é um Palíndromo");}
        
        
       
       
    }
}
