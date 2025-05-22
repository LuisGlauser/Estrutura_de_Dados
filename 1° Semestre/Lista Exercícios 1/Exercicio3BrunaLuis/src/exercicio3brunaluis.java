import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercicio3brunaluis {
    public static void main(String[] args) {
        conversorDecimalParaBinario cb = new conversorDecimalParaBinario();
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o Numero para ser convertido"));
        cb.converterParaBinario(numero);
    }
}