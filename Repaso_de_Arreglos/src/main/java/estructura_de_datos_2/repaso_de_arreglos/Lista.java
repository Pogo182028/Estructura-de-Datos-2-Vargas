/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.repaso_de_arreglos;

/**
 *
 * @author Admin
 */
public class Lista {

    private int elem[];
    private int cantElem;
    private int max;

    public Lista(int max) {
        this.elem = new int[max];
        this.cantElem = 0;
        this.max = max;
    }

    @Override
    public String toString() {
        String s1 = "[";
        for (int i = 0; i < cantElem; i++) {
            s1 = s1 + elem[i];
            if (i < cantElem - 1) {
                s1 = s1 + ", ";
            }
        }
        return s1 + "]";
    }

    // 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
    public void insertarIesimo(int dato, int posicion) {
        for (int i = cantElem - 1; i >= posicion; i--) {
            elem[i + 1] = elem[i];
        }
        elem[posicion] = dato;
        cantElem++;
    }

    // 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
    public void insertarPrim(int dato) {
        insertarIesimo(dato, 0);
    }

    // 3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
    public void insertarUlt(int dato) {
        insertarIesimo(dato, cantElem);
    }

    // 4. L1.insertarIesimo(L2, i) : Método que insertar la Lista L2, a partir de la posición i, de la Lista L1.
    public void insertarIesimo(Lista L2, int desdePosicion) {
        for (int i = 0; i < L2.cantElem; i++) {
            insertarIesimo(L2.elem[i], desdePosicion + i);
        }
    }

    // 5. L1.insertarPrim(L2) : Método que inserta la Lista L2, al inicio de la Lista L1.
    public void insertarPrim(Lista L2) {
        insertarIesimo(L2, 0);
    }

    // 6. L1.insertarUlt(L2) : Método que inserta la Lista L2, al final de la Lista L1.
    public void insertarUlt(Lista L2) {
        insertarIesimo(L2, cantElem);
    }

    // 7. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
    public void eliminarIesimo(int posicion) {
        for (int i = posicion; i < cantElem - 1; i++) {
            elem[i] = elem[i + 1];
        }
        cantElem--;
    }

    // 8. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
    public void eliminarPrim() {
        eliminarIesimo(0);
    }

    // 9. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    public void eliminarUlt() {
        eliminarIesimo(cantElem - 1);
    }

    // 10. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
    public void eliminarTodo(int dato) {
        for (int i = cantElem - 1; i >= 0; i--) {
            if (elem[i] == dato) {
                eliminarIesimo(i);
            }
        }
    }

    // 11. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
    public int frecuencia(int dato) {
        int frecuencia = 0;
        for (int i = 0; i < cantElem; i++) {
            if (dato == elem[i]) {
                frecuencia++;
            }
        }
        return frecuencia;
    }

    public void eliminarUnicos() {
        for (int i = 0; i < cantElem; i++) {
            if (frecuencia(elem[i]) == 1) {
                eliminarIesimo(i);
            }
        }
    }

    // 12. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    public void eliminarTodo(Lista L2) {
        for (int i = 0; i < L2.cantElem; i++) {
            eliminarTodo(L2.elem[i]);
        }
    }

    // 13. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar y eliminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        for (int i = 0; i < n; i++) {
            int ultimo = elem[cantElem - 1];
            eliminarUlt();
            insertarPrim(ultimo);
        }
    }

    // 14. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        for (int i = 0; i < n; i++) {
            int primero = elem[0];
            eliminarPrim();
            insertarUlt(primero);
        }
    }

    // 15. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        for (int i = 0; i < n; i++) {
            eliminarPrim();
        }
    }

    // 16. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        for (int i = 0; i < n; i++) {
            eliminarUlt();
        }
    }

    // 17. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    public void eliminarIesimo(int posicion, int n) {
        for (int i = posicion; i < cantElem - n; i++) {
            elem[i] = elem[i + n];
        }
        cantElem -= n;
    }

    // 18. L1.eliminarExtremos( n ) : Método que elimina n-elementos de cada extremo de la lista L1. 
    public void eliminarExtremos(int n) {
        eliminarPrim(n);
        eliminarUlt(n);
    }

    // 19. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten k-veces en la lista L1.
    public void eliminarVeces(int k) {
        for (int i = cantElem - 1; i >= 0; i--) {
            if (frecuencia(elem[i]) == k) {
                eliminarIesimo(i);
            }
        }
    }

    // 20. L1.eliminarAlternos() : Método que elimina los elementos de las posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)
    public void eliminarAlternos() {
        int j = 0;
        for (int i = 0; i < cantElem; i += 2) { // tomamos 0,2,4,6...
            elem[j] = elem[i];
            j++;
        }
        cantElem = j;
    }

}
