package com.mycompany.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaEnlazada<T> implements IList<T>, Iterable<T> {

    protected NodoSimple<T> inicio;
    protected int nElementos;

    public ListaEnlazada() {
        inicio = null;
        nElementos = 0;
    }

    private static class NodoSimple<T> {

        private T dato;
        private NodoSimple<T> sig;

        public NodoSimple(T dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    private class ListIterator<T> implements Iterator<T> {

        private NodoSimple<T> nodoActual;

        public ListIterator(NodoSimple<T> inicio) {
            nodoActual = inicio;
        }

        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista.");
            }
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }

    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        NodoSimple<T> nodo = inicio;

        if (nodo == null) {
            inicio = nodoNuevo;
        } else {
            while (nodo.sig != null) {
                nodo = nodo.sig;
            }
            nodo.sig = nodoNuevo;
        }

        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de limites: " + index);
        }

        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);

        if (index == 0) {
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> nodo = inicio;

            for (int j = 0; j < index - 1; j++) {
                nodo = nodo.sig;
            }

            nodoNuevo.sig = nodo.sig;
            nodo.sig = nodoNuevo;
        }

        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites: " + index);
        }

        T removed;

        if (index == 0) {
            removed = inicio.dato;
            inicio = inicio.sig;
        } else {
            NodoSimple<T> nodo = inicio;
            for (int j = 0; j < index - 1; j++) {
                nodo = nodo.sig;
            }
            removed = nodo.sig.dato;
            nodo.sig = nodo.sig.sig;
        }
        nElementos--;
        return removed;
    }

    public void invertir() {
        NodoSimple<T> anterior = null;
        NodoSimple<T> actual = inicio;

        while (actual != null) {
            NodoSimple<T> siguiente = actual.sig;
            actual.sig = anterior;
            anterior = actual;
            actual = siguiente;
        }

        inicio = anterior;
    }

    public void concatenar(ListaEnlazada<T> otraLista) throws ListException {
        if (otraLista == null || otraLista.empty()) {
            return;
        }

        NodoSimple<T> nodo = otraLista.inicio;

        while (nodo != null) {
            append(nodo.dato);
            nodo = nodo.sig;
        }
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        NodoSimple<T> nodo = inicio;

        if (Objects.equals(nodo.dato, elemento)) {
            inicio = inicio.sig;
            nElementos--;
            return true;
        }

        while (nodo.sig != null) {
            if (Objects.equals(nodo.sig.dato, elemento)) {
                nodo.sig = nodo.sig.sig;
                nElementos--;
                return true;
            }
            nodo = nodo.sig;
        }

        return false;
    }

    @Override
    public int indexOf(T elemento) {
        NodoSimple<T> nodo = inicio;
        int index = 0;

        while (nodo != null) {
            if (Objects.equals(nodo.dato, elemento)) {
                return index;
            }
            nodo = nodo.sig;
            index++;
        }

        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites: " + index);
        }

        NodoSimple<T> nodo = inicio;
        for (int j = 0; j < index; j++) {
            nodo = nodo.sig;
        }
        return nodo.dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites: " + index);
        }

        NodoSimple<T> nodo = inicio;

        for (int j = 0; j < index; j++) {
            nodo = nodo.sig;
        }

        nodo.dato = elemento;
    }

    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        return inicio == null;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoSimple<T> nodo = inicio;
        while (nodo != null) {
            sb.append(nodo.dato != null ? nodo.dato.toString() : "null");
            if (nodo.sig != null) {
                sb.append(", ");
            }
            nodo = nodo.sig;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(inicio);
    }
}