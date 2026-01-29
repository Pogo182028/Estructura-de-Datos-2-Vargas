/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda;

/**
 *
 * @author Admin
 */
public class Nodo {
    public Nodo izq;
    public int elem;
    public Nodo der;
    
    public Nodo(int elem) {
        izq = der = null;
        this.elem = elem;
    }
}
