package edu.escuelaing.arep.app.model;

/**
 * Implementacion propia de LinkedList.
 * 
 * @author Andres Ricardo Martinez Diaz
 * @version 1.0
 */
public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    /**
     * Constructor
     */
    public LinkedList() {
    }

    // LINK METHODS.

    /**
     * Metodo para enlazar un nodo al inicio.
     * 
     * @param value El valor que ira dentro del nuevo nodo.
     */
    private void linkFirst(E value) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(value, null, f);
        if (f == null)
            last = newNode;
        else
            f.setPrev(newNode);

        first = newNode;
        size++;
    }

    /**
     * Metodo para enlazar un nodo al final.
     * 
     * @param value El valor que ira dentro del nuevo nodo.
     */
    private void linkLast(E value) {
        Node<E> ult = last;
        Node<E> newNode = new Node<>(value, ult, null);
        if (ult == null)
            this.first = newNode;
        else
            ult.setNext(newNode);

        last = newNode;
        size++;
    }

    /**
     * Metodo para enlazar un nodo y colocarlo antes de otro.
     * 
     * @param value Valor del nuevo nodo.
     * @param sigu  Nodo que ira despues del nuevo nodo.
     */
    private void linkBefore(E value, Node<E> sigu) {
        Node<E> ant = sigu.prev();
        Node<E> newNode = new Node<>(value, ant, sigu);
        sigu.setPrev(newNode);
        if (ant == null)
            first = newNode;
        else
            ant.setNext(newNode);
        ;
        size++;
    }

    // ADD METHODS.

    /**
     * Metodo para agregar un valor a la lista.
     * 
     * @param value Valor para agregar.
     */
    public void add(E value) {
        linkLast(value);
    }

    /**
     * Metodo para agregar un valor al comienzo de la lista.
     * 
     * @param value Valor o dato nuevo
     */
    public void addFirst(E value) {
        linkFirst(value);
    }

    /**
     * Metodo para agregar un valor al final de la lista.
     * 
     * @param value Valor o dato nuevo
     */
    public void addLast(E value) {
        linkLast(value);
    }

    /**
     * Metodo para agregar un dato nuevo en una posicion en especifico.
     * 
     * @param index Posicion donde se quiere agregar.
     * @param value Dato que quiere agregar.
     */
    public void add(int index, E value) {

        if (index == size) {
            linkLast(value);
        } else {
            linkBefore(value, searchNode(index));
        }

    }

    // GET METHODS

    /**
     * Metodo para obtener el valor del primer nodo.
     * 
     * @return Valor del dato guardado en el primer nodo.
     */
    public E getFirst() {
        return first.data();
    }

    /**
     * Metodo para obtener el valor del ultimo nodo.
     * 
     * @return Valor del ultimo nodo.
     */
    public E getLast() {
        return last.data();
    }

    /**
     * Metodo para obtener el tamaño de la lista enlazada.
     * 
     * @return Tamaño de la lista enlazada
     */
    public int size() {
        return size;
    }

    /**
     * Metodo para buscar un nodo por posicion.
     * 
     * @param index Posicion del nodo que se quiere obtener.
     * @return Nodo correspondiente a la posicion.
     */
    private Node<E> searchNode(int index) {

        if (index >= 0 && index < this.size) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next();
            return x;
        } else if (index >= -size && index <= -1) {
            Node<E> x = last;
            for (int i = -1; i > index; i--) {
                x = x.prev();
            }
            return x;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Metodo para obtener el valor del nodo de cierta posicion.
     * 
     * @param index Posicion del nodo.
     * @return Valor almacenado en el nodo.
     */
    public E get(int index) {
        return searchNode(index).data();
    }

    // REMOVE

    /**
     * Metodo para borrar el enlace de un nodo de los demas.
     * 
     * @param node Nodo del que se quitaran los enlaces.
     * @return Dato dentro del nodo.
     */
    private E unLink(Node<E> node) {
        E data = node.data();
        Node<E> prev = node.prev();
        Node<E> next = node.next();
        node.setData(null);

        // First
        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        // Last
        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }
        size--;
        return data;
    }

    /**
     * Metodo para remover un nodo.
     * 
     * @param index Indice del nodo a remover.
     * @return valor del nodo removido.
     */
    public E remove(int index) {
        Node<E> dead = searchNode(index);
        return unLink(dead);
    }

    /**
     * Retorna la lista enlazada como cadena
     * @return La la informacion de la lista como cadena.
     */
	public String toString(){
        String lista = "[";
        Node<E> nodo = first;
        for (int i = 0; i < size-1; i++){
            lista += nodo.data() + "," ;
            nodo = nodo.next();
        }
        lista += last.data();
        lista += "]";
		return lista;
	}
    
}