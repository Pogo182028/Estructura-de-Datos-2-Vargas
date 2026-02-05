/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package estructura_de_datos_2.arboles_binarios_de_busqueda_4;

/**
 *
 * @author Admin
 */
public class Arboles_Binarios_de_Busqueda_4 {

    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.generar(100, 10, 100);
        A1.mostrarAsc();
        System.out.println("-----------------------------------");
        A1.mostrarDesc();
    }
}
