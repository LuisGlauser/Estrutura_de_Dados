import javax.swing.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercicio5brunaluis {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        int op = 0;
        while(op != 5){
            op = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção que deseja realizar:\n" +
                    "1 - Adicionar nomes a lista\n" +
                    "2 - Remover o nome do lista\n" +
                    "3 - Listar os nomes em ordem\n" +
                    "4 - Buscar se um nome está cadastrado\n" +
                    "5 - Sair"));
            switch (op){
                case 1:
                    String nomeAdd = JOptionPane.showInputDialog("Informe o nome a ser adicionado");
                    nomes.add(nomeAdd);
                    break;
                case 2:
                    String nomeRem = JOptionPane.showInputDialog("Informe o nome a ser removido da Lista");
                    nomes.remove(nomeRem);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, nomes.stream().toList());
                    break;
                case 4:
                    String nomeBuscar = JOptionPane.showInputDialog("Informe o nome a ser buscado");
                    if(nomes.contains(nomeBuscar)){
                        JOptionPane.showMessageDialog(null, nomeBuscar+" está presente na lista");
                    } else { JOptionPane.showMessageDialog(null, nomeBuscar+" não está presente na lista");}
                case 5:
                    break;
            }
        }
    }
}