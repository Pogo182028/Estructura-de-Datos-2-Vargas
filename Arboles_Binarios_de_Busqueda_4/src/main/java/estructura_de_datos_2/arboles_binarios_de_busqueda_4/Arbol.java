/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_4;

/**
 *
 * @author Admin
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int x) {
        this.raiz = insertar(x, this.raiz);
    }

    private Nodo insertar(int x, Nodo p) {
        if (p == null) {
            return new Nodo(x);
        }

        if (x == p.elem) {
            p.frec++;
        } else if (x < p.elem) {
            p.izq = insertar(x, p.izq);
        } else {
            p.der = insertar(x, p.der);
        }
        return p;
    }

    public void inOrdenConFrec() {
        inOrdenConFrec(raiz);
    }

    private void inOrdenConFrec(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenConFrec(p.izq);
        System.out.print(p.elem + "(" + p.frec + ") ");
        inOrdenConFrec(p.der);
    }

    public int cantidadNodos() {
        return cantidadNodos(raiz);
    }

    private int cantidadNodos(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidadNodos(p.izq) + cantidadNodos(p.der);
    }

    public int cantidadTotal() {
        return cantidadTotal(raiz);
    }

    private int cantidadTotal(Nodo p) {
        if (p == null) {
            return 0;
        }
        return p.frec + cantidadTotal(p.izq) + cantidadTotal(p.der);
    }

    public int maxFrec() {
        return maxFrec(raiz);
    }

    private int maxFrec(Nodo p) {
        if (p == null) {
            return 0;
        }
        int m = Math.max(maxFrec(p.izq), maxFrec(p.der));
        return Math.max(m, p.frec);
    }

    // Ejercicio-1.
    //  Dado una secuencia de elementos, se desea encontrar la frecuencia de cada elementos. 
    //  Mostrar los elementos de menor a mayor con sus respectivas frecuencias de ocurrencias.
    //  Mostrar los elementos de mayor  a menor con sus respectivas frecuencias de ocurrencias.
    //  Para los ejercicios anteriores, ejecutar los Algoritmos, generando n-elementos enteros entre a y b inclusive. Ejecutar para valores de n-grande.
    public void generar(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertar(x);
        }
    }

    public void mostrarAsc() {
        mostrarAsc(raiz);
    }

    private void mostrarAsc(Nodo p) {
        if (p == null) {
            return;
        }

        mostrarAsc(p.izq);
        System.out.println("Elemento: " + p.elem + " -> frec: " + p.frec);
        mostrarAsc(p.der);
    }

    public void mostrarDesc() {
        mostrarDesc(raiz);
    }

    private void mostrarDesc(Nodo p) {
        if (p == null) {
            return;
        }

        mostrarDesc(p.der);
        System.out.println("Elemento: " + p.elem + " -> frec: " + p.frec);
        mostrarDesc(p.izq);
    }
}
