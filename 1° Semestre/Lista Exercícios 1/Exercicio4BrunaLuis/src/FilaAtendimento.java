public class FilaAtendimento {
    FilaString filaNormal = new FilaString(10);
    FilaString filaPrioritaria = new FilaString(10);
    int contadorPrioritario = 0;

    public void adicionarPaciente(String nome, int prioridade) {
        if (prioridade == 0) {
            filaNormal.enfileirar(nome);
            System.out.println("Paciente " + nome + " adicionado à fila normal.");
        } else if (prioridade == 1) {
            filaPrioritaria.enfileirar(nome);
            System.out.println("Paciente " + nome + " adicionado à fila prioritária.");
        } else {
            System.out.println("Prioridade inválida.");
        }
    }

    public void chamarProximo() {
        if (!filaPrioritaria.vazia() && contadorPrioritario < 2) {
            String nome = filaPrioritaria.desenfileirar();
            System.out.println("Chamando paciente prioritário: " + nome);
            contadorPrioritario++;
        } else if (!filaNormal.vazia()) {
            String nome = filaNormal.desenfileirar();
            System.out.println("Chamando paciente normal: " + nome);
            contadorPrioritario = 0;
        } else if (!filaPrioritaria.vazia()) {
            String nome = filaPrioritaria.desenfileirar();
            System.out.println("Chamando paciente prioritário: " + nome);
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
    }
}