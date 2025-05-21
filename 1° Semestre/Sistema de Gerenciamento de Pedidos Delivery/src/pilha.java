


/**
 *
 * @author bruno
 */
public class pilha {
    private int topo;
    private int tamanho;
    private Object pilhaElem[];
    
    public pilha(int tam){
        topo = -1;
        tamanho = tam;
        pilhaElem = new Object[tam];
    }
    
    public boolean vazia(){
        if (topo == -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean cheia(){
        if (topo ==  tamanho -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void empilhar(Object elem){
        if(cheia() == true){
            System.out.println("A pilha está cheia!");
        }
        else{
            topo++;
            pilhaElem[topo]=elem;
        }
    }
    
    public Object desempilhar(){
        Object valorDesempilhado;
        if(vazia() == true){
            valorDesempilhado = "Pilha Vazia!";
        }
        else{
            valorDesempilhado = pilhaElem[topo];
            topo--;
        }
        return valorDesempilhado;
    }

}


