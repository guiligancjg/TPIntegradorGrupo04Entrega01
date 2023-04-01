package TPIntegradorGrupo04Entrega01;

import java.util.List;

public class Pronostico{
    String equipo1;
    String gana1;
    String empata;
    String gana2;
    String equipo2;
    ResultadoEnum resultado;

    public Pronostico(){}

    public Pronostico(String equipo1, String gana1, String empata, String gana2, String equipo2, ResultadoEnum resultado) {
        this.equipo1 = equipo1;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public int puntos(){
        if((resultado.equals(ResultadoEnum.GANADOR) && gana1.equals("x")) || (resultado.equals(ResultadoEnum.EMPATE) && empata.equals("x")) || (resultado.equals(ResultadoEnum.GANADOR) && gana2.equals("x"))){
            return 1;
        }
            return 0;
    }

    public int puntaje(List<Partido> partidos){
        String archivo = "src/TPIntegradorGrupo04Entrega01/pronostico.csv";
        LeerArchivo archivoPronosticos = new LeerArchivo();

        int indice = 0;
        int puntos = 0;
        for(String[] pronostico: archivoPronosticos.registros(archivo)) {
            if(pronostico[1].equals("x")){//Gana1
                Pronostico pronosticos = new Pronostico(pronostico[0],pronostico[1],pronostico[2],pronostico[3],pronostico[4],partidos.get(indice).resultado(partidos.get(indice).golesEquipo1,partidos.get(indice).golesEquipo2));
                puntos += pronosticos.puntos();
            }

            if(pronostico[3].equals("x")){//Gana2
                Pronostico pronosticos = new Pronostico(pronostico[0],pronostico[1],pronostico[2],pronostico[3],pronostico[4],partidos.get(indice).resultado(partidos.get(indice).golesEquipo2,partidos.get(indice).golesEquipo1));
                puntos += pronosticos.puntos();
            }

            if(pronostico[2].equals("x")){//Empata
                Pronostico pronosticos = new Pronostico(pronostico[0],pronostico[1],pronostico[2],pronostico[3],pronostico[4],partidos.get(indice).resultado(partidos.get(indice).golesEquipo1,partidos.get(indice).golesEquipo2));
                puntos += pronosticos.puntos();
            }
            indice++;
        }
        return puntos;
    }

}
