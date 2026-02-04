/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda;

/**
 *
 * @author Admin
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    // 1. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
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
        } // si x == p.elem, no hace nada

        return p;
    }

    // 2. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(Nodo p) {
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

    private void inOrden(Nodo p) {
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

    private void postOrden(Nodo p) {
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

    private boolean seEncuentra(int x, Nodo p) {
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

    private int cantidad(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    // 7. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma() {
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null) {
            return 0;
        }
        return p.elem + suma(p.izq) + suma(p.der);
    }

    // 8. A1.menor() : Método que devuelve el elemento menor del árbol A1.
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

    // 9. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
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

    // 10. A1.cantidadTerm() : Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(Nodo p) {
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

    private int sumaPares(Nodo p) {
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

    private void desc(Nodo p) {
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

    private void mostrarTerm(Nodo p) {
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

    private boolean lineal(Nodo p) {
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

        Nodo p = raiz;
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

        Nodo p = raiz;
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
}
