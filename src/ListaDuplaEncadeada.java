
public class ListaDuplaEncadeada {
    private NoDuplo inicio;
    private NoDuplo fim;

    // Método construtor sem parâmetros (Objeto vazio)
    public ListaDuplaEncadeada() {
    }

    // Método construtor com parâmetros (Objeto já com os dados)
    public ListaDuplaEncadeada(NoDuplo inicio, NoDuplo fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    // Métodos de acesso aos atributos com escopo privado
    public NoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NoDuplo inicio) {
        this.inicio = inicio;
    }

    public NoDuplo getFim() {
        return fim;
    }

    public void setFim(NoDuplo fim) {
        this.fim = fim;
    }

    // Método para exibir os dados da Lista Duplamente Encadeada
    public void exibir() throws Exception {
        System.out.println("LISTA -> ");
        NoDuplo aux = inicio;
        while (aux != null) {
            System.out.print(aux.dado + " ");
            aux = aux.proximo;
        }
        System.out.println("NULL\n");
    }

    // Método para mostrar o tamanho da Lista
    public int tamanhoLista() throws Exception {
        NoDuplo aux = inicio;
        int tamanho = 0;
        while (aux != null) {
            tamanho++;
            System.out.println(aux.dado + " -> ");
            aux = aux.proximo;
        }
        return tamanho;
    }

    // Este método insere os dados na sequência, ou seja, no final da lista
    public void adicionar(String s) throws Exception {
        NoDuplo novoElemento = new NoDuplo(s);
        NoDuplo aux = inicio;
        if (inicio == null) {
            novoElemento.proximo = null;
            novoElemento.anterior = null;
            inicio = novoElemento;
            fim = novoElemento;
        } else {
            while (aux.proximo != null) {
                if (aux.dado.equals(s)) {
                    throw new Exception("Elemento repetido");
                }
                aux = aux.proximo;
            }
            if (aux.dado.equals(s)) {
                throw new Exception("Elemento repetido");
            }
            novoElemento.proximo = null;
            aux.proximo = novoElemento;
            novoElemento.anterior = aux;
            fim = novoElemento;
        }
    }

    // Método para INSERIR os dados na Lista Duplamente Encadeada em posição determinada
    public void adicionar(String s, int i) throws Exception {
        if (i < 0 || i > tamanhoLista()) {
            throw new Exception("Posição Inválida!");
        }
        NoDuplo novoElemento = new NoDuplo(s);
        NoDuplo aux = inicio;
        if (i == 0) {
            if (tamanhoLista() != 0) {
                novoElemento.proximo = aux;
                aux.anterior = novoElemento;
                inicio = novoElemento;
                novoElemento.anterior = null;
            } else {
                inicio = novoElemento;
                fim = novoElemento;
            }
        } else {
            int contador = 1;
            while (contador < i) {
                aux = aux.proximo;
                contador++;
            }
            novoElemento.proximo = aux.proximo;
            novoElemento.anterior = aux;
            if (aux.proximo != null) {
                aux.proximo.anterior = novoElemento;
            }
            aux.proximo = novoElemento;
            if (novoElemento.proximo == null) {
                fim = novoElemento;
            }
        }
    }

    // Método para remover elemento da Lista Encadeada por índice
    public String removeIndex(int i) throws Exception {
        NoDuplo aux = inicio;
        NoDuplo lixo = null;
        if (i < 0 || i >= tamanhoLista())
            throw new Exception("Indice inválido na Lista!");
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");

        if (i == 0) {
            lixo = aux;
            aux = aux.proximo;
            inicio = aux;
            if (inicio != null)
                inicio.anterior = null;
            else
                fim = null;
        } else {
            int contador = 0;
            while (contador < i) {
                aux = aux.proximo;
                contador++;
            }
            lixo = aux;
            aux.anterior.proximo = aux.proximo;
            if (aux != fim)
                aux.proximo.anterior = aux.anterior;
            else
                fim = aux.anterior;
        }
        return lixo.dado;
    }

    // Método para remover o elemento de acordo com o conteúdo
    public void removeElemento(String s) throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        NoDuplo aux = inicio;
        boolean excluir = false;
        while (aux != null && !excluir) {
            if (aux.dado.equals(s)) {
                if (aux == inicio) {
                    inicio = inicio.proximo;
                    if (inicio != null)
                        inicio.anterior = null;
                    else
                        fim = null;
                    excluir = true;
                } else {
                    aux.anterior.proximo = aux.proximo;
                    if (aux != fim)
                        aux.proximo.anterior = aux.anterior;
                    else
                        fim = aux.anterior;
                    excluir = true;
                }
            }
            aux = aux.proximo;
        }
        if (!excluir)
            throw new Exception("O elemento não foi localizado na Lista");
    }

    // Método para mostrar o antecessor do elemento
    public String antecessor(String s) throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.dado.equals(s)) {
                if (aux == inicio) {
                    throw new Exception("Primeiro elemento da Lista não tem Antecessor!");
                } else {
                    return aux.anterior.dado;
                }
            }
            aux = aux.proximo;
        }
        throw new Exception("O elemento não foi localizado na Lista!");
    }

    // Método para buscar a posição do elemento na Lista
    public int posicao(String s) throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        NoDuplo aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (aux.dado.equals(s)) {
                return contador;
            }
            aux = aux.proximo;
            contador++;
        }
        throw new Exception("O elemento não foi localizado na Lista!");
    }

    // Método que retorna o valor do elemento de acordo com a posição
    public String BuscaPosicao(int i) throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        if (i < 0 || i >= tamanhoLista())
            throw new Exception("Indice inválido na Lista!");
        NoDuplo aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == i) {
                return aux.dado;
            }
            aux = aux.proximo;
            contador++;
        }
        return null;
    }

    // Método para retornar o primeiro elemento da Lista
    public String primeiroLista() throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        if (inicio != null)
            return inicio.dado;
        return null;
    }

    // Método para retornar o último elemento da Lista
    public String ultimoLista() throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        if (fim != null)
            return fim.dado;
        return null;
    }

    // Método para retornar o maior valor da Lista (ordem alfabética)
    public String maior() throws Exception {
        if (tamanhoLista() == 0)
            throw new Exception("A lista está vazia!");
        NoDuplo aux = inicio;
        String maiorVal = aux.dado;
        while (aux != null) {
            if (aux.dado.compareTo(maiorVal) > 0) {
                maiorVal = aux.dado;
            }
            aux = aux.proximo;
        }
        return maiorVal;
    }
}
