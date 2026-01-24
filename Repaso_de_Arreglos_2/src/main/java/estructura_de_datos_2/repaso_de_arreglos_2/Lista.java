/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.repaso_de_arreglos_2;

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

    public void insertarIesimo(int dato, int posicion) {
        for (int i = cantElem - 1; i >= posicion; i--) {
            elem[i + 1] = elem[i];
        }
        elem[posicion] = dato;
        cantElem++;
    }

    public void insertarPrim(int dato) {
        insertarIesimo(dato, 0);
    }

    public void insertarUlt(int dato) {
        insertarIesimo(dato, cantElem);
    }

    public boolean seEncuentra(int x) {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] == x) {
                return true;
            }
        }
        return false;
    }

    // 1. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenada en forma ascendente L1.
    public void insertarLugarAsc(int x) {
        int i = 0;
        while (i < cantElem && x > elem[i]) {
            i++;
        }
        insertarIesimo(x, i);
    }

    // 2. L1.insertarLugarDesc(x) :  Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenada en forma descendente L1.
    public void insertarLugarDesc(int x) {
        int i = 0;
        while (i < cantElem && x < elem[i]) {
            i++;
        }
        insertarIesimo(x, i);
    }

    // 3. L1.generarAsc(n, a, b) : Método que genera aleatoriamente, n elementos de una Lista en formas ascendente de valores enteros entre a y b inclusive.  Sugerencia, utilizar L1.insertarLugarAsc(x), n-veces.
    public void generarAsc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarLugarAsc(x);
        }
    }

    // 4. L1.generarDesc(n, a, b) : Método que genera aleatoriamente, n elementos de una Lista en formas descendente de valores enteros entre a y b inclusive. 
    public void generarDesc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarLugarDesc(x);
        }
    }

    // 5. L1.mismosElem(L2) : Método lógico que devuelve True, si las Listas L1 y L2 tienen los mismos elementos. 
    public boolean mismosElem(Lista L2) {
        if (cantElem != L2.cantElem) {
            return false;
        }

        for (int i = 0; i < cantElem; i++) {
            if (frecuencia(elem[i]) != L2.frecuencia(elem[i])) {
                return false;
            }
        }
        return true;
    }

    // 6. L1.generarAleatorios(n, a, b) : Método que genera n-valores enteros aleatorios entre a y b inclusive.
    public void generarAleatorios(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarUlt(x);
        }
    }

    // 7. L1.generarDiferentes(n, a, b) : Método que genera n-valores aleatorios diferentes entre a y b inclusive.
    public void generarDiferentes(int n, int a, int b) {
        while (cantElem < n) {
            int x = a + (int) (Math.random() * (b - a + 1));
            if (!seEncuentra(x)) {
                insertarUlt(x);
            }
        }
    }

    // 8. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
    public void pasarDigitos(int n) {
        while (n > 0) {
            insertarPrim(n % 10);
            n = n / 10;
        }
    }

    // 9. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en las Listas L2, L3. 
    public void comunes(Lista L2, Lista L3) {
        cantElem = 0;

        for (int i = 0; i < L2.cantElem; i++) {
            int x = L2.elem[i];

            if (L3.seEncuentra(x) && !seEncuentra(x)) {
                insertarUlt(x);
            }
        }
    }

    // 10. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos intercalados de las Listas L2 y L3.
    public void intercalar(Lista L2, Lista L3) {
        cantElem = 0; // vaciamos L1

        int i = 0, j = 0;
        while (i < L2.cantElem || j < L3.cantElem) {
            if (i < L2.cantElem) {
                insertarUlt(L2.elem[i]);
                i++;
            }
            if (j < L3.cantElem) {
                insertarUlt(L3.elem[j]);
                j++;
            }
        }
    }

    // 11. L1.ordenado() : Método lógico que devuelve True, si los elementos de la lista L1, están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        if (cantElem <= 1) {
            return true;
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 0; i < cantElem - 1; i++) {
            if (elem[i] > elem[i + 1]) {
                asc = false;
            }
            if (elem[i] < elem[i + 1]) {
                desc = false;
            }
        }
        return asc || desc;
    }

    // 12. L1.iguales() : Método lógico que devuelve True, si todos los elementos de la lista L1, son iguales.
    public boolean iguales() {
        if (cantElem <= 1) {
            return true;
        }

        int x = elem[0];
        for (int i = 1; i < cantElem; i++) {
            if (elem[i] != x) {
                return false;
            }
        }
        return true;
    }

    // 13. L1.diferentes() : Método lógico que devuelve True, si todos los elementos de la lista L1, son diferentes.
    public boolean diferentes() {
        for (int i = 0; i < cantElem; i++) {
            for (int j = i + 1; j < cantElem; j++) {
                if (elem[i] == elem[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 14. L1-frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la Lista L1.
    public int frecuencia(int dato) {
        int frecuencia = 0;
        for (int i = 0; i < cantElem; i++) {
            if (dato == elem[i]) {
                frecuencia++;
            }
        }
        return frecuencia;
    }

    // 15. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos tienen la misma frecuencia de aparición en la Lista L1.
    public boolean mismaFrec() {
        if (cantElem <= 1) {
            return true;
        }

        int f = frecuencia(elem[0]);

        for (int i = 1; i < cantElem; i++) {
            if (frecuencia(elem[i]) != f) {
                return false;
            }
        }
        return true;
    }

    // 16. L1.existeFrec( n ) : Método lógico que devuelve True, si existe algún elemento que se repite n-veces en la Lista L1.
    public boolean existeFrec(int n) {
        for (int i = 0; i < cantElem; i++) {
            if (frecuencia(elem[i]) == n) {
                return true;
            }
        }
        return false;
    }

    // 17. L1.poker() : Método lógico que devuelve True, si todos los elementos de la Lista L1 son iguales, excepto uno.
    public boolean poker() {
        if (cantElem < 2) {
            return false;
        }

        int unicos = 0;
        int repetidos = 0;

        for (int i = 0; i < cantElem; i++) {
            int f = frecuencia(elem[i]);
            if (f == 1) {
                unicos++;
            } else if (f == cantElem - 1) {
                repetidos++;
            }
        }
        return unicos == 1 && repetidos == cantElem - 1;
    }

    // 18. L1.palindrome() : Método lógico que devuelve True, si los elementos de la Lista L1, forma un palíndrome.
    public boolean palindrome() {
        int i = 0;
        int j = cantElem - 1;

        while (i < j) {
            if (elem[i] != elem[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 19. Incluir al menos 5 métodos adicionales de consultas sobre los elementos de Listas.
    // 1. suma() — suma de todos los elementos
    public int suma() {
        int s = 0;
        for (int i = 0; i < cantElem; i++) {
            s += elem[i];
        }
        return s;
    }

    // 2. promedio() — promedio de los elementos
    public double promedio() {
        if (cantElem == 0) {
            return 0;
        }
        return (double) suma() / cantElem;
    }

    // 3. contarMayoresQue(int x) — cuántos son mayores que x
    public int contarMayoresQue(int x) {
        int c = 0;
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] > x) {
                c++;
            }
        }
        return c;
    }

    // 4. todosPositivos() — true si todos son > 0
    public boolean todosPositivos() {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    // 5. rango() — diferencia entre mayor y menor
    public int rango() {
        if (cantElem == 0) {
            return 0;
        }

        int max = elem[0];
        int min = elem[0];

        for (int i = 1; i < cantElem; i++) {
            if (elem[i] > max) {
                max = elem[i];
            }
            if (elem[i] < min) {
                min = elem[i];
            }
        }
        return max - min;
    }

}
