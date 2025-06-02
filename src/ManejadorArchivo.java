import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivo {
    private static String pathOrigen;
    private static String pathDestino;

    public ManejadorArchivo(String Origen, String Destino){
        pathOrigen = Origen;
        pathDestino = Destino;
    }

    public static List<Proceso> leerProcesosDesdeCSV() {
        List<Proceso> listaProcesos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathOrigen))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos.length < 6) continue; // Salta líneas inválidas

                int id = Integer.parseInt(campos[0].trim());
                int prioridad = Integer.parseInt(campos[1].trim());
                String tipo = campos[2].trim();
                int horaInicio = Integer.parseInt(campos[3].trim());
                int horaFin = Integer.parseInt(campos[4].trim());
                String motivo = campos[5].trim();

                Proceso proceso = new Proceso(prioridad, id, tipo, horaInicio, motivo);
                listaProcesos.add(proceso);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un valor numérico: " + e.getMessage());
        }
        return listaProcesos;
    }
    public static void escribirProcesosEnCSV(List<Proceso> procesos ) {
        File archivo = new File(pathDestino);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir encabezado (opcional)
            writer.write("ID proceso,Prioridad,Tipo,Hora de llegada,Hora de atencion,Motivo");
            writer.newLine();

            // Escribir cada proceso como una línea
            for (Proceso p : procesos) {
                String linea = String.format("%d,%d,%s,%d,%d,%s",
                        p.getIdProceso(),
                        p.getPrioridad(),
                        p.getTipoProceso(),
                        p.getHoraInicio(),
                        p.getHoraFin(),
                        p.getMotivo());

                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Archivo escrito correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}

