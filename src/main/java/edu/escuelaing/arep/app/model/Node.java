package edu.escuelaing.arep.app.model;

/**
 * Implementacion de un nodo.
 * @author Andres Ricardo Martinez Diaz
 * @version 1.0
 */
public class Node<E>{
    private E data;
    private Node<E> next;
    private Node<E> prev;

    /**
     * Contructor
     * @param value Valor del dato que sara guardado en el nodo.
     * @param prev Nodo anterior.
     * @param next Nodo  siguiente.
     */
    public Node(E value, Node<E> prev, Node<E> next) {
        this.data = value;
        this.next = next;
        this.prev = prev;
    }

    public E data(){
        return this.data;
    }

    public void setData(E value){
        this.data = value;
    }

    public Node<E> next(){
        return next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

    public Node<E> prev(){
        return prev;
    }

    public void setPrev(Node<E> prev){
        this.prev = prev;
    }
}