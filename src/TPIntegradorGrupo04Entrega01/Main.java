package TPIntegradorGrupo04Entrega01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pronostico pronosticos = new Pronostico();
        List<Partido> partidos = new ArrayList<>();
        List<Ronda> rondas = new ArrayList<>();

        String archivo = "src/TPIntegradorGrupo04Entrega01/resultados.csv";
        LeerArchivo archivoResultados = new LeerArchivo();

        for (String[] partido: archivoResultados.registros(archivo)) {
             partidos.add(new Partido(new Equipo(partido[0],""),new Equipo(partido[3],""),Integer.parseInt(partido[1]),Integer.parseInt(partido[2])));
             rondas.add(new Ronda(1,partidos));
       }
        //rondas.get(0).partidos();
        System.out.println("Puntaje = " + pronosticos.puntaje(partidos));

  }
}
