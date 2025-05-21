import javax.swing.*;

public class VerificadorBalanceamento {
    public void estaBalanceado(String palavra){
        Pilha p = new Pilha(palavra.length());
        boolean balanceado = true;

        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                p.empilhar(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (p.vazia()) {
                    balanceado = false;
                    break;
                }

                char topo = (char) p.desempilhar();
                if ((c == ')' && topo != '(') ||
                        (c == '}' && topo != '{') ||
                        (c == ']' && topo != '[')) {
                    balanceado = false;
                    break;
                }
            }
        }
        if (!p.vazia()) {
            balanceado = false;
        }

        if (balanceado) {
            JOptionPane.showMessageDialog(null, "A sequência está balanceada.");
        } else {
            JOptionPane.showMessageDialog(null, "A sequência NÃO está balanceada.");
        }
    }
}
