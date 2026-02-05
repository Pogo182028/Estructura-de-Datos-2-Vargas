/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_4;

/**
 *
 * @author Admin
 */
public class Nodo {

    public Nodo izq;
    public Nodo der;
    public int elem;
    public int frec;

    public Nodo(int elem) {
        this.elem = elem;
        this.frec = 1;
        izq = der = null;
    }
}
