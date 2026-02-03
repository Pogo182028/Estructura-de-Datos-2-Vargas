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
        while (p.prox != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
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
}
