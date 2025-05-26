import java.util.ArrayList;

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
         // para armazenar as etapas de preparação do pedido
        Fila emFila = new Fila(Integer.parseInt(JOptionPane.showInputDialog("Qual o número máximo de pedidos na fila?")));
        pilha etapas = new pilha(Integer.parseInt(JOptionPane.showInputDialog("Qual a maior quantidade de etapas que seu restaurante faz?")));
        Pedido[] filaPedidos = new Pedido[100];
        String regex = "^[0-9]+$", temp_Opcao; // Regex para validar números inteiros

        ListaEncadeada emPreparo = new ListaEncadeada();
        ListaEncadeada finalizados = new ListaEncadeada();
        IntNoSimples no;
        int id = 0, fimFila = 0;
        int opção = 0;

        boolean opcaoValida = false;
        do {
            do{ // checa se a opção é um numero inteiro
                temp_Opcao = JOptionPane.showInputDialog("Bem vindo ao sistema de gerenciamento de pedidos!\n" +
                        "Selecione uma opção no menu para começar.\n" +
                        "1. Novo Pedido\n" +
                        "2. Aceitar Pedido\n" +
                        "3. Adicionar Etapa\n" +
                        "4. Desfazer Etapa\n" +
                        "5. Finalizar Pedido\n" +
                        "6. Ver Pedidos Ativos\n" +
                        "7. Consultar Histórico\n" +
                        "8. Reencaminhar Pedido Finalizado\n" +
                        "9. Sair");
                        if (temp_Opcao.matches(regex)) {
                            opção = Integer.parseInt(temp_Opcao);
                            opcaoValida = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insira somente números inteiros!");
                            opcaoValida = false;
                        }
            }while(!opcaoValida);
            
            switch (opção) {
                case 1:
                    // Novo Pedido
                    // Adicionar pedido à fila
                    int idPedido = id++;
                    String cliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    String itens = JOptionPane.showInputDialog("Digite os itens do pedido:");
                    Pedido novo = new Pedido(idPedido, cliente, itens, "Na fila", "");
                    filaPedidos[fimFila++] = novo;
                    JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso!\n" + novo);
                    emFila.enfileirar(idPedido);
                    break;
                case 2:
                    // Aceitar Pedido
                    // Mover pedido da fila para a lista
                    if (emFila.vazia()) {
                        JOptionPane.showMessageDialog(null, "Não há pedidos na fila para aceitar.");
                        break;
                    } else {
                        boolean pedidoEmPreparo = false;
                        for (int i = 0; i < fimFila; i++) {
                            if (filaPedidos[i].status.equals("Em preparo")) {
                                pedidoEmPreparo = true;
                                break;
                            }
                        }
                        if (pedidoEmPreparo) {
                            JOptionPane.showMessageDialog(null,
                                    "Já existe um pedido em preparo, finalize-o antes de aceitar outro.");
                            break;
                        } else {
                            for (int i = 0; i < fimFila; i++) {
                                if (filaPedidos[i].status.equals("Na fila")) {
                                    filaPedidos[i].status = "Em preparo";
                                    int temp_no = Integer.parseInt(emFila.desenfileirar());
                                    emPreparo.insereNo_inicio(new IntNoSimples(temp_no));
                                    JOptionPane.showMessageDialog(null, "Pedido aceito:\n" + filaPedidos[i].toString());
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    // Adicionar Etapa
                    // Adicionar etapa à pilha do pedido
                    boolean jaEmPreparoAdicionar = false;
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Em preparo")) {
                            jaEmPreparoAdicionar = true;
                        }
                    }

                    if(jaEmPreparoAdicionar){
                        String etapa = JOptionPane.showInputDialog("Informe a etapa do Preparo:");
                        if (!etapas.cheia()) {
                            etapas.empilhar(etapa);
                        } else {
                            JOptionPane.showMessageDialog(null, "Excedeu o limite de etapas");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aceite um pedido para inserir etapas");
                    }

                    break;
                case 4:
                    // Desfazer Etapa
                    // Desempilhar etapa
                    boolean jaEmPreparoAdicionarDesfazer = false;
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Em preparo")) {
                            jaEmPreparoAdicionarDesfazer = true;
                        }
                    }
                    
                    if(jaEmPreparoAdicionarDesfazer){
                        if (!etapas.vazia()) {
                            JOptionPane.showMessageDialog(null, "Etapa " + etapas.desempilhar() + " desfeita!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Não há etapas neste pedido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aceite um pedido para desfazer etapas");
                    }

                    break;
                case 5:
                    boolean pedidoFinalizado = false;

                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Em preparo")) {
                            if (etapas.vazia()) {
                                JOptionPane.showMessageDialog(null, "Informe uma etapa antes de finalizar o pedido");
                            } else {
                                filaPedidos[i].status = "Finalizado";
                                while (!etapas.vazia()) {
                                    String etapa_temp = etapas.desempilhar().toString();
                                    filaPedidos[i].historico += "\n- "+etapa_temp;
                                }
                                JOptionPane.showMessageDialog(null, "Pedido Finalizado:\n" + filaPedidos[i].toString());
                            }
                            pedidoFinalizado = true;
                            break; // Sai do loop após encontrar e finalizar o pedido
                        }
                    }

                    if (!pedidoFinalizado) {
                        JOptionPane.showMessageDialog(null, "Nenhum pedido está em preparo.");
                    }
                    break;
                case 6:
                    // Ver Pedidos Ativos
                    // Mostrar lista de pedidos ativos
                    boolean pedidoAtivo = false;
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].status.equals("Em preparo")) {
                            JOptionPane.showMessageDialog(null, "Pedido ativo:\n" + filaPedidos[i].toString());
                            pedidoAtivo = true;
                        }
                    }
                    if (!pedidoAtivo) {
                        JOptionPane.showMessageDialog(null, "Não há pedidos ativos.");
                    }

                    break;
                case 7:
                    // Consultar Histórico
                    boolean pedidoFinalizadoHistorico = false;
                    int pesquisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido para consultar o histórico:"));
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].id == pesquisa) {
                            JOptionPane.showMessageDialog(null, "Pedido ativo:\n" + filaPedidos[i].toString());
                            pedidoFinalizadoHistorico = true;
                        }
                    }
                    if (!pedidoFinalizadoHistorico) {
                        JOptionPane.showMessageDialog(null, "Não há pedidos finalizados.");
                    }
                    // Mostrar etapas do pedido finalizado
                    break;
                case 8:
                    // Reencaminhar pedido finalizado para a fila (ex: reclamação do cliente)
                    int temp = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido para aceitar:"));
                    boolean reclamacao = false;
                    for (int i = 0; i < fimFila; i++) {
                        if (filaPedidos[i].id == temp && filaPedidos[i].status.equals("Finalizado")) {
                            filaPedidos[i].status = "Na Fila";
                            
                            JOptionPane.showMessageDialog(null, "Pedido Reeintroduzido na fila:\n" + filaPedidos[i].toString());
                            break;
                        } else {
                            reclamacao = true;
                        }
                    }
                    if (!reclamacao) {
                        JOptionPane.showMessageDialog(null, "Pedido não encontrado ou já em preparo.");
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

    public static class Pedido {
        int id;
        String cliente, itens, status;
        String historico = "";

        Pedido() {
            this.id = 0;
            this.cliente = "Matheus";
            this.itens = "";
            this.status = null;
        }

        public Pedido(int id, String cliente, String itens, String status, String historico) {
            this.id = id;
            this.cliente = cliente;
            this.itens = itens;
            this.status = status;
            this.historico = historico;
        }

        public String toString() {
            return "ID: " + id + "\nCliente: " + cliente + "\nItens: " + itens + "\nStatus: " + status + "\nHistórico de Etapas: "
                    + historico;
        }
    }

}