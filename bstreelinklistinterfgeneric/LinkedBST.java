package bstreelinklistinterfgeneric;

import BSTree.NodoTree;
import Excepciones.ExceptionIsEmpty;
import Excepciones.ItemDuplicated;
import Excepciones.ItemNotFound;
import Excepciones.MensajeException;
import Stack.Nodo;
import Stack.Pila;
import bstreeInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E>{
    private NodoTree<E> raiz;

    public LinkedBST(){
        this.raiz = null;
    }

    //Elimina todos los elementos del BST dejándolo vacío
    public void destroy(){
        raiz = null; //Raiz esta vacía, árbol vacío
    }

    //Verifica si el BST está vacío
    public boolean isEmpty(){
        return raiz == null; //Si la raiz es null, el árbol esta vacío
    }

    //Busca un elemento en el BST
    public E search(E valor) throws ItemNotFound{
        E resultadoBusqueda = searchRecursivo(raiz,valor);
        if (resultadoBusqueda == null){
            throw new ItemNotFound();
        }
        return searchRecursivo(raiz,valor);
    }

    //Busca recursivamente el valor de un nodo en el árbol
    private E searchRecursivo(NodoTree<E> nodoTemporal, E valor){
        if(nodoTemporal == null){ return null; }

        int resultado = valor.compareTo(nodoTemporal.getValor());
        if (resultado > 0){ //Si el valor a buscar es mayor al nodoTemporal (raizTemporal)
            //Busca en la derecha(mayores)
            return searchRecursivo(nodoTemporal.getDerecho(),valor);
        }

        else if (resultado < 0){ //Si el valor a buscar es menor al nodoTemporal
            //Busca en la izquierda(menores)
            return searchRecursivo(nodoTemporal.getIzquierdo(),valor);
        }

        else{ //Si resultado es igual a 0
            //El nodoTemporal y el valor son iguales, es decir, encontró el valor en el BSTree
            return valor;
        }
    }

    /*
    Método de búsqueda privada para usarlo en insert
     */
    private E searchInterno(E valor) {
        return searchRecursivo(raiz,valor);
    }

    //Agrega un elemento en el BST
    public void insert(E valor) throws ItemDuplicated{
        if (isEmpty()){
            NodoTree<E> nuevoNodo = new NodoTree<>(valor);
            raiz = nuevoNodo;
        }
        else{
            //Busca si el elemento ya existe en el árbol
            if (searchInterno(valor) != null){
                throw new ItemDuplicated();
            }
            insertRecursivo(raiz, valor);
        }
    }

    //Busca recursivamente el valor de un nodo en el árbol, e inserta el valor en el lugar correcto
    private void insertRecursivo(NodoTree<E> nodoTemporal, E valor){
        NodoTree<E> nuevoNodo = new NodoTree<>(valor);

        int resultado = valor.compareTo(nodoTemporal.getValor());

        if (resultado > 0){ //Si el valor a buscar es mayor al nodoTemporal (raizTemporal)
            //Busca en la derecha(mayores)
            if(nodoTemporal.getDerecho() == null){ //Si el hijo derecho del nodo esta vacío, se inserta
                nodoTemporal.setDerecho(nuevoNodo);
            }
            else{
                insertRecursivo(nodoTemporal.getDerecho(),valor); //nodoTemporal = nodoTemporal.getDerecho();
            }
        }

        else {//Si el valor a buscar es menor al nodoTemporal (raizTemporal) (resultado < 0)
            //Busca en la izquierda(menores)
            if(nodoTemporal.getIzquierdo() == null){ //Si el hijo izquierdo del nodo esta vacío, se inserta
                nodoTemporal.setIzquierdo(nuevoNodo);
            }
            else{
                insertRecursivo(nodoTemporal.getIzquierdo(),valor); //nodoTemporal = nodoTemporal.getIzquierdo();
            }
        }
    }

    //Elimina un elemento en el BST
    public void delete(E valor) throws ExceptionIsEmpty{
        if (isEmpty()){
            throw new ExceptionIsEmpty();
        }
        deleteRecursivo(raiz, valor);
    }

    //Busca recursivamente el valor de un nodo en el árbol, y elimina el valor del lugar correcto
    private void deleteRecursivo(NodoTree<E> nodoTemporal, E valor){

        int resultado = valor.compareTo(nodoTemporal.getValor()); //Almacena el resultado de la comparación

        if (resultado > 0){ //Si el valor a buscar es mayor al nodoTemporal (raizTemporal)
            //Busca en la derecha(mayores)
            deleteRecursivo(nodoTemporal.getDerecho(),valor);
        }

        else if (resultado < 0){ //Si el valor a buscar es menor al nodoTemporal
            //Busca en la izquierda(menores)
            deleteRecursivo(nodoTemporal.getIzquierdo(),valor);
        }

        else{ //Si resultado es igual a 0
            //El nodoTemporal y el valor son iguales, es decir, encontró el valor en el BSTree

            //Caso 1: Si el nodo es una hoja, se elimina directamente
            nodoTemporal.getIzquierdo();
        }
    }

    /*
    Recorridos del árbol según corresponda al recorrido.
     */

    //Subárbol Izquierdo – Nodo (Raíz) – Subárbol Derecho
    public void InOrder() throws MensajeException{
        if(isEmpty()){
            throw new MensajeException("Árbol vacío, no hay elementos.");
        }
        System.out.print("InOrden: [");
        InOrdenRecursivo(raiz);
        System.out.println("]");
    }

    //Subárbol Izquierdo – Nodo (Raíz) – Subárbol Derecho
    public void InOrdenRecursivo(NodoTree<E> nodoTemporal){
        if (nodoTemporal != null) {
            //Recorre subárbol izquierdo
            PostOrdenRecursivo(nodoTemporal.getIzquierdo());

            //Visita la raíz (nodo actual)
            System.out.print(nodoTemporal.getValor() + " ");

            //Recorre subárbol derecho
            PostOrdenRecursivo(nodoTemporal.getDerecho());
        }
    }



    //Subárbol Izquierdo – Subárbol Derecho – Nodo (Raíz)
    public void PostOrden() throws MensajeException {
        if(isEmpty()){
            throw new MensajeException("Árbol vacío, no hay elementos.");
        }
        System.out.print("PostOrden: [");
        PostOrdenRecursivo(raiz);
        System.out.println("]");
    }

    //Subárbol Izquierdo – Subárbol Derecho – Nodo (Raíz)
    public void PostOrdenRecursivo(NodoTree<E> nodoTemporal){
        if (nodoTemporal != null) {
            //Recorre subárbol izquierdo
            PostOrdenRecursivo(nodoTemporal.getIzquierdo());

            //Recorre subárbol derecho
            PostOrdenRecursivo(nodoTemporal.getDerecho());

            //Visita la raíz (nodo actual)
            System.out.print(nodoTemporal.getValor() + " ");
        }
    }

    //Subárbol Izquierdo – Subárbol Derecho – Nodo (Raíz)
    public void PostOrdenPilas(NodoTree<E> nodoTemporal) throws Stack.MensajeException {
        Pila<E> postOrden = new Pila<>();

        postOrden.push(raiz.getValor());
        postOrden.push(nodoTemporal.getDerecho().getValor());
        postOrden.push(nodoTemporal.getIzquierdo().getValor());


    }



    //Nodo (Raíz) – Subárbol Izquierdo – Subárbol Derecho
    public void PreOrden() throws MensajeException{
        if(isEmpty()){
            throw new MensajeException("Árbol vacío, no hay elementos.");
        }
        System.out.print("PreOrden: [");
        PreOrdenRecursivo(raiz);
        System.out.println("]");
    }

    //Nodo (Raíz) – Subárbol Izquierdo – Subárbol Derecho
    public void PreOrdenRecursivo(NodoTree<E> nodoTemporal){
        if (nodoTemporal != null) {

            //Visita la raíz (nodo actual)
            System.out.print(nodoTemporal.getValor() + " ");

            //Recorre subárbol izquierdo
            PostOrdenRecursivo(nodoTemporal.getIzquierdo());

            //Recorre subárbol derecho
            PostOrdenRecursivo(nodoTemporal.getDerecho());
        }
    }

    //Muestra la cadena que contiene la información en el BST
    public String toString(){

    }
}