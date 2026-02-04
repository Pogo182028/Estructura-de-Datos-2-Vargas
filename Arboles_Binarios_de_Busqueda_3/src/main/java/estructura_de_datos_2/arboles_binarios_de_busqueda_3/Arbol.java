/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class Arbol {

    private NodoABB raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(int x) {
        raiz = insertar(x, raiz);
    }

    private NodoABB insertar(int x, NodoABB p) {
        if (p == null) {
            return new NodoABB(x);
        }

        if (x < p.elem) {
            p.izq = insertar(x, p.izq);
        } else if (x > p.elem) {
            p.der = insertar(x, p.der);
        }

        return p;
    }

    private NodoABB eliminarNodo(NodoABB p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }

        NodoABB q = p.izq;
        while (q.der != null) {
            q = q.der;
        }
        p.elem = q.elem;
        p.izq = eliminar(q.elem, p.izq);
        return p;
    }

    // 1. A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
    public void eliminar(int x) {
        raiz = eliminar(x, raiz);
    }

    private NodoABB eliminar(int x, NodoABB p) {
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

    // 2. A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1 (nodos terminales).
    public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private NodoABB eliminarHojas(NodoABB p) {
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

    // 3. A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
    public void eliminarPares() {
        raiz = eliminarPares(raiz);
    }

    private NodoABB eliminarPares(NodoABB p) {
        if (p == null) {
            return null;
        }

        p.izq = eliminarPares(p.izq);
        p.der = eliminarPares(p.der);

        if (p.elem % 2 == 0) {
            p = eliminarNodo(p);
        }
        return p;
    }

    // 4. A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.
    public void eliminar(Lista L1) {
        if (L1 == null || L1.prim == null) {
            return;
        }

        Nodo p = L1.prim;
        while (p != null) {
            eliminar(p.elem);
            p = p.prox;
        }
    }

    // 5. A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.
    public void eliminarMenor() {
        if (raiz == null) {
            return;
        }

        NodoABB p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        eliminar(p.elem);
    }

    // 6. A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
    public void eliminarMayor() {
        if (raiz == null) {
            return;
        }

        NodoABB p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        eliminar(p.elem);
    }

    // 7. A1.eliminarNivel( n ) : Método que elimina los nodos del árbol A1 del nivel n.
    public void eliminarNivel(int n) {
        ArrayList<Integer> vals = new ArrayList<>();
        recolectarNivel(raiz, 0, n, vals);

        for (int x : vals) {
            eliminar(x);
        }
    }

    private void recolectarNivel(NodoABB p, int nivelActual, int nivelObjetivo, ArrayList<Integer> vals) {
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

    // 8. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
    // 8. 1. A1.contarHijosUnicos(): Devuelve la cantidad de nodos que tienen exactamente un hijo.
    public int contarHijosUnicos() {
        return contarHijosUnicos(raiz);
    }

    private int contarHijosUnicos(NodoABB p) {
        if (p == null) {
            return 0;
        }

        int c = contarHijosUnicos(p.izq) + contarHijosUnicos(p.der);

        if ((p.izq == null && p.der != null) || (p.izq != null && p.der == null)) {
            return c + 1;
        }
        return c;
    }

    // 8. 2. A1.esCompleto(): Devuelve true si el árbol es completo (todos los niveles llenos excepto posiblemente el último, llenado de izquierda a derecha).
    public boolean esCompleto() {
        if (raiz == null) {
            return true;
        }

        Queue<NodoABB> q = new LinkedList<>();
        q.add(raiz);
        boolean fin = false;

        while (!q.isEmpty()) {
            NodoABB p = q.remove();

            if (p.izq != null) {
                if (fin) {
                    return false;
                }
                q.add(p.izq);
            } else {
                fin = true;
            }

            if (p.der != null) {
                if (fin) {
                    return false;
                }
                q.add(p.der);
            } else {
                fin = true;
            }
        }
        return true;
    }

    // 8. 3. A1.contarRamas(): Devuelve la cantidad de ramas (caminos de raíz a hojas).
    public int contarRamas() {
        return contarRamas(raiz);
    }

    private int contarRamas(NodoABB p) {
        if (p == null) {
            return 0;
        }

        if (p.izq == null && p.der == null) {
            return 1;
        }

        return contarRamas(p.izq) + contarRamas(p.der);
    }

    // 8. 4. A1.esBalanceado(): Devuelve true si el árbol está balanceado (diferencia de alturas ≤ 1 en cada nodo).
    public boolean esBalanceado() {
        return esBalanceado(raiz) != -1;
    }

    private int esBalanceado(NodoABB p) {
        if (p == null) {
            return 0;
        }

        int izq = esBalanceado(p.izq);
        if (izq == -1) {
            return -1;
        }

        int der = esBalanceado(p.der);
        if (der == -1) {
            return -1;
        }

        if (Math.abs(izq - der) > 1) {
            return -1;
        }

        return 1 + Math.max(izq, der);
    }

    // 8. 5. A1.sumaCaminoMayor(): Devuelve la suma máxima desde la raíz hasta una hoja.
    public int sumaCaminoMayor() {
        return sumaCaminoMayor(raiz);
    }

    private int sumaCaminoMayor(NodoABB p) {
        if (p == null) {
            return 0;
        }

        if (p.izq == null && p.der == null) {
            return p.elem;
        }

        return p.elem + Math.max(
                sumaCaminoMayor(p.izq),
                sumaCaminoMayor(p.der)
        );
    }
}
