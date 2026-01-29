/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.listas_encadenadas_simples;

/**
 *
 * @author Admin
 */
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        this.prim = this.ult = null;
        this.cantElem = 0;
    }

    public boolean vacia() {
        return cantElem == 0;
    }

    // 1. L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    @Override
    public String toString() {
        String s1 = "[";
        Nodo p = this.prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    // 2. L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarPrim(int x) {
        if (vacia()) {
            this.prim = this.ult = new Nodo(x, null);
        } else {
            this.prim = new Nodo(x, prim);
        }
        this.cantElem++;
    }

    // 3. L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarUlt(int x) {
        if (vacia()) {
            this.prim = this.ult = new Nodo(x, null);
        } else {
            this.ult.prox = new Nodo(x, null);
            this.ult = this.ult.prox;
        }
        this.cantElem++;
    }

    // 4. L1.eliminarPrim() : Método que elimina el primer elemento de la lista L1.
    public void eliminarPrim() {
        if (vacia()) {
            return;
        }

        if (prim == ult) {
            prim = ult = null;
        } else {
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
            Nodo p = prim;
            while (p.prox != ult) {
                p = p.prox;
            }
            p.prox = null;
            ult = p;
        }
        cantElem--;
    }

    // 6. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    public boolean iguales() {
        if (vacia() || prim.prox == null) {
            return true;
        }

        int x = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem != x) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 7. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem() {
        if (vacia()) {
            return 0;
        }

        if (prim.prox == null) {
            return prim.elem;
        }

        int mayor = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > mayor) {
                mayor = p.elem;
            }
            p = p.prox;
        }
        return mayor;
    }

    // 8. L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    public int menorElem() {
        if (vacia()) {
            return 0;
        }

        if (prim.prox == null) {
            return prim.elem;
        }

        int menor = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem < menor) {
                menor = p.elem;
            }
            p = p.prox;
        }
        return menor;
    }

    // 9. L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        if (vacia() || prim.prox == null) {
            return true;
        }

        boolean asc = true;
        boolean desc = true;

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
        Nodo p = prim;
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
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    // 13. L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    public boolean seEncuentra(int x) {
        Nodo p = prim;
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
        int cont = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                cont++;
            }
            p = p.prox;
        }
        return cont;
    }

    // 16. L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.
    public boolean existeFrec(int k) {
        Nodo p = prim;
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

        int f = frecuencia(prim.elem);
        Nodo p = prim.prox;

        while (p != null) {
            if (frecuencia(p.elem) != f) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 18. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    public boolean diferentes() {
        Nodo p = prim;
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
        if (cantElem < 2) {
            return false;
        }

        int fPrim = frecuencia(prim.elem);
        boolean hayUno = false;

        Nodo p = prim;
        while (p != null) {
            int f = frecuencia(p.elem);
            if (f == 1) {
                if (hayUno) {
                    return false; // más de uno distinto
                }
                hayUno = true;
            } else if (f != fPrim && fPrim != 1) {
                return false;
            }
            p = p.prox;
        }
        return hayUno;
    }

    // 20. L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar() {
        Nodo p = prim;
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
        Nodo p = prim;
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
        Nodo p = prim;
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
        Nodo p = prim;
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

    // 25. L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    public boolean alternos() {
        if (vacia() || prim.prox == null) {
            return true;
        }

        Nodo p = prim;
        boolean esPar = (p.elem % 2 == 0);
        p = p.prox;

        while (p != null) {
            boolean actualPar = (p.elem % 2 == 0);
            if (actualPar == esPar) {
                return false;
            }
            esPar = actualPar;
            p = p.prox;
        }
        return true;
    }

    // 26. L1.insertarPrim(L2) : Método que inserta los elementos de la Lista L2, al inicio de la Lista L1.
    public void insertarPrim(Lista L2) {
        if (L2.vacia()) {
            return;
        }

        Nodo p = L2.prim;
        int[] aux = new int[L2.cantElem];
        int i = 0;

        while (p != null) {
            aux[i++] = p.elem;
            p = p.prox;
        }

        for (int j = aux.length - 1; j >= 0; j--) {
            insertarPrim(aux[j]);
        }
    }

    // 27. L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al final de la Lista L1.
    public void insertarUlt(Lista L2) {
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    // 28. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas L2 con L3 en L1.
    public void intercalar(Lista L2, Lista L3) {
        prim = ult = null;
        cantElem = 0;

        Nodo p = L2.prim;
        Nodo q = L3.prim;

        while (p != null || q != null) {
            if (p != null) {
                insertarUlt(p.elem);
                p = p.prox;
            }
            if (q != null) {
                insertarUlt(q.elem);
                q = q.prox;
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
            int x = prim.elem;
            eliminarPrim();
            insertarUlt(x);
        }
    }

    // 33. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        for (int i = 0; i < n; i++) {
            int x = ult.elem;
            eliminarUlt();
            insertarPrim(x);
        }
    }

    // 34. Adicionar al menos 5 métodos cualesquiera de consultas interesantes sobre una, dos y tres Listas, que sean coherentes con los ejercicios de arriba.
    // 34. 1. L1.promedio(): Devuelve el promedio de los elementos.
    public double promedio() {
        if (vacia()) {
            return 0;
        }

        int suma = 0;
        Nodo p = prim;
        while (p != null) {
            suma += p.elem;
            p = p.prox;
        }
        return (double) suma / cantElem;
    }

    // 34. 2. L1.existeMayorQue(x): Devuelve true si existe algún elemento mayor que x.
    public boolean existeMayorQue(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem > x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    // 34. 3. L1.sonDisjuntas(L2): Devuelve true si no comparten ningún elemento.
    public boolean sonDisjuntas(Lista L2) {
        Nodo p = prim;
        while (p != null) {
            if (L2.seEncuentra(p.elem)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    // 34. 4. L1.mayorComun(L2): Devuelve el mayor elemento común entre L1 y L2, si no hay común, devuelve -1.
    public int mayorComun(Lista L2) {
        int mayor = -1;
        Nodo p = prim;
        while (p != null) {
            if (L2.seEncuentra(p.elem) && p.elem > mayor) {
                mayor = p.elem;
            }
            p = p.prox;
        }
        return mayor;
    }

    // 35. 5. L1.comunEnTres(L2, L3): Devuelve true si existe al menos un elemento común en L1, L2 y L3.
    public boolean comunEnTres(Lista L2, Lista L3) {
        Nodo p = prim;
        while (p != null) {
            if (L2.seEncuentra(p.elem) && L3.seEncuentra(p.elem)) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
}
