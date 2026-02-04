/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_3;

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

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            Nodo nuevo = new Nodo(ult, x, null);
            ult.prox = nuevo;
            ult = nuevo;
        }
        cantElem++;
    }
}
