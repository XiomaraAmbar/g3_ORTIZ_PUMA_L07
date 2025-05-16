package BSTree;

public class Nodo<E> {
    private E valor; //Información del nodo
    private Nodo<E> derecho; //Referencia a la rama derecha
    private Nodo<E> izquierdo; //Referencia a la rama izquierda

    //Constructor que inicializa la información del nodo con su valor y la referencia del
    //siguiente apunta a null
    public Nodo(E valor){
        this(valor, null, null);
    }
    public Nodo(E valor, Nodo<E> derecho, Nodo<E> izquierdo){
        this.valor = valor;
        this.derecho = derecho;
        this.izquierdo = izquierdo;
    }

    public E getValor(){
        return valor;
    } //Retorna valor o la información del nodo

    public void setValor(E valor){
        this.valor = valor;
    } //Modifica el valor del nodo

    public Nodo<E> getDerecho(){
        return derecho;
    } //Retorna la referencia del siguiente derecho de la raiz

    public void setDerecho(Nodo<E> siguiente){
        this.derecho = derecho;
    } //Modifica la referencia del siguiente derecho de la raiz

    public Nodo<E> getIzquierdo(){
        return izquierdo;
    } //Retorna la referencia del siguiente izquierdo de la raiz

    public void setIzquierdo(Nodo<E> siguiente){
        this.izquierdo = izquierdo;
    } //Modifica la referencia del siguiente izquierdo de la raiz
}