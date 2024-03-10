package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TipoIdentificacionTest {

    @Autowired
    public TipoIdentificacionService tipoIdentificacionService;



//   1. Consultar todos los tipo de identificación por estado ordenados alfabéticamente.

    @Test
    void test_findByEstadoOrderByNombreDesc(){
        String estadoTest =  "A";
        List<TipoIdentificacion> LsTipoIdentificacion = tipoIdentificacionService.findByEstadoOrderByEstadoDesc(estadoTest);
//        We hope it is 5, since there are only 4 in the database with that status and 1 inactive.
        assertEquals(5,LsTipoIdentificacion.size());
//        Now I`m going to lock each one inside the list, to verificate that they have A as their state, Also print it to check that their sorted in a correct way.
        System.out.println("                        Tipo Identificación - test_findByCodigoAndEstado\n                    Input Request: " +estadoTest + "\n-------------------------------------------------------");
        for (TipoIdentificacion tipoIdentificacion : LsTipoIdentificacion){
            assertEquals("A",tipoIdentificacion.getEstado());
            System.out.println("|Nombre:" + tipoIdentificacion.getNombre() + " |Estado:" + tipoIdentificacion.getEstado());

        }
    }

//    7.    Consultar tipo de identificación por código y estado.
    @Test
    void test_findByCodigoAndEstado(){
        List<TipoIdentificacion> LsTipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("CC", "A");
        System.out.println("                        Tipo Identificación - test_findByCodigoAndEstado\n                    Input Request: CC/A \n-------------------------------------------------------");
        for (TipoIdentificacion tipoIdentificacion : LsTipoIdentificacion){
            System.out.println("|Nombre:" + tipoIdentificacion.getNombre() + " |Codigo:" + tipoIdentificacion.getCodigo() + " | Estado:" + tipoIdentificacion.getEstado() + "|");
        }
        System.out.println("-------------------------------------------------------");

    }

}
