/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

/**
 *
 * @author Admin
 */
public class NodoEntero {

    public NodoEntero izq;
    public NodoEntero der;
    public int elem;
    public int frec;

    public NodoEntero(int elem) {
        this.elem = elem;
        this.frec = 1;
        izq = der = null;
    }
}
