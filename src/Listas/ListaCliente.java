package Listas;

import sample.Cliente;

public class ListaCliente{
    int largo=0;
    Nodo<Cliente> head= null;


    public void addLast (Cliente e){
        if (this.head==null){
            this.head= new Nodo<Cliente>(e);
            largo++;
        }
        else {
            Nodo tmp= this.head;
            while (tmp.next!= null) {
                tmp = tmp.next;
            }
            tmp.next=new Nodo<Cliente>(e);
            largo++;
        }
    }
    public Cliente buscar (int n){
        Nodo<Cliente>tmp=this.head;
        while (n>0){
            tmp=tmp.next;
            n--;
        }
        return tmp.getNodo();
    }


    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }
}
