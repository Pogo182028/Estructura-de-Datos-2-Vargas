/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_2;

/**
 *
 * @author Admin
 */
public class NodoABB {
    public NodoABB izq;
    public int elem;
    public NodoABB der;
    
    public NodoABB(int elem) {
        izq = der = null;
        this.elem = elem;
    }
}
