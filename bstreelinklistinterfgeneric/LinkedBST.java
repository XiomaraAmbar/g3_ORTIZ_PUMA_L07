package bstreelinklistinterfgeneric;

import BSTree.Nodo;
import Excepciones.ExceptionIsEmpty;
import Excepciones.ItemDuplicated;
import Excepciones.ItemNotFound;
import bstreeInterface.BinarySearchTree;

public class LinkedBST<E> extends BinarySearchTree<E> {
    private Nodo<E> root;

    public LinkedBST(){
        this.root = null;
    }

    public void insert(E data) throws ItemDuplicated {

    }

    public void delete(E data) throws ExceptionIsEmpty{

    }

    public E search(E data) throws ItemNotFound{

    }

    public String toString(){

    }

}
