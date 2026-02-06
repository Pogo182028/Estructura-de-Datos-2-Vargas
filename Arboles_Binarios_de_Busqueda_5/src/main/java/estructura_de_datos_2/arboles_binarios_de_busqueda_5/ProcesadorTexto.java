/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura_de_datos_2.arboles_binarios_de_busqueda_5;

import java.io.*;
import java.util.*;
import java.text.Normalizer;

/**
 *
 * @author Admin
 */
public class ProcesadorTexto {

    // stopwords mínimas (artículos, preposiciones, conectores)
    private static final Set<String> STOP = new HashSet<>(Arrays.asList(
            "a", "al", "algo", "algunas", "algunos", "ante", "antes", "como", "con", "contra", "cual", "cuales",
            "de", "del", "desde", "donde", "dos", "el", "ella", "ellas", "ellos", "en", "entre", "era", "eramos", "eran",
            "es", "esa", "esas", "ese", "eso", "esos", "esta", "estaba", "estaban", "estas", "este", "esto", "estos",
            "fue", "ha", "han", "hasta", "hay", "la", "las", "le", "les", "lo", "los", "mas", "me", "mi", "mis",
            "muy", "ni", "no", "nos", "o", "os", "para", "pero", "por", "porque", "que", "quien", "se", "sin",
            "sobre", "su", "sus", "tambien", "te", "tiene", "tu", "tus", "un", "una", "unas", "unos", "y", "ya"
    ));

    // Delimitadores: espacio + puntuación + símbolos comunes
    private static final String DELIMS = " \t\r\n.,;:¡!¿?\"'()[]{}<>/\\|@#$%^&*_+=~`-";

    public static void cargarArchivoEnArboles(String ruta, ArbolString todo, ArbolString significativas) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.toLowerCase();
                StringTokenizer st = new StringTokenizer(linea, DELIMS);

                while (st.hasMoreTokens()) {
                    String w = limpiar(st.nextToken());

                    // limpiar números puros o tokens raros
                    if (w.length() == 0) {
                        continue;
                    }

                    todo.insertar(w);

                    if (esSignificativa(w)) {
                        significativas.insertar(w);
                    }
                }
            }
        }
    }

    private static boolean esSignificativa(String w) {
        if (w.length() <= 2) {
            return false;   // recorta ruido tipo "a", "y", "de"
        }
        if (STOP.contains(w)) {
            return false;
        }
        return true;
    }

    public static String limpiar(String s) {
        s = s.toLowerCase();
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("\\p{M}", "");
        return s;
    }
}
