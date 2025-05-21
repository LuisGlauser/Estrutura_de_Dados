public class FilaString {
    int tamanho;
    int inicio;
    int fim;
    int total;
    String vetor[];

    public FilaString(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new String[tam];
    }

    public boolean vazia() {
        return total == 0;
    }

    public boolean cheia() {
        return total >= tamanho;
    }

    public void enfileirar(String elem) {
        if (!cheia()) {
            vetor[fim] = elem;
            fim = (fim + 1) % tamanho;
            total++;
        } else {
            System.out.println("Fila Cheia");
        }
    }

    public String desenfileirar() {
        if (!vazia()) {
            String elem = vetor[inicio];
            inicio = (inicio + 1) % tamanho;
            total--;
            return elem;
        } else {
            return "Fila vazia";
        }
    }

    public void exibeFila() {
        for (int i = 0; i < total; i++) {
            int index = (inicio + i) % tamanho;
            System.out.println("Posição " + index + " valor " + vetor[index]);
        }
    }
}

