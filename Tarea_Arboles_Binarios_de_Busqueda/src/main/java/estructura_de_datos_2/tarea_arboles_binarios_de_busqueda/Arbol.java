/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.tarea_arboles_binarios_de_busqueda;

/**
 *
 * @author Admin
 */
public class Arbol {

    private NodoABB raiz;

    public Arbol() {
        raiz = null;
    }

    // 1. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
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

    // 2. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
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

    // 3. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
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

    // 4. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
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

    // 5. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
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

    // 6. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(NodoABB p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    // 7. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma() {
        return suma(raiz);
    }

    private int suma(NodoABB p) {
        if (p == null) {
            return 0;
        }
        return p.elem + suma(p.izq) + suma(p.der);
    }

    // 8. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor() {
        NodoABB p = raiz;
        while (p.izq != null) {
            p = p.izq;
        }
        return p.elem;
    }

    // 9. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor() {
        NodoABB p = raiz;
        while (p.der != null) {
            p = p.der;
        }
        return p.elem;
    }

    // 10. A1.cantidadTerm() : Método que devuelve la cantidad de nodos terminales del árbol A1.
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

    // 11. A1.sumaPares() : Método que devuelve la suma de los elementos pares  del árbol A1.
    public int sumaPares() {
        return sumaPares(raiz);
    }

    private int sumaPares(NodoABB p) {
        if (p == null) {
            return 0;
        }

        int suma = sumaPares(p.izq) + sumaPares(p.der);
        if (p.elem % 2 == 0) {
            suma += p.elem;
        }
        return suma;
    }

    // 12. A1.generarElem(n, a, b) : Método que genera n elementos diferentes aleatorios enteros diferentes entre a y b inclusive. Crear A1 a partir de esos elementos.
    public void generarElem(int n, int a, int b) {
        while (cantidad() < n) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertar(x);
        }
    }

    // 13. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
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

    // 14. A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
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

    // 15. A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lineal. (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
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

    // 16. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
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

    // 17. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
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

    // 18. A1.estanTodos(A2) : Método que devuelve True, si todos los elemento de A1, se encuentran en A2.
    public boolean estanTodos(Arbol A2) {
        return estanTodos(this.raiz, A2);
    }

    private boolean estanTodos(NodoABB p, Arbol A2) {
        if (p == null) {
            return true;
        }

        if (!A2.seEncuentra(p.elem)) {
            return false;
        }

        return estanTodos(p.izq, A2) && estanTodos(p.der, A2);
    }

    // 19. A1.mismosElem(A2) : Método que devuelve True, si los árboles A1 y A2 tienen los mismos elementos.
    public boolean mismosElem(Arbol A2) {
        return this.cantidad() == A2.cantidad()
                && this.estanTodos(A2)
                && A2.estanTodos(this);
    }

    // 20. Incluir 5 ejercicios cualesquiera interesante sobre ABB.
    // 20. 1. A1.esABB(): Verifica si el árbol cumple propiedad ABB (por rangos).
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

    // 20. 2. A1.contarNivel(int k): Cantidad de nodos en el nivel k (raíz nivel 0).
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

    // 20. 3. A1.contarRango(int a, int b): Cuenta cuántos elementos están en [a, b].
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

    // 20. 4. A1.sumaRango(int a, int b): Suma de elementos en [a, b].
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

    // 20. 4. A1.kEsimoMenor(int k): Devuelve el k-ésimo menor (k empieza en 1). Usa inOrden con contador.
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
