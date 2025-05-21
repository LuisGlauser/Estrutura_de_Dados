import javax.swing.JOptionPane;

// @author Luís Glauser & Matheus Cuero

public class Exercicio {
    public static void main(String[] args) {
        // 1. Define Pedido class:
        // - id, cliente, itens, status, pilha de etapas

        // 2. Criar estrutura de dados:
        // - FilaPedidos (Fila)
        // - ListaPedidosEmPreparo (Lista Encadeada)
        // - Etapas (Pilha)

        // 3. GUI: JFrame principal com botões:
        // - Novo Pedido → adiciona na Fila
        // - Aceitar Pedido → move da Fila para Lista
        // - Adicionar Etapa → adiciona na Pilha do pedido
        // - Desfazer Etapa → desempilha
        // - Finalizar Pedido → remove da Lista, mostra etapas
        // - Ver Pedidos Ativos → mostra Lista
        // - Consultar Histórico → mostra etapas
        // - Reencaminhar Finalizado → volta à Fila

        // 4. Criar classes para Fila, Lista, Pilha (suas próprias implementações)
        pilha p = new pilha(5); // para Testes
        pilha etapas = new pilha(5); // para armazenar as etapas de preparação do pedido
        String[] pedido = new String[5];
        pedido[] filaPedidos = new pedido[100];
        Fila emFila = new Fila(5);
        ListaEncadeada emPreparo = new ListaEncadeada();
        ListaEncadeada finalizados = new ListaEncadeada();
        IntNoSimples no;
        int valor, id = 0, fimFila = 0;
        int opção;
        do {
            opção = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao sistema de gerenciamento de pedidos!\n" +
                    "Selecione uma opção no menu para começar.\n" +
                    "1. Novo Pedido\n" +
                    "2. Aceitar Pedido\n" +
                    "3. Adicionar Etapa\n" +
                    "4. Desfazer Etapa\n" +
                    "5. Finalizar Pedido\n" +
                    "6. Ver Pedidos Ativos\n" +
                    "7. Consultar Histórico\n" +
                    "8. Sair"));
            switch (opção) {
                case 1:
                    
                    // String IdPedido = String.valueOf(id);
                    // id++;
                    // String cliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    // String itens = JOptionPane.showInputDialog("Digite os itens do pedido:");
                    // String status = "Na fila";
                    // String historico = "";

                    // pedido[0] = IdPedido;
                    // pedido[1] = cliente;
                    // pedido[2] = itens;
                    // pedido[3] = status;
                    // pedido[4] = historico;

                    // p.empilhar(pedido);

                    // Novo Pedido
                    // Adicionar pedido à fila
                    
                    // l: Tambem funcionando, porém usa uma classe que criamos, me pergunto se o professor vai
                    // permitir isso, perguntar pra ele quinta

                    // funcionando 
                    String idPedido = String.valueOf(id++);
                    String cliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    String itens = JOptionPane.showInputDialog("Digite os itens do pedido:");
                    pedido novo = new pedido(idPedido, cliente, itens, "Na fila", "");
                    filaPedidos[fimFila++] = novo;
                    JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso!\n" + novo);
                    emFila.enfileirar(Integer.parseInt(idPedido));
                    break;
                case 2:
                    // Aceitar Pedido
                    // Mover pedido da fila para a lista

                    // l: Se não ouver nada em preparo ele permite aceitar um pedido, oq faz ele guardar um valor da fila,
                    // ele insere esse valor no "Em preparo" e avisa o usuario, se não ele diz pra terminar o anterior
                    if (emPreparo.equals(null)) {
                        int temp_valor = Integer.parseInt(emFila.desenfileirar());
                        emPreparo.insereNo_inicio(new IntNoSimples(temp_valor)); //Tira da Fila de Espera e bota na Fila de preparo
                        JOptionPane.showMessageDialog(null,"Iniciado o preparo do pedido "+temp_valor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Um pedido está em produção, finalize-o primeiro antes de aceitar outro");
                    }
                    
                    break;
                case 3:
                    // l: Tá daora, precisamos só verificar se vai conectar ele ao pedido ou se vai acontecer apenas um pedido
                    // por vez
                    // Adicionar Etapa
                    // Adicionar etapa à pilha do pedido
                    String etapa = JOptionPane.showInputDialog("Informe a etapa do Preparo:");
                    if (!etapas.cheia()) {
                        etapas.empilhar(etapa);
                    } else {
                        JOptionPane.showMessageDialog(null, "Excedeu o limite de etapas");
                    }

                    break;
                case 4:
                    // l: Está Funcionando, mas não sei se precisa conectar diretamente com o pedido. Tambem seria bom fazer ele por dentro do historico do pedido dps
                    // m: olha lá em baixa, pedido é um objeto, então não sei se precisa fazer assim
                    // l: Eu n entendi mt como funfa o pedido ali, ele armazena algo? eu tava pensando em fazer algo na hora de inserir tipo:
                    // string histotico += ", "+p.desempilhar
                    // ai acho que armazena em lista as etapas de produção
                    // m: como tá como objeto n seria mais fácil fazer assim?
                    //  if (filaPedidos[i].status.equals("finalizado")) {
                    //        JOptionPane.showMessageDialog(null, "Pedido ativo:\n" + filaPedidos[i].toString());
                    
                    // l: tem como alterar as propriedades de cada pedido? tipo só o historico
                    // m: tem sim

                    // l: pelo que vi precisamos ser capazes de buscar o historiico especifico de um pedido
                    
                    // m: se for assim da pra fazer por um if
                    // Desfazer Etapa
                    // Desempilhar etapa
                    if (!etapas.vazia()) {
                        JOptionPane.showMessageDialog(null, "Etapa " + etapas.desempilhar() + " desfeita!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há etapas neste pedido.");
                    }

                    break;
                case 5:
                    // l: eu tava pensando e tem que criar 3 "filas" eu acho, emEspera, emPreparo, Finalizado
                    // essa etapa deve tirar um pedido da fila de preparo e por na finalizado, oque ela faz
                    // porem não sei como pega o valor do primeiro e uso ele pra excluir ele do emPreparo
                    // se não arrumar vai ficar duplicado nas duas listas

                    // m: a 6 faz isso, ela pega o primeiro pedido ativo
                    // l: interessante, ela da break quando encontra?
                    // m: nop, ele pega todos, mas da pra far um break
                    // l: acho q a 6 ñ precisa, mas daria pra adaptar na 5, creio que precisamos mudar pra pegar
                    // só o 1° item, ñ sei se a lista "emPreparo" precisa ter mais de um item, se precisar compl-
                    // -ica, pensei em quando finalizar o pedido fazer algo pra desempilhar e armazenar no pedido
                    // especifico
                    
                    // l: mano eu vou ir jantar e ja volto 
                    // m: acho q eu vou é dormir e vejo isso amanha, boa noite luisão
                    // l: é o esquema, boa noite mano 

                    // Finalizar Pedido
                    // Remover da lista e mostrar etapas
                    finalizados.insereNo_inicio(emPreparo.primeiro); // Aparentemente certo (Essa linha)
                    //int temp2 = emPreparo.primeiro;
                    //emPreparo.excluiNo(emPreparo.primeiro);
                    break;
                case 6:
                    // Ver Pedidos Ativos
                    // Mostrar lista de pedidos ativos
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Na fila")) {
                            JOptionPane.showMessageDialog(null, "Pedido ativo:\n" + filaPedidos[i].toString());
                        }
                    }
                    
