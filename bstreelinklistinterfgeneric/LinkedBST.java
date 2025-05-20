package bstreelinklistinterfgeneric;

import BSTree.Nodo;
import Excepciones.ExceptionIsEmpty;
import Excepciones.ItemDuplicated;
import Excepciones.ItemNotFound;
import bstreeInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E>{
    private Nodo<E> raiz;

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
    private E searchRecursivo(Nodo<E> nodoTemporal, E valor){
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
    Método de búsqueda privada para usarlo en insert y delete
     */
    private E searchInterno(E valor) {
        return searchRecursivo(raiz,valor);
    }

    //Agrega un elemento en el BST
    public void insert(E valor) throws ItemDuplicated{
        if (isEmpty()){
            raiz.setValor(valor);
        }
        else if (searchInterno(valor) != null){ //Busca si el elemento ya existe en el árbol
            throw new ItemDuplicated();
        }
        insertRecursivo(raiz, valor);
    }

    //Busca recursivamente el valor de un nodo en el árbol, e inserta el valor en el lugar correcto
    private void insertRecursivo(Nodo<E> nodoTemporal, E valor){
        Nodo<E> nuevoNodo = new Nodo <> (valor);

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

        else { //Si el valor a buscar es menor al nodoTemporal (raizTemporal)
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
        if (!(isEmpty())){

        }
    }

    //Muestra la cadena que contiene la información en el BST
    public String toString(){

    }

    //Recorridos del árbol según corresponda al recorrido.
    public void InOrder(){}
    public void PostOrder(){}
    public void PreOrder(){}

}