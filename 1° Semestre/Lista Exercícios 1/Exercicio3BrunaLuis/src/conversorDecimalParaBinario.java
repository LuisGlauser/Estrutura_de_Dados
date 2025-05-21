import javax.swing.*;

public class conversorDecimalParaBinario {

    public void converterParaBinario(int numero){
        int tamPilha = 0;
        int num = numero;
        int num2 = numero;

        while(num2 >= 1){
            if(num2%2 == 1){
                num2 = (num2-1)/2;
                tamPilha++;
            } else{
                num2 = num2/2;
                tamPilha++;
            }
        }

        Pilha p = new Pilha(tamPilha);
        while(numero >= 1){
            if (numero%2 == 1){
                numero = (numero-1)/2;
                p.empilhar(1);
            } else{
                numero = numero/2;
                p.empilhar(0);
            }
        }
        String bin;

        System.out.print("O Resultado da conversão do decimal "+num+" para binário é: ");
        p.ExibePilha();
    }
}
