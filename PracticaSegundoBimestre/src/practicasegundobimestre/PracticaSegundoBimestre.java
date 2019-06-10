package practicasegundobimestre;

// Se importan los java.util necesarios
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author BrandonVS
 */
public class PracticaSegundoBimestre {

    /**
     * @param args the command line arguments
     */
    // Se lee el registro del archivo
    public static void leerTabla(){
        
        // Se abre el archivo
        try
        {
         // Se lee el archivo usando el Scanner
         Scanner scan = new Scanner(new File("data/tabula-FWC_2018_Squadlists_"
                 + "4.csv"));
        // Se declaran las variables
        int contador = 0;
        double promG = 0;
        double promH = 0;
        
        // Se crea el ciclo while para asignar y acumular valores
        while (scan.hasNext()){
            String linea = scan.nextLine();
            
            // Se buscan los datos del archivo
            ArrayList<String> linea_partes = new ArrayList<>(Arrays.asList
                (linea.split("\\|")));
            double goles = Double.parseDouble(linea_partes.get(11));
            double height = Double.parseDouble(linea_partes.get(9));
            
            // Se acumulan los datos
            promG = goles + promG;
            promH = height + promH;
            contador++;
        }
        // Se calculan los promedios
        promG = promG / contador;
        promH = promH / contador;
        
        // Se imprime el resultado
        System.out.printf("El promedio de goles es de: %.2f\nEl promedio de a"
                + "ltura es de: %.2f", promG, promH);
        }
        // Impresion en caso de que no se puedan leer los datos
        catch(Exception e){
            System.err.println("Error al leer el archivo");
            System.exit(1);
            
        }
    }   
}
