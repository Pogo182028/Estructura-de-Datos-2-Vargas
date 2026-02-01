/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.examen_3_arboles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

/**
 *
 * @author MADITAS
 */

/*
    EXAMEN #3. ÁRBOL BINARIO DE BÚSQUEDA.

    Implementar los siguientes:

    1. Al menos 5 métodos de consulta sobre elementos de un ABB.
    2. Al menos 5 métodos con eliminar Nodos de un ABB.
    En algunos ejercicios utilizar: ArrayList, LinkedList.
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    // --------------------- Consultas ---------------------
    // Método #1
    public void insertar(int x) {
        raiz = insertar(x, raiz);
    }

    private Nodo insertar(int x, Nodo p) {
        if (p == null) {
            return new Nodo(x);
        }

        if (x < p.elem) {
            p.izq = insertar(x, p.izq);
        } else if (x > p.elem) {
            p.der = insertar(x, p.der);
        }

        return p;
    }

    // Método #2
    public int menor() {
        if (raiz == null) {
            return 0;
        }
        Nodo p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    // Método #3
    public int mayor() {
        if (raiz == null) {
            return 0;
        }
        Nodo p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        return p.elem;
    }

    // Método #4
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    // Método #5
    public ArrayList<Integer> Niveles() {
        ArrayList<Integer> L = new ArrayList<>();
        if (raiz == null) {
            return L;
        }

        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);

        while (!q.isEmpty()) {
            Nodo p = q.remove();
            L.add(p.elem);

            if (p.izq != null) {
                q.add(p.izq);
            }
            if (p.der != null) {
                q.add(p.der);
            }
        }
        return L;
    }

    // --------------------- ELIMINACIÓN ---------------------
    // Método #1
    public void eliminar(int x) {
        raiz = eliminar(x, raiz);
    }

    private Nodo eliminar(int x, Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.elem == x) {
            p = eliminarNodo(p);
        } else {
            if (x < p.elem) {
                p.izq = eliminar(x, p.izq);
            } else {
                p.der = eliminar(x, p.der);
            }
        }
        return p;
    }

    private Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        Nodo q = p.izq;
        while (q.der != null) {
            q = q.der;
        }
        p.elem = q.elem;
        p.izq = eliminar(q.elem, p.izq);
        return p;
    }

    // Método #2
    public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);
        if (p.izq == null && p.der == null) {
            return null;
        }
        return p;
    }

    // Método #3
    public void eliminarMenor() {
        if (raiz == null) {
            return;
        }
        Nodo p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        eliminar(p.elem);
    }

    // Método #4
    public void eliminarMayor() {
        if (raiz == null) {
            return;
        }
        Nodo p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        eliminar(p.elem);
    }

    // Método #5
    public void eliminarNivel(int n) {
        ArrayList<Integer> vals = new ArrayList<>();
        recolectarNivel(raiz, 0, n, vals);
        for (int x : vals) {
            eliminar(x);
        }
    }

    private void recolectarNivel(Nodo p, int nivelActual, int nivelObjetivo, ArrayList<Integer> vals) {
        if (p == null) {
            return;
        }
        if (nivelActual == nivelObjetivo) {
            vals.add(p.elem);
            return;
        }
        recolectarNivel(p.izq, nivelActual + 1, nivelObjetivo, vals);
        recolectarNivel(p.der, nivelActual + 1, nivelObjetivo, vals);
    }
}
