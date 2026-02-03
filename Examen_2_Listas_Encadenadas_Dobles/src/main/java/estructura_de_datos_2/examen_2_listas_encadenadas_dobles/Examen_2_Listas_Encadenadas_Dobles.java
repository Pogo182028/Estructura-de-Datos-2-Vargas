/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package estructura_de_datos_2.examen_2_listas_encadenadas_dobles;

/**
 *
 * @author Admin
 */
public class Examen_2_Listas_Encadenadas_Dobles {

    public static void main(String[] args) {
        Lista l1 = new Lista();
        l1.insertarLugarAsc(10); // #1
        l1.insertarLugarAsc(50);
        l1.insertarLugarAsc(30);
        l1.insertarLugarAsc(20);
        l1.insertarLugarAsc(40);
        System.out.println("#1 " + l1);

        Lista l2 = new Lista();
        l2.generarAsc(5, 10, 50); // #2
        System.out.println("#2 " + l2);

        Lista l3 = new Lista();
        l3.insertarPrimNVeces(30, 5); // #3
        System.out.println("#3 " + l3);
        
        l3.insertarIesimo(l2, 0); // #4
        System.out.println("#4 " + l3);

        l3.insertarIntercalado(l1, l2); // #5
        System.out.println("#5 " + l3);

        System.out.println("--------------------------");
        System.out.println(l3);
        l3.eliminarPrimNVeces(2); // #1
        System.out.println("#1 " + l3);
        l3.eliminarIesimo(1, 2);
        System.out.println("#2 " + l3); // #2
        l3.insertarPrimNVeces(30, 4);
        System.out.println(l3);
        l3.eliminarTodo(30); // #3
        System.out.println("#3 " + l3);
        System.out.println(l2);
        l3.eliminarTodo(l2);
        System.out.println("#4 " + l3);
        l3.generarAsc(3, 10, 50);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        l3.eliminarTodo(l1, l2);
        System.out.println("#5 " + l3);
    }
}
