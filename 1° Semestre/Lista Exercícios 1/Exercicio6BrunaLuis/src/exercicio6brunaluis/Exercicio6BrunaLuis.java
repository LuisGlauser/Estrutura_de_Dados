
package exercicio6brunaluis;
import javax.swing.JOptionPane;

/**
 *import java.util.Scanner;
import javax.swing.JOptionPane;
 * @author 0031432512011
 */
public class Exercicio6BrunaLuis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] matriz = new double[5][3];
        double[][] matriz2 = new double[5][1];
        double m1, m2, m3, m4, m5, maiorM, menorM;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da "
                        + (j+1) + "° prova do aluno "+(i+1)));
            }
        }
        m1 = (matriz[0][0]+matriz[0][1]+matriz[0][2])/3;
        m2 = (matriz[1][0]+matriz[1][1]+matriz[1][2])/3;
        m3 = (matriz[2][0]+matriz[2][1]+matriz[2][2])/3;
        m4 = (matriz[3][0]+matriz[3][1]+matriz[3][2])/3;
        m5 = (matriz[4][0]+matriz[4][1]+matriz[4][2])/3;
        
        for (int i = 0; i < 5; i++) {
            matriz2[i][0] = matriz[i][0]+matriz[i][1]+matriz[0][1];
        }
        
        maiorM = Math.max(m1, Math.max(m2, Math.max(m3, Math.max(m4, m5))));
        menorM = Math.min(m1, Math.min(m2, Math.min(m3, Math.min(m4, m5))));
        
        JOptionPane.showMessageDialog(null, "MÉDIA DOS ALUNOS: \n"
                + "A média do 1° aluno é: "+(matriz2[0][0]/3)+"\n"
                + "A média do 2° aluno é: "+(matriz2[1][0]/3)+"\n"
                + "A média do 3° aluno é: "+(matriz2[2][0]/3)+"\n"
                + "A média do 4° aluno é: "+(matriz2[3][0]/3)+"\n"
                + "A média do 5° aluno é: "+(matriz2[4][0]/3)+"\n");
        
        JOptionPane.showMessageDialog(null, "A Maior média é: "+maiorM
        +"\nA Menor média é: "+menorM);
        
        for (int i = 0; i < 5; i++) {
            if(matriz[i][0] >= 7.0){
                JOptionPane.showMessageDialog(null, "Aluno "+(i+1)+" APROVADO");
            } else{
                JOptionPane.showMessageDialog(null, "Aluno "+(i+1)+" REPROVADO");
            }
        }
        
        
  
        
    }

}
