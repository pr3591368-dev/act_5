
package com.mycompany.linkedlist;

import java.util.Iterator;

public class LinkedList {

    public static void main(String[] args) {

        // Instanciación de objetos de prueba
        Alumnito alumn1 = new Alumnito("Brianda", 25, "216578", 10.00);
        Alumnito alumn2 = new Alumnito("Leyen", 25, "216677", 10.00);
        Alumnito alumn3 = new Alumnito("Marco", 50, "002121", 9.00);
        Alumnito alumn4 = new Alumnito("Irma", 25, "235689", 10.00);
        Alumnito alumn5 = new Alumnito("Mateo", 23, "262847", 10.00);

        ListaEnlazada<Alumnito> lista = new ListaEnlazada<>();
        lista.insert(alumn1, 0); 
        lista.insert(alumn2, 1); 
        lista.insert(alumn3, 1); 
        lista.insert(alumn4, 0);
        System.out.println("Lista tras inserciones: " + lista);
        System.out.println("Cantidad de nodos en la lista: " + lista.size());
        Alumnito elementoObtenido = lista.get(2);
        System.out.println("Elemento en el indice 2: " + elementoObtenido);
        Alumnito elementoRemovido = lista.remove(1);
        System.out.println("Elemento removido del indice 1: " + elementoRemovido);
        System.out.println("Lista resultante: " + lista);
        System.out.println("Nuevo tamaño: " + lista.size());
        System.out.println("Lista antes de invertir: " + lista);
        lista.invertir();
        System.out.println("Lista despues de invertir: " + lista);
        ListaEnlazada<Alumnito> otraLista = new ListaEnlazada<>();
        otraLista.insert(alumn5, 0);
        System.out.println("Segunda lista: " + otraLista);
        lista.concatenar(otraLista);
        System.out.println("Lista concatenada: " + lista);
        System.out.println("Tamaño total tras concatenacion: " + lista.size());
        System.out.println("\n--- Recorrido usando Iterator ---");
        Iterator<Alumnito> iterator = lista.iterator();
        while (iterator.hasNext()) {
            System.out.println(" -> " + iterator.next());
        }
        lista.clear();
        System.out.println("Lista tras clear: " + lista);
        System.out.println("Tamaño tras clear: " + lista.size());
    }
}