/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.tarea_listas_encadenadas_dobles;

/**
 *
 * @author MADITAS
 */
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    public boolean vacia() {
        return cantElem == 0;
    }

    // 1. L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    @Override
    public String toString() {
        Nodo p = prim;
        String s1 = "[";
        while (p != null) {
            s1 += p.elem;
            if (p.prox != null) {
                s1 += ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    // 2. L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }

    // 3. L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }

    // 4. L1.eliminarPrim() : Método que elimina el primer elemento de la lista L1.
    public void eliminarPrim() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        cantElem--;
    }

    // 5. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    public void eliminarUlt() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        cantElem--;
    }

    // 6. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    public boolean iguales() {
        Nodo p = prim;
        for (int i = 0; i < cantElem; i++) {
            if (p.prox != null) {
                if (p.elem != p.prox.elem) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }

    // 7. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem() {
        Nodo p = prim;
        int mayor = p.elem;
        for (int i = 0; i < cantElem; i++) {
            if (p.prox != null) {
                if (p.prox.elem > mayor) {
                    mayor = p.prox.elem;
                }
                p = p.prox;
            }
        }
        return mayor;
    }

    // 8. L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    public int menorElem() {
        Nodo p = prim;
        int menor = p.elem;
        for (int i = 0; i < cantElem; i++) {
            if (p.prox != null) {
                if (menor > p.prox.elem) {
                    menor = p.prox.elem;
                }
                p = p.prox;
            }
        }
        return menor;
    }

    // 9. L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        if (vacia() || prim.prox == null) {
            return true;
        }
        boolean asc = true, desc = true;
        Nodo p = prim;
        while (p.prox != null) {
            if (p.elem > p.prox.elem) {
                asc = false;
            }
            if (p.elem < p.prox.elem) {
                desc = false;
            }
            p = p.prox;
        }
        return asc || desc;
    }

    // 10. L1.pares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean pares() {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 11. L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par e impar.
    public boolean parImpar() {
        boolean hayPar = false;
        boolean hayImpar = false;
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                hayPar = true;
            } else {
                hayImpar = true;
            }
            if (hayPar && hayImpar) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 12. L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    public void reemplazar(int x, int y) {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    // 13. L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    public boolean seEncuentra(int x) {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 14. L1.mismosElem(L2) : Método Lógico que devuelve True, las Listas L1 y L2, tienen los mismos elementos.
    public boolean mismosElem(Lista L2) {
        if (cantElem != L2.cantElem) {
            return false;
        }
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) != L2.frecuencia(p.elem)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 15. L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    public int frecuencia(int x) {
        Nodo p = this.prim;
        int contador = 0;
        while (p != null) {
            if (p.elem == x) {
                contador++;
            }
            p = p.prox;
        }
        return contador;
    }

    // 16. L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.
    public boolean existeFrec(int k) {
        Nodo p = this.prim;
        while (p != null) {
            if (frecuencia(p.elem) == k) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 17. L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos de la lista L1 tienen la misma frecuencia.
    public boolean mismasFrec() {
        if (vacia()) {
            return true;
        }
        Nodo p = this.prim;
        int freq = frecuencia(p.elem);
        while (p != null) {
            if (frecuencia(p.elem) != freq) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 18. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    public boolean diferentes() {
        Nodo p = this.prim;
        while (p != null) {
            if (frecuencia(p.elem) > 1) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 19. L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)
    public boolean poker() {
        if (iguales()) {
            return false;
        }
        Nodo p = this.prim;
        int distinto = 0;
        int iguales = 0;
        while (p != null) {
            if (frecuencia(p.elem) == 1) {
                distinto++;
            } else {
                iguales++;
            }
            if (distinto > 1) {
                return false;
            }
            p = p.prox;
        }
        return false;
    }

    // 20. L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar() {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 21. L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    public boolean existeImpar() {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 22. L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean todoPares() {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 23. L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
    public boolean todoImpares() {
        Nodo p = this.prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 24. L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.
    public boolean existeParImpar() {
        return existePar() && existeImpar();
    }

    // 25. L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    public boolean alternos() {
        Nodo p = this.prim;
        if (p == null) {
            return true;
        }
        boolean par = p.elem % 2 == 0;
        while (p != null) {
            if ((par && p.elem % 2 != 0) || (!par && p.elem % 2 == 0)) {
                par = !par;
            } else {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 26. L1.insertarPrim(L2) : Método que inserta los elementos de la Lista L2, al inicio de la Lista L1.
    public void insertarPrim(Lista L2) {
        Nodo p = L2.ult;
        while (p != null) {
            this.insertarPrim(p.elem);
            p = p.prox;
        }
    }

    // 27. L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al final de la Lista L1.
    public void insertarUlt(Lista L2) {
        Nodo p = L2.prim;
        while (p != null) {
            this.insertarUlt(p.elem);
            p = p.prox;
        }
    }

    // 28. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas L2 con L3 en L1.
    public void intercalar(Lista L2, Lista L3) {
        Nodo p2 = L2.prim;
        Nodo p3 = L3.prim;
        while (p2 != null || p3 != null) {
            if (p2 != null) {
                this.insertarUlt(p2.elem);
                p2 = p2.prox;
            }
            if (p3 != null) {
                this.insertarUlt(p3.elem);
                p3 = p3.prox;
            }
        }
    }

    // 29. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        for (int i = 0; i < n; i++) {
            eliminarPrim();
        }
    }

    // 30. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        for (int i = 0; i < n; i++) {
            eliminarUlt();
        }
    }

    // 31. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los extremos de la lista L1. 
    public void eliminarExtremos(int n) {
        for (int i = 0; i < n; i++) {
            eliminarPrim();
            eliminarUlt();
        }
    }

    // 32. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar y eliminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        for (int i = 0; i < n; i++) {
            int x = ult.elem;
            eliminarUlt();
            insertarPrim(x);
        }
    }

    // 33. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        for (int i = 0; i < n; i++) {
            int x = prim.elem;
            eliminarPrim();
            insertarUlt(x);
        }
    }

    // 34. L1.indexOf(x) : Método que devuelve la posición de la primera ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1.
    public int indexOf(int x) {
        int c = 0;
        Nodo actual = this.prim;
        while (actual != null) {
            if (actual.elem == x) {
                return c;
            }
            actual = actual.prox;
            c++;
        }
        return -1;
    }

    // 35. L1.lastIndexOf(x) : Método que devuelve la posición de la primera ocurrencia del elemento x, buscando desde el último nodo hasta la izquierda. Si x no se encuentra en la lista L1, el método devuelve –1.
    public int lastIndexOf(int x) {
        Nodo actual = ult;
        int index = cantElem - 1;
        while (actual != null) {
            if (actual.elem == x) {
                return index;
            }
            actual = actual.ant;
            index--;
        }
        return -1;
    }

    // 36. L1.palindrome() : Método Lógico que devuelve True, si la Lista L1, es un palíndrome.
    public boolean palindrome() {
        Nodo ini = this.prim;
        Nodo fin = this.ult;
        while (ini != null && fin != null) {
            if (ini.elem != fin.elem) {
                return false;
            }
            ini = ini.prox;
            fin = fin.ant;
        }
        return true;
    }

    // 37. Adicionar al menos 5 métodos cualesquiera de consultas interesantes sobre una, dos y tres Listas, que sean coherentes con los ejercicios de arriba.
    //1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i.
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
        Nodo ap = null;
        int j = 0;
        while (p != null && j < i) {
            ap = p;
            p = p.prox;
            j++;
        }
        Nodo nuevo = new Nodo(p, x, ap);
        if (ap != null) {
            ap.prox = nuevo;
        }
        if (p != null) {
            p.ant = nuevo;
        }
        cantElem++;
    }

    //2. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1.
    public void eliminarPares() {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem % 2 == 0) {
                if (p == prim) {
                    eliminarPrim();
                } else if (p == ult) {
                    eliminarUlt();
                } else {
                    p.ant.prox = p.prox;
                    p.prox.ant = p.ant;
                    cantElem--;
                }
            }
            p = sig;
        }
    }

    //3. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez.
    public void eliminarUnicos() {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (frecuencia(p.elem) == 1) {
                if (p == prim) {
                    eliminarPrim();
                } else if (p == ult) {
                    eliminarUlt();
                } else {
                    p.ant.prox = p.prox;
                    p.prox.ant = p.ant;
                    cantElem--;
                }
            }
            p = sig;
        }
    }

    //4. L1.suma() : Metodo que devuelva la suma de los elementos de la Lista L1
    public int suma() {
        int s = 0;
        Nodo p = prim;
        while (p != null) {
            s += p.elem;
            p = p.prox;
        }
        return s;
    }

    //5. L1.promedio() : Metodo que devuelve el promedio de los elementos de la Lista L1
    public double promedio() {
        if (cantElem == 0) {
            return 0;
        }
        return (double) suma() / cantElem;
    }
}
