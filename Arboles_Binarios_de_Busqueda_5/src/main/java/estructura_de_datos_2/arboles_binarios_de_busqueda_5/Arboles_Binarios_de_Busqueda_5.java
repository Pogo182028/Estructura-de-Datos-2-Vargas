/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Arboles_Binarios_de_Busqueda_5 {

    public static void main(String[] args) throws IOException {
        ArbolString palabras = new ArbolString();
        ArbolString significativas = new ArbolString();

        String ruta = "D:\\Mis documentos\\Escritorio\\texto.txt"; // cambiá a tu ruta
        ProcesadorTexto.cargarArchivoEnArboles(ruta, palabras, significativas);

        System.out.println("=== Ascendente (todas) ===");
        palabras.mostrarAsc();

        System.out.println("=== Descendente (todas) ===");
        palabras.mostrarDesc();

        System.out.println("=== Ascendente (significativas) ===");
        significativas.mostrarAsc();
    }
}
