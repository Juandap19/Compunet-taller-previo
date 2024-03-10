package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TipoDestinoTest {
    
//    TDD desarrollo basado en pruebas.
    
    @Autowired
    private TipoDestinoService tipoDestinoService;
    
    @Test
    void test_tipoDestinoFindAll(){
        List< TipoDestino> lsTipoDestino = tipoDestinoService.findAll();

        for (TipoDestino tipoDestino :lsTipoDestino) {
            System.out.println(tipoDestino.getCodigo() + " --- " + tipoDestino.getNombre());
        }
    }

    @Test
    void test_tipoDestinoFindById(){
        Optional<TipoDestino> result = tipoDestinoService.findById(4);
        System.out.println(result);
    }



    @Test
    void test_tipoDestinoSave() throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formato.parse("27/02/2024");

        TipoDestino tipoDestino = new TipoDestino();
        tipoDestino.setIdTide(10);
        tipoDestino.setCodigo("PNCA");
        tipoDestino.setNombre("Panaca");
        tipoDestino.setDescripcion("Panaca, un lugar donde divertirte no es problema");
        tipoDestino.setFechaCreacion(date1);
        tipoDestino.setUsuCreador("jdpz");
        tipoDestino.setEstado("A");
        tipoDestinoService.update(tipoDestino);

        try {
            TipoDestino savedTipoDestino = tipoDestinoService.save(tipoDestino);
            System.out.println(savedTipoDestino);
            assertNotNull(savedTipoDestino.getIdTide());
        } catch (Exception e) {
            fail("Exception not expected");
        }

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        for(TipoDestino tipoDestinos : lstTipoDestino) {
            System.out.println(tipoDestinos.getCodigo() + "-" + tipoDestinos.getNombre());
        }



    }

    @Test
    void test_tipoDestinoUpdate() throws Exception {

        TipoDestino td = tipoDestinoService.findById(3).get();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formato.parse("27/02/2024");
        td.setNombre("Museo De Bellas Artes");
        td.setCodigo("MDB");
        td.setFechaModificacion(date1);
        tipoDestinoService.update(td);
        System.out.println( "Destino:" + td.getCodigo() + "-" + td.getNombre() + " Actualizado");
    }

    @Test
    void test_tipoDestinoDelete() throws Exception {
        TipoDestino tipoDestino = tipoDestinoService.findById(10).get();
        tipoDestinoService.delete(tipoDestino);
        System.out.println( "Destino:" + tipoDestino.getCodigo() + "-" + tipoDestino.getNombre() + " Eliminado");

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        for(TipoDestino tipoDestinos : lstTipoDestino) {
            System.out.println(tipoDestinos.getCodigo() + "-" + tipoDestinos.getNombre());
        }
    }

    @Test
    void test_tipoDestinoDeleteByID() throws Exception {
        test_tipoDestinoSave();
        tipoDestinoService.deleteById(10);
        System.out.println("-------------------");
        System.out.println( "Destino con id 10 Eliminado");

        List<TipoDestino> lstTipoDestino = tipoDestinoService.findAll();

        for(TipoDestino tipoDestinos : lstTipoDestino) {
            System.out.println(tipoDestinos.getCodigo() + "-" + tipoDestinos.getNombre());
        }
    }

    @Test
    void test_tipoDestinoCount() {
        System.out.println("Cantidad de tipos de destino:" + tipoDestinoService.count());
    }


    @Test
    void  test_findByCodigoAndEstado(){
        List< TipoDestino> lsTipoDestino = tipoDestinoService.findByCodigoAndEstado("Playa","A");
        for (TipoDestino tipoDestino :lsTipoDestino) {
            System.out.println(tipoDestino.getCodigo() + " --- " + tipoDestino.getNombre());
        }
    }

//    14. Consultar los tipos de destino ordenados alfabéticamente.

    @Test
    void test_finAllOrderByNombreAsc(){
        List<TipoDestino> tipoDestinos = tipoDestinoService.finAllOrderByNombreAsc();
        System.out.println("                        Tipo Destino - test_finAllOrderByNombreAsc\n                    Input Request: NA \n-------------------------------------------------------");
        for (TipoDestino tipoDestino : tipoDestinos){
            assertEquals("A",tipoDestino.getEstado());
            System.out.println("|Nombre Tipo Destino:" + tipoDestino.getNombre() + " |Codigo:" + tipoDestino.getCodigo() + " |Estado: "+tipoDestino.getEstado() + "|");
        }
        System.out.println("---------------------------------------------------");

    }

}
