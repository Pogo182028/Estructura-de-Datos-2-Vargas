/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.examen_2_listas_encadenadas_dobles;

/**
 *
 * @author Admin
 */

/*
    EXAMEN #2. LISTAS DOBLEMENTE ENCADENADAS, Insertar y Eliminar. Implementar:
    
    1. Al menos 5 métodos con insertar y/o consultas.
    2. Al menos 5 métodos con eliminar.
    Implementar desde cero. Para comenzar, implementar los métodos base: 
        toString(), insertarIesimo(x, i), eliminarIesimo(i). 
    Luego, implementar 10 métodos adicionales sobre una, dos y tres Listas..
 */
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    @Override
    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    public boolean vacia() {
        return cantElem == 0;
    }

    public void insertarPrim(int x) {
        Nodo n = new Nodo(null, x, prim);
        if (vacia()) {
            prim = ult = n;
        } else {
            prim.ant = n;
        }
        prim = n;
        cantElem++;
    }

    public void insertarUlt(int x) {
        Nodo n = new Nodo(ult, x, null);
        if (vacia()) {
            prim = ult = n;
        } else {
            ult.prox = n;
        }
        ult = n;
        cantElem++;
    }

    public void insertarIesimo(int x, int i) {
        if (i <= 0) {
            insertarPrim(x);
            return;
        }
        if (i >= cantElem) {
            insertarUlt(x);
            return;
        }

        Nodo p = prim;
        for (int k = 0; k < i; k++) {
            p = p.prox;
        }
        Nodo ap = p.ant;

        Nodo n = new Nodo(ap, x, p);
        ap.prox = n;
        p.ant = n;
        cantElem++;
    }

    public void eliminarPrim() {
        if (vacia()) {
            return;
        }

        if (prim == ult) {
            prim = ult = null;
        } else {
            prim = prim.prox;
            prim.ant = null;
        }

        cantElem--;
    }

    public void eliminarUlt() {
        if (vacia()) {
            return;
        }

        if (prim == ult) {
            prim = ult = null;
        } else {
            ult = ult.ant;
            ult.prox = null;
        }

        cantElem--;
    }

    public void eliminarIesimo(int i) {
        if (i <= 0) {
            eliminarPrim();
            return;
        }
        if (i >= cantElem - 1) {
            eliminarUlt();
            return;
        }

        Nodo p = prim;
        for (int k = 0; k < i; k++) {
            p = p.prox;
        }

        p.ant.prox = p.prox;
        p.prox.ant = p.ant;
        cantElem--;
    }

    // 1. insertar o consultas
    // #1
    public void insertarLugarAsc(int x) {
        Nodo p = prim;
        int i = 0;
        while (p != null && p.elem < x) {
            p = p.prox;
            i++;
        }
        insertarIesimo(x, i);
    }

    // #2
    public void generarAsc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarLugarAsc(x);
        }
    }

    // #3
    public void insertarPrimNVeces(int x, int n) {
        for (int i = 0; i < n; i++) {
            insertarPrim(x);
        }
    }

    // #4
    public void insertarIesimo(Lista L2, int i) {
        Nodo p = L2.prim;
        int pos = i;
        while (p != null) {
            insertarIesimo(p.elem, pos);
            pos++;
            p = p.prox;
        }
    }

    // #5
    public void insertarIntercalado(Lista L2, Lista L3) {
        prim = ult = null;
        cantElem = 0;
        Nodo p = L2.prim;
        Nodo q = L3.prim;
        while (p != null || q != null) {
            if (p != null) {
                insertarUlt(p.elem);
                p = p.prox;
            }
            if (q != null) {
                insertarUlt(q.elem);
                q = q.prox;
            }
        }
    }

    // 2. Eliminar
    // #1 
    public void eliminarPrimNVeces(int n) {
        for (int i = 0; i < n; i++) {
            eliminarPrim();
        }
    }

    // #2
    public void eliminarIesimo(int i, int n) {
        for (int k = 0; k < n; k++) {
            eliminarIesimo(i);
        }
    }

    // #3
    public void eliminarTodo(int x) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem == x) {
                if (p == prim) {
                    eliminarPrim();
                } else if (p == ult) {
                    eliminarUlt();
                } else {
                    p.ant.prox = p.prox;
                    p.prox.ant = p.ant;
                    cantElem--;
                }
            }
            p = sig;
        }
    }

    // #4
    public void eliminarTodo(Lista L2) {
        for (Nodo p = L2.prim; p != null; p = p.prox) {
            eliminarTodo(p.elem);
        }
    }

    // #5
    public void eliminarTodo(Lista L2, Lista L3) {
        for (Nodo p = L2.prim; p != null; p = p.prox) {
            eliminarTodo(p.elem);
        }
        for (Nodo q = L3.prim; q != null; q = q.prox) {
            eliminarTodo(q.elem);
        }
    }

}
