/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.listas_encadenadas_dobles_2;

/**
 *
 * @author DUNSTON
 */
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    @Override
    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    public boolean vacia() {
        return cantElem == 0;
    }

    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }

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

    public void eliminarPrim() {
        if (vacia()) {
            return;
        }

        if (prim == ult) {
            prim = ult = null;
        } else {
            prim = prim.prox;
            prim.ant = null;
        }
        cantElem--;
    }

    public void eliminarUlt() {
        if (vacia()) {
            return;
        }

        if (prim == ult) {
            prim = ult = null;
        } else {
            ult = ult.ant;
            ult.prox = null;
        }
    }

    public int frecuencia(int x) {
        int c = 0;
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                c++;
            }
            p = p.prox;
        }
        return c;
    }

    // 1. L1.insertarIesimo(x,i): método que insertar el elemento x, en la posición i, de la lista L1.
    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (k < i && p != null) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(ap, p, x);
    }

    public void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null) {
            insertarPrim(x);
            return;
        }
        if (p == null) {
            insertarUlt(x);
            return;
        }
        ap.prox = p.ant = new Nodo(ap, x, p);
        cantElem++;
    }

    // 2. L1.insertarIesimo(L2, i): método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.
    public void insertarIesimo(Lista L2, int i) {
        Nodo p = L2.prim;
        int pos = i;
        while (p != null) {
            insertarIesimo(p.elem, pos);
            pos++;
            p = p.prox;
        }
    }

    // 3. L1.insertarLugarAsc(x): método que insertar el elemento x, en su lugar correspondiente en la Lista ordenada en forma ascendente L1.
    public void insertarLugarAsc(int x) {
        Nodo p = prim;
        int i = 0;
        while (p != null && p.elem < x) {
            p = p.prox;
            i++;
        }
        insertarIesimo(x, i);
    }

    // 4. L1.insertarLugarDesc(x): ....
    public void insertarLugarDesc(int x) {
        Nodo p = prim;
        int i = 0;
        while (p != null && p.elem > x) {
            p = p.prox;
            i++;
        }
        insertarIesimo(x, i);
    }

    // 5. L1.generarAsc(n, a, b): ...
    public void generarAsc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarLugarAsc(x);
        }
    }

    // 6. L1.generarDesc(n, a, b): ...
    public void generarDesc(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarLugarDesc(x);
        }
    }

    // 7. L1.generarAleatorios(n, a, b): ...
    public void generarAleatorios(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = a + (int) (Math.random() * (b - a + 1));
            insertarUlt(x);
        }
    }

    // 8. L1. generarDiferentes(n, a, b): ...
    public void generarDiferentes(int n, int a, int b) {
        while (cantElem < n) {
            int x = a + (int) (Math.random() * (b - a + 1));
            if (!seEncuentra(x)) {
                insertarUlt(x);
            }
        }
    }

    // 9. L1.palindrome(): ....
    public boolean palindrome() {
        Nodo p = prim;
        Nodo q = ult;

        while (p != null && q != null && p != q && p.ant != q) {
            if (p.elem != q.elem) {
                return false;
            }
            p = p.prox;
            q = q.ant;
        }
        return true;
    }

    // 10. L1.eliminarIesimo(i): ...
    public void eliminarIesimo(int i) {
        if (i == 0) {
            eliminarPrim();
        } else if (i == cantElem - 1) {
            eliminarUlt();
        } else {
            Nodo p = prim;
            for (int k = 0; k < i; k++) {
                p = p.prox;
            }
            p.ant.prox = p.prox;
            p.prox.ant = p.ant;
            cantElem--;
        }
    }

    // 11. L1.eliminarPrim(x): ...
    public void eliminarPrim(int x) {
        Nodo p = prim;
        int i = 0;

        while (p != null) {
            if (p.elem == x) {
                eliminarIesimo(i);
                return;
            }
            p = p.prox;
            i++;
        }
    }

    // 12. L1.eliminarUlt(x): ...
    public void eliminarUlt(int x) {
        Nodo p = ult;
        int i = cantElem - 1;

        while (p != null) {
            if (p.elem == x) {
                eliminarIesimo(i);
                return;
            }
            p = p.ant;
            i--;
        }
    }

    // 13. L1.eliminarTodo(x): ...
    public void eliminarTodo(int x) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (p.elem == x) {
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

    // 14. L1.eliminarIesimo(i, n): ...
    public void eliminarIesimo(int i, int n) {
        for (int k = 0; k < n; k++) {
            eliminarIesimo(i);
        }
    }

    // 15. L1.eliminarPares(): ...
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

    // 16. L1.eliminarUnicos(): ...
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

    // 17. L1.eliminarTodo(L2): ...
    public void eliminarTodo(Lista L2) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (L2.seEncuentra(p.elem)) {
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
    
    // 18. L1.eliminarVeces(k): ...
    public void eliminarVeces(int k) {
        Nodo p = prim;
        while (p != null) {
            Nodo sig = p.prox;
            if (frecuencia(p.elem) == k) {
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
}
