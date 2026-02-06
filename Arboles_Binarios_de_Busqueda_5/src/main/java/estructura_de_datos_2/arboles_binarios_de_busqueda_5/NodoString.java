/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

/**
 *
 * @author Admin
 */
public class NodoString {

    public NodoString izq, der;
    public String elem;
    public int frec;

    public NodoString(String elem) {
        this.elem = elem;
        this.frec = 1;
        izq = der = null;
    }
}
