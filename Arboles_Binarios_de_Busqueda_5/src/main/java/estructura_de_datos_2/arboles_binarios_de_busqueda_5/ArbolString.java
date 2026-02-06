/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

/**
 *
 * @author Admin
 */
// Ejercicio 2.
// Implementar el Ejercicios-1, con elementos Strings.  Es decir; los elementos ya no son enteros, sino Cadenas de Caracteres, utilizar s1.compareTo(s2), s1.equals(s2), 
// para comparar dos cadenas de caracteres.
// Para ejecutar con n-palabras, para n-grande. Leer los datos de un Archivo de Texto y utilizar StringTokenizer() y utilizar todos los delimitadores posibles de palabras, 
// para encontrar cada palabra del Archivo de Texto, para facilitar las consultas transormar todas las palabras del Texto a minúsculas. 
// Utilizar un archivo de texto cualquiera de al menos 5 páginas de un documento. 
// Mostrar las palabras de menor a mayor con sus respectivas frecuencias.
// Mostrar las palabras de mayor a menor con sus respectivas frecuencias.
// Mostrar las palabras de menor a mayor con sus respectivas frecuencias. Solo palabras significativas. (eliminar preposiciones, artículos, conectivos, etc.)
public class ArbolString {

    private NodoString raiz;

    public ArbolString() {
        raiz = null;
    }

    public void insertar(String x) {
        raiz = insertar(x, raiz);
    }

    private NodoString insertar(String x, NodoString p) {
        if (p == null) {
            return new NodoString(x);
        }

        int c = x.compareTo(p.elem);
        if (c == 0) {
            p.frec++;
        } else if (c < 0) {
            p.izq = insertar(x, p.izq);
        } else {
            p.der = insertar(x, p.der);
        }

        return p;
    }

    public void mostrarAsc() {
        mostrarAsc(raiz);
    }

    private void mostrarAsc(NodoString p) {
        if (p == null) {
            return;
        }
        mostrarAsc(p.izq);
        System.out.println(p.elem + " -> " + p.frec);
        mostrarAsc(p.der);
    }

    public void mostrarDesc() {
        mostrarDesc(raiz);
    }

    private void mostrarDesc(NodoString p) {
        if (p == null) {
            return;
        }
        mostrarDesc(p.der);
        System.out.println(p.elem + " -> " + p.frec);
        mostrarDesc(p.izq);
    }
}