                    break;
                case 7:
                    // Consultar Histórico
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Finalizado")) {
                            JOptionPane.showMessageDialog(null, "Pedido ativo:\n" + filaPedidos[i].toString());
                        }
                    }
                    // Mostrar etapas do pedido finalizado
                    break;
                case 8:
                    // l: esse 8 pega o id da reclamação perguntando pro usuario, depois vê se
                    // ele existe, se sim ele bota ele denovo na fila de espera (talvez de pra
                    // incrementar uma prioridade) e apaga ele da fila de finalizados. se não 
                    // ele avisa que não tem

                    // Reencaminhar pedido finalizado para a fila (ex: reclamação do cliente)
                    int reclamacao = Integer.parseInt(JOptionPane.showInputDialog("Informe o Id do pedido para ser refeito"));
                    if (finalizados.buscaNo(reclamacao) != null) {
                        emFila.enfileirar(reclamacao);
                        finalizados.excluiNo(reclamacao);
                        JOptionPane.showMessageDialog(null, "Pedido colocado em fila novamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "O Pedido de ID "+reclamacao+" não existe / foi finalizado");
                    }
                    
                    break;
                case 9:
                    // Sair
                    JOptionPane.showMessageDialog(null, "Encerrando programa. Obrigado pela preferência!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opção != 9);

    }
    public static class pedido {
        String id;
        String cliente;
        String itens;
        String status;
        String historico;

        public pedido(String id, String cliente, String itens, String status, String historico) {
            this.id = id;
            this.cliente = cliente;
            this.itens = itens;
            this.status = status;
            this.historico = historico;
        }

        public String toString() {
            return "ID: " + id + "\nCliente: " + cliente + "\nItens: " + itens + "\nStatus: " + status + "\nHistórico: "
                    + historico;
        }

    }

}
