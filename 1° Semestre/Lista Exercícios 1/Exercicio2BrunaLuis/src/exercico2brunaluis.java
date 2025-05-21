import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercico2brunaluis {
    public static void main(String[] args) {
        String op;
        do {
            VerificadorBalanceamento vp = new VerificadorBalanceamento();
            vp.estaBalanceado(JOptionPane.showInputDialog("Informe a palavra"));
            op = JOptionPane.showInputDialog("Deseja Continuar? S/N");
        }while (op.equals("S") || op.equals("s"));
    }
}