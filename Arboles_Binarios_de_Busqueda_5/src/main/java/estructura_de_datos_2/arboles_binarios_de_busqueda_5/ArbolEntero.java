/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

/**
 *
 * @author Admin
 */
// Ejercicio-1.
// Dado una secuencia de elementos, se desea encontrar la frecuencia de cada elementos. 
// Mostrar los elementos de menor a mayor con sus respectivas frecuencias de ocurrencias.
// Mostrar los elementos de mayor  a menor con sus respectivas frecuencias de ocurrencias.
// Para los ejercicios anteriores, ejecutar los Algoritmos, generando n-elementos enteros entre a y b inclusive. Ejecutar para valores de n-grande.
public class ArbolEntero {

    private NodoEntero raiz;

    public ArbolEntero() {
        this.raiz = null;
    }

    public void insertar(int x) {
        this.raiz = insertar(x, this.raiz);
    }

    private NodoEntero insertar(int x, NodoEntero p) {
        if (p == null) {
            return new NodoEntero(x);
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

    public void generar(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertar(x);
        }
    }

    public void mostrarAsc() {
        mostrarAsc(raiz);
    }

    private void mostrarAsc(NodoEntero p) {
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

    private void mostrarDesc(NodoEntero p) {
        if (p == null) {
            return;
        }

        mostrarDesc(p.der);
        System.out.println("Elemento: " + p.elem + " -> frec: " + p.frec);
        mostrarDesc(p.izq);
    }
}
