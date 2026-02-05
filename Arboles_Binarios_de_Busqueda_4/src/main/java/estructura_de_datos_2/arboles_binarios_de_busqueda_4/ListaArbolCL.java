/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_4;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
//    Ejercicio-2.
//    Dado una secuencia de número enteros positivos. Se desea obtener un reporte del conjuntos de números que terminan con el mismo dígito ordenados de menor a mayor con sus 
//    respectivas frecuencias. 
//    Para resolver este problema utilizar una Lista de Árboles Binarios de Búsqueda, Resolver de dos estructuras de datos de representación de Listas en Arreglo que contien 10 ABB. 
//    b) Utilizando librería de ArrayList. (El último dígito k de un elemento, se inserta en el ABB de la posición k de la Lista en Arreglo). 
//    El constructor de la Lista de Arboles, inicializar con 10-Arboles vacíos. 
//    Generar n-elementos aleatorios e insertar en una Lista de Arboles en sus posiciones correspondientes. Luegos mostrar los elementos de cada ABB en inOrden, en cualquier formato.
//    Incluir al menos 5 consultas cualesquiera sobre cada Arbol y/o sobre el conjunto de Arboles.
public class ListaArbolCL { // con librería

    private ArrayList<Arbol> L;

    public ListaArbolCL() {
        L = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            L.add(new Arbol());
        }
    }

    public void insertar(int x) {
        int k = x % 10;
        L.get(k).insertar(x);
    }

    public void generar(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertar(x);
        }
    }

    public void mostrar() {
        for (int k = 0; k < 10; k++) {
            System.out.println("Digito " + k + ":");
            L.get(k).inOrdenConFrec();
            System.out.println();
        }
    }

    // Consulta #1: total de elementos generados (sumando frec)
    public int totalElementos() {
        int s = 0;
        for (int k = 0; k < 10; k++) {
            s += L.get(k).cantidadTotal();
        }
        return s;
    }

    // Consulta #2: total de distintos (nodos) en todo el conjunto
    public int totalDistintos() {
        int s = 0;
        for (int k = 0; k < 10; k++) {
            s += L.get(k).cantidadNodos();
        }
        return s;
    }

    // Consulta #3: dígito (0..9) con más elementos (sumando frec)
    public int digitoMasCargado() {
        int mejor = 0, mayor = L.get(0).cantidadTotal();
        for (int k = 1; k < 10; k++) {
            int t = L.get(k).cantidadTotal();
            if (t > mayor) {
                mayor = t;
                mejor = k;
            }
        }
        return mejor;
    }

    // Consulta #4: dígito con más distintos (más nodos)
    public int digitoMasDistintos() {
        int mejor = 0, mayor = L.get(0).cantidadNodos();
        for (int k = 1; k < 10; k++) {
            int t = L.get(k).cantidadNodos();
            if (t > mayor) {
                mayor = t;
                mejor = k;
            }
        }
        return mejor;
    }

    // Consulta #5: mayor repetición en todo el conjunto (máxima frec global)
    public int maxFrecGlobal() {
        int m = 0;
        for (int k = 0; k < 10; k++) {
            m = Math.max(m, L.get(k).maxFrec());
        }
        return m;
    }

}
