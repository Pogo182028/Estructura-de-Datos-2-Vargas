/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.tarea_arboles_binarios_de_busqueda_2;

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

    // 1. A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.
    public void generarElem(int n, int a, int b) {
        while (cantidad() < n) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertar(x);
        }
    }

    // 2. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
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

    // 3. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(NodoABB p) {
        if (p != null) {
            System.out.print(p.elem + " ");
            preOrden(p.izq);
            preOrden(p.der);
        }
    }

    // 4. A1.inorden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoABB p) {
        if (p == null) {
            return;
        }

        inOrden(p.izq);
        System.out.print(p.elem + " ");
        inOrden(p.der);
    }

    // 5. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(NodoABB p) {
        if (p != null) {
            postOrden(p.izq);
            postOrden(p.der);
            System.out.print(p.elem + " ");
        }
    }

    // 6. A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.
    public void niveles() {
        if (raiz == null) {
            return;
        }

        Queue<NodoABB> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoABB p = cola.remove();
            System.out.print(p.elem + " ");

            if (p.izq != null) {
                cola.add(p.izq);
            }
            if (p.der != null) {
                cola.add(p.der);
            }
        }
    }

    // 7. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void desc() {
        desc(raiz);
    }

    private void desc(NodoABB p) {
        if (p != null) {
            desc(p.der);
            System.out.print(p.elem + " ");
            desc(p.izq);
        }
    }

    // 8. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean seEncuentra(int x) {
        return seEncuentra(x, raiz);
    }

    private boolean seEncuentra(int x, NodoABB p) {
        if (p == null) {
            return false;
        }

        if (x == p.elem) {
            return true;
        }
        if (x < p.elem) {
            return seEncuentra(x, p.izq);
        }
        return seEncuentra(x, p.der);
    }

    // 9. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(NodoABB p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    // 10. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma() {
        return suma(raiz);
    }

    private int suma(NodoABB p) {
        if (p == null) {
            return 0;
        }
        return p.elem + suma(p.izq) + suma(p.der);
    }

    // 11. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor() {
        NodoABB p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    // 12. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor() {
        NodoABB p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        return p.elem;
    }

    // 13. A1.preoOrden(L1) : Método que encuentra en la lista L1, el recorrido de preOrden de los elementos del árbol A1.
    public void preOrden(Lista L1) {
        preOrden(raiz, L1);
    }

    private void preOrden(NodoABB p, Lista L1) {
        if (p != null) {
            L1.insertarUlt(p.elem);
            preOrden(p.izq, L1);
            preOrden(p.der, L1);
        }
    }

    // 14. A1.inOrden(L1) : Método que encuentra en la lista L1, el recorrido de inOrden de los elementos del árbol A1.
    public void inOrden(Lista L1) {
        inOrden(raiz, L1);
    }

    private void inOrden(NodoABB p, Lista L1) {
        if (p != null) {
            inOrden(p.izq, L1);
            L1.insertarUlt(p.elem);
            inOrden(p.der, L1);
        }
    }

    // 15. A1.postOrden(L1) : Método que encuentra en la lista L1, el recorrido de postOrden de los elementos del árbol A1.
    public void postOrden(Lista L1) {
        postOrden(raiz, L1);
    }

    private void postOrden(NodoABB p, Lista L1) {
        if (p != null) {
            postOrden(p.izq, L1);
            postOrden(p.der, L1);
            L1.insertarUlt(p.elem);
        }
    }

    // 16. A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles de los elementos del árbol A1.
    public void niveles(Lista L1) {
        if (raiz == null) {
            return;
        }

        Queue<NodoABB> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoABB p = cola.remove();
            L1.insertarUlt(p.elem);

            if (p.izq != null) {
                cola.add(p.izq);
            }
            if (p.der != null) {
                cola.add(p.der);
            }
        }
    }

    // 17. A1.mostrarNivel(): Método que muestra los elementos del árbol y el nivel en el que se encuentran. (Recorrer el árbol en cualquier orden)
    public void mostrarNivel() {
        if (raiz == null) {
            return;
        }

        Queue<NodoABB> qNodos = new LinkedList<>();
        Queue<Integer> qNivel = new LinkedList<>();

        qNodos.add(raiz);
        qNivel.add(0);

        while (!qNodos.isEmpty()) {
            NodoABB p = qNodos.remove();
            int niv = qNivel.remove();

            System.out.println(p.elem + " (nivel " + niv + ")");

            if (p.izq != null) {
                qNodos.add(p.izq);
                qNivel.add(niv + 1);
            }
            if (p.der != null) {
                qNodos.add(p.der);
                qNivel.add(niv + 1);
            }
        }
    }

    // 18. A1.sumarNivel(L1) : Método que encuentra en la Lista L1, de acumuladores por nivel L1. Cada elementos de la Lista de la posición i, es un acumulador de elementos del nivel i, del árbol A1.
    public void sumarNivel(Lista L1) {
        if (raiz == null) {
            return;
        }

        Queue<NodoABB> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int cantNivel = cola.size();
            int suma = 0;

            for (int i = 0; i < cantNivel; i++) {
                NodoABB p = cola.remove();
                suma += p.elem;

                if (p.izq != null) {
                    cola.add(p.izq);
                }
                if (p.der != null) {
                    cola.add(p.der);
                }
            }

            L1.insertarUlt(suma);
        }
    }

    // 19. A1.alturaMayor(): Método que devuelve la altura del árbol A1. (Altura es la máxima longitud de la raíz a un nodo hoja en el árbol)
    public int alturaMayor() {
        return alturaMayor(raiz);
    }

    private int alturaMayor(NodoABB p) {
        if (p == null) {
            return 0;
        }

        int izq = alturaMayor(p.izq);
        int der = alturaMayor(p.der);

        return 1 + Math.max(izq, der);
    }

    // 20. A1.alturaMenor(): Método que devuelve la menor altura del árbol A1.
    public int alturaMenor() {
        return alturaMenor(raiz);
    }

    private int alturaMenor(NodoABB p) {
        if (p == null) {
            return 0;
        }

        if (p.izq == null && p.der == null) {
            return 1;
        }
        if (p.izq == null) {
            return 1 + alturaMenor(p.der);
        }
        if (p.der == null) {
            return 1 + alturaMenor(p.izq);
        }

        return 1 + Math.min(alturaMenor(p.izq), alturaMenor(p.der));
    }

    // 21. A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
    public void mostrarTerm() {
        mostrarTerm(raiz);
    }

    private void mostrarTerm(NodoABB p) {
        if (p != null) {
            mostrarTerm(p.izq);
            if (p.izq == null && p.der == null) {
                System.out.print(p.elem + " ");
            }
            mostrarTerm(p.der);
        }
    }

    // 22. A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(NodoABB p) {
        if (p == null) {
            return 0;
        }

        if (p.izq == null && p.der == null) {
            return 1;
        }

        return cantidadTerm(p.izq) + cantidadTerm(p.der);
    }

    // 23. A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lIneal. (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(NodoABB p) {
        if (p == null) {
            return true;
        }

        if (p.izq != null && p.der != null) {
            return false;
        }

        return lineal(p.izq) && lineal(p.der);
    }

    // 24. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x) {
        if (!seEncuentra(x)) {
            return x;
        }

        NodoABB p = raiz;
        int sup = x;

        while (p != null) {
            if (x < p.elem) {
                sup = p.elem;
                p = p.izq;
            } else {
                p = p.der;
            }
        }
        return sup;
    }

    // 25. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x) {
        if (!seEncuentra(x)) {
            return x;
        }

        NodoABB p = raiz;
        int inf = x;

        while (p != null) {
            if (x > p.elem) {
                inf = p.elem;
                p = p.der;
            } else {
                p = p.izq;
            }
        }
        return inf;
    }
    
    // 26. Incluir 5 ejercicios cualesquiera interesante sobre ABB.
    // 26. 1. A1.esABB(): Verifica si el árbol cumple propiedad ABB (por rangos).
    public boolean esABB() {
        return esABB(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean esABB(NodoABB p, int min, int max) {
        if (p == null) {
            return true;
        }
        if (p.elem <= min || p.elem >= max) {
            return false;
        }
        return esABB(p.izq, min, p.elem) && esABB(p.der, p.elem, max);
    }

    // 26. 2. A1.contarNivel(int k): Cantidad de nodos en el nivel k (raíz nivel 0).
    public int contarNivel(int k) {
        return contarNivel(raiz, k);
    }

    private int contarNivel(NodoABB p, int k) {
        if (p == null) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return contarNivel(p.izq, k - 1) + contarNivel(p.der, k - 1);
    }

    // 26. 3. A1.contarRango(int a, int b): Cuenta cuántos elementos están en [a, b].
    public int contarRango(int a, int b) {
        return contarRango(raiz, a, b);
    }

    private int contarRango(NodoABB p, int a, int b) {
        if (p == null) {
            return 0;
        }

        if (p.elem < a) {
            return contarRango(p.der, a, b);
        }
        if (p.elem > b) {
            return contarRango(p.izq, a, b);
        }

        return 1 + contarRango(p.izq, a, b) + contarRango(p.der, a, b);
    }

    // 26. 4. A1.sumaRango(int a, int b): Suma de elementos en [a, b].
    public int sumaRango(int a, int b) {
        return sumaRango(raiz, a, b);
    }

    private int sumaRango(NodoABB p, int a, int b) {
        if (p == null) {
            return 0;
        }

        if (p.elem < a) {
            return sumaRango(p.der, a, b);
        }
        if (p.elem > b) {
            return sumaRango(p.izq, a, b);
        }

        return p.elem + sumaRango(p.izq, a, b) + sumaRango(p.der, a, b);
    }

    // 26. 5. A1.kEsimoMenor(int k): Devuelve el k-ésimo menor (k empieza en 1). Usa inOrden con contador.
    public int kEsimoMenor(int k) {
        int[] c = {0};
        NodoABB res = kEsimoMenor(raiz, k, c);
        return (res == null) ? -1 : res.elem;
    }

    private NodoABB kEsimoMenor(NodoABB p, int k, int[] c) {
        if (p == null) {
            return null;
        }

        NodoABB izq = kEsimoMenor(p.izq, k, c);
        if (izq != null) {
            return izq;
        }

        c[0]++;
        if (c[0] == k) {
            return p;
        }

        return kEsimoMenor(p.der, k, c);
    }
}
