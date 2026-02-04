/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.tarea_arboles_binarios_de_busqueda_2;

/**
 *
 * @author Admin
 */
public class Nodo {

    public Nodo ant;
    public int elem;
    public Nodo prox;

    public Nodo(Nodo ant, int elem, Nodo prox) {
        this.ant = ant;
        this.elem = elem;
        this.prox = prox;
    }
}
