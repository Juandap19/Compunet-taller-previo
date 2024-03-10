package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.Destino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DestinoTest {

    @Autowired
    public DestinoService destinoService;


//    11. Consultar un destino por código y estado activo.
    @Test
    void test_findByCodigoAndEstado(){
        String codigoTest = "1234";
        List<Destino> destinos = destinoService.findByCodigoAndEstado(codigoTest);
        System.out.println("                    Destinos - test_findByCodigoAndEstado\n                    Input Request:" + codigoTest + " \n-------------------------------------------------------");
        for (Destino destino : destinos){
            assertEquals(codigoTest,destino.getCodigo());
            assertEquals("A",destino.getEstado());

            System.out.println("|Nombre Destino:" + destino.getNombre() + " |Codigo:" + destino.getCodigo() + " |Estado: "+ destino.getEstado());
        }
        System.out.println("-----------------------------------------------------");

    }

    //13. Consultar todos los destinos activos, mostrando que tipo de destino es.
    @Test
    void test_findAllDestinosWithActiveType() {
        List<Object[]> destinos = destinoService.findAllDestinosWithActiveType();
        System.out.println("                    Destinos - findAllDestinosWithActiveType\n                    Input Request: N/A \n-------------------------------------------------------");
        for (Object[] destinoArray : destinos) {
            Destino destino = (Destino) destinoArray[0];
            String tipoDestinoName = (String) destinoArray[1];
            String tipoDestinoDescription = (String) destinoArray[2];
            System.out.println("|Destino: " + destino.getNombre() + " |Nombre Tipo Destino:" + tipoDestinoName + " |Descripción Tipo Destino:" + tipoDestinoDescription + " |Estado:"+ destino.getEstado()+ "|");
        }
        System.out.println("-----------------------------------------------------");

    }



}
