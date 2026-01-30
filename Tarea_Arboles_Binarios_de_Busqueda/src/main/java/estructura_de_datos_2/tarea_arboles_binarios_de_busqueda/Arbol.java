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
        } // si x == p.elem, no hace nada

        return p;
    }

    // 2. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    // 3. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    // 4. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    // 5. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    // 6. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    // 7. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    // 8. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    // 9. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    // 10. A1.cantidadTerm() : Método que devuelve la cantidad de nodos terminales del árbol A1.
    // 11. A1.sumaPares() : Método que devuelve la suma de los elementos pares  del árbol A1.
    // 12. A1.generarElem(n, a, b) : Método que genera n elementos diferentes aleatorios enteros diferentes entre a y b inclusive. Crear A1 a partir de esos elementos.
    // 13. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    // 14. A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
    // 15. A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lineal. (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
    // 16. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    // 17. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    // 18. A1.estanTodos(A2) : Método que devuelve True, si todos los elemento de A1, se encuentran en A2.
    // 19. A1.mismosElem(A2) : Método que devuelve True, si los árboles A1 y A2 tienen los mismos elementos.
    // 20. Incluir 5 ejercicios cualesquiera interesante sobre ABB.
}
