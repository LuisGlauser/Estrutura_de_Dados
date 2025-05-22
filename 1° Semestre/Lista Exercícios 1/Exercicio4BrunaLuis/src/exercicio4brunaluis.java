import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercicio4brunaluis {
    public static void main(String[] args) {
        FilaAtendimento f = new FilaAtendimento();
        int op = 0;
        while(op != 3) {
            op = Integer.parseInt(JOptionPane.showInputDialog("Informe oque deseja fazer:\n" +
                    "1 - Adicionar Paciente\n" +
                    "2 - Chamar proximo paciente\n" +
                    "3 - Sair"));
            switch (op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Informe o nome do Paciente");
                    int prioridade = Integer.parseInt(JOptionPane.showInputDialog("Informe a prioridade do Paciente:\n" +
                            "0 - Prioridade Normal\n" +
                            "1 - Prioridade Alta"));
                    f.adicionarPaciente(nome, prioridade);
                    break;
                case 2:
                    f.chamarProximo();
                    break;
                case 3:
                    break;
            }
        }
    }
}