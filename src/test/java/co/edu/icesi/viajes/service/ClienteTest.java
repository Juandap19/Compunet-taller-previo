package co.edu.icesi.viajes.service;
import co.edu.icesi.viajes.dto.ClienteDTO;

import co.edu.icesi.viajes.repository.ClienteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import co.edu.icesi.viajes.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ClienteTest{


    @Autowired
    public ClienteService clienteService;


//    2. Consultar a todos los clientes por estado. Esta consulta debe ser paginada y ordenada de forma ascendente por número de identificación
    @Test
    void test_findByEstadoOrderByNumeroIdentificacionAsc(){

        Pageable pageable = PageRequest.of(0,10);
        String estadoTest = "A";
        List<Cliente> clientes = clienteService.findByEstadoOrderByNumeroIdentificacionAsc(estadoTest,pageable);
//        I Assert just to know that the method bring me in a correct way the clients with the state that I send, also i print it to look if it orders in correct way;
        System.out.println("                      Clientes - test_findByEstadoOrderByNumeroIdentificacionAsc \n                        Input Request: " + estadoTest +"\n-------------------------------------------------------");
        for (Cliente cliente : clientes){
            assertEquals("A",cliente.getEstado());
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Estado:" + cliente.getEstado() + "|");
        }
        System.out.println("-------------------------------------------------------");
    }


//    3.    Consultar a un cliente por correo electrónico. Esta consulta debe ignorar las mayúsculas y minúsculas.
    @Test
    void test_findByCorreoIgnoreCase(){
        String correoTest = "JUANdA232405@hOTmaIl.cOm";
        List<Cliente> clientes = clienteService.findByCorreoIgnoreCase(correoTest);
        System.out.println("                        Clientes - test_findByCorreoIgnoreCase\n                    Input Request:" + correoTest +"\n-------------------------------------------------------");
        for (Cliente cliente : clientes){
//        Preguntar el siguiente assert Equals
//        assertEquals(clienteService.findById(1),cliente);
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Correo:" + cliente.getCorreo() + "|");
        }
        System.out.println("-------------------------------------------------------");

    }


//    4.    Consultar cliente por número de identificación, usando LIKE
    @Test
    void test_findByNumeroIdentificacionLike(){
        String numeroIdTest = "6789012344";
        List<Cliente> clientes = clienteService.findByNumeroIdentificacionLike(numeroIdTest);
        System.out.println("                        Clientes - test_findByNumeroIdentificacionLike \n                    Input Request:"+ numeroIdTest +" \n-------------------------------------------------------");
        for (Cliente cliente : clientes){
            assertEquals("6789012344",cliente.getNumeroIdentificacion());
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Estado:" + cliente.getEstado() + "|");
        }
        System.out.println("-------------------------------------------------------");

    }

//    5.    Consultar al cliente por nombre, ignorando Mayúsculas y minúsculas, usando LIKE.
    @Test
    void test_findByNombreIsLikeIgnoreCase(){
//        The input is in a completely otherway, changing the lower Cases for the Upper Cases and in vice versa
        String name_test =  "aNA aLEXANDRAA";
        List<Cliente> clientes = clienteService.findByNombreIsLikeIgnoreCase(name_test);

        System.out.println("                        Clientes - test_findByNombreIsLikeIgnoreCase\n                    Input Request:" + name_test + " \n-------------------------------------------------------");
        for (Cliente cliente : clientes){
            assertEquals("Ana Alexandraa",cliente.getNombre());
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Estado:" + cliente.getEstado() + "|");
        }
        System.out.println("-------------------------------------------------------");

    }


//    6.    Consultar clientes por rango de fecha (Se debe pasar dos fechas y traer los clientes cuya fecha de nacimiento se encuentre entre el rango ingresado).
    @Test
    void test_findByTwoDates(){

        String date1Test = "2003-01-12";
        String date2Test = "2010-12-12";

        SimpleDateFormat sf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = Date.valueOf(date1Test);
        Date date2 = Date.valueOf(date2Test);
        List<Cliente> clientes = clienteService.findByTwoDates(date2,date1);
        System.out.println("                        Clientes - test_findByTwoDates\n                    Input Request: " + date1Test + "/"+ date2Test+ " \n-------------------------------------------------------");
        for (Cliente cliente : clientes){
 /* We verify with this assert that date 1 is before any birth since it should have this as a limit although and the date 2 es the other limit , the test fails if the dates coincides with any of the clients, but the repository method works correctly since it does bring it although as
    We use a method before then the test would be damaged, although it is the most efficient way to improve it.*/
            assertTrue(date1.before(cliente.getFechaNacimiento()));
            assertTrue(date2.after(cliente.getFechaNacimiento()));
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Fecha Nacimiento:" + cliente.getFechaNacimiento() + "|");
        }
        System.out.println("-------------------------------------------------------");

    }

//    8.    Consultar el total de clientes por estado.
    @Test
    void test_findByEstado() {
// adding a var whoose name is estado, just to facilitate the testing, cause if you want to change te value inside the estado will be easy.
        String estado = "A";
        long clientes = clienteService.countByEstado(estado);
        System.out.println("          Clientes - test_findByEstado\n               Input Request: "+ estado + " \n----------------------------------------------");
        System.out.println("|Cantidad de clientes: " + clientes + " |Estado: " + estado + " |");
        System.out.println("---------------------------------------------");

//        With this assert We check that we are not bring a simple count, cause the Repository we have 11 but 1 has the state I.
        assertNotEquals(clientes,clienteService.count());

    }


//    9.    Consultar clientes por tipo de identificación. Debe de ser paginado
    @Test
    void test_findByTipoIdentificacionPageable() {
        Pageable pageable = PageRequest.of(0,10);
        String tipo = "CC";
        List<Cliente> clientes = clienteService.findByTipoIdentificacion(tipo ,pageable);
        System.out.println("          Clientes - test_findByTipoIdentificacionPageable\n               Input Request: " + tipo + " \n----------------------------------------------");
        for (Cliente cliente : clientes) {
//            We have to know that CC is a foreigner Key an in the client we represent it as 1.
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Tipo Identificación:" + cliente.getIdTiid() + "|");
        }
        System.out.println("---------------------------------------------");

    }


//      10. Consultar clientes por apellido (tener en cuenta los campos primer y segundo apellido)

    @Test
    void test_findByPrimerApellidoAndSegundoApellido(){
        String apellido1Test = "Becerra";
        String apellido2Test = "Pérez";
        List<Cliente> clientes = clienteService.findByPrimerApellidoAndSegundoApellido(apellido1Test,apellido2Test);;
        System.out.println("          Clientes - test_findByPrimerApellidoAndSegundoApellido\n               Input Request: " + apellido1Test + "/" +apellido2Test + " \n----------------------------------------------");
        for (Cliente cliente : clientes) {
            System.out.println("|Nombre:" + cliente.getNombre() + " |Primer Apellido:" + cliente.getPrimerApellido() + " |Segundo Apellido:" + cliente.getSegundoApellido() + "|");
        }
        System.out.println("---------------------------------------------");

    }


    /* 15.0 Realizar una consulta que ustedes crean que generan valor a la hora de consultar los datos para los clientes (consulta que consideren que sea util).
        15.1 Consultar por Genero.
    */
    @Test
    void test_findByConsultarClientePorSexo(){
        String sextoTest = "M";
        List<ClienteDTO> clientes = clienteService.consultarClientePorSexo(sextoTest);
        System.out.println("          Clientes - test_findByConsultarClientePorSexo\n                   Input Request: " + sextoTest + " \n----------------------------------------------");
        for (ClienteDTO cliente : clientes){
            assertEquals("M",cliente.getSexo());
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " |Tipo Identificación:" + cliente.getIdTiid() + "|");
        }
        System.out.println("---------------------------------------------");

    }
     /*
        15.0 Realizar una consulta que ustedes crean que generan valor a la hora de consultar los datos para los clientes (consulta que consideren que sea util).
            15.2 Consultar  la lista de los 3 clientes Activos que se hayan gastado más dinero, considero que genera valor puesto que si se desea dar un bono a los más inversores. ;
    */

    @Test
    void test_findByTop3ActiveClientsSpent(){
        List<ClienteDTO> clientes = clienteService.test_findByTop3ActiveClientsSpent();
        System.out.println("          Clientes - test_findByTop3ActiveClientsSpentLeastTime\n                   Input Request: N/A" + "\n----------------------------------------------");
        for (ClienteDTO cliente : clientes){
            System.out.println("|Nombre:" + cliente.getNombre() + " |Dinero Gastado:" + cliente.getSumatoriaPagos());
        }
        System.out.println("---------------------------------------------");
    }


    //16.    Consultar todos los clientes con los siguientes filtros: Estado, número identificación, tipo de identificación, nombre (con Like) en orden ascendente. (debe de ser una sola consulta y los filtros pueden ser opcionales).
    @Test
    void test_consultarClientePorFiltros(){
        String numeroIDTest = "110%";
        String nombreTest =  "J%";
        String estadoTest = "A%";
        int id_tiidTest = 1;
        List<ClienteDTO> lstCliente = clienteService.consultarClienteFiltros(numeroIDTest,nombreTest,estadoTest,id_tiidTest);
        System.out.println("          Clientes - test_consultarClientePorFiltros\n               Input Request: " + numeroIDTest + "/"+ nombreTest + "/"+ estadoTest + "/" + id_tiidTest + " \n----------------------------------------------");
        for (ClienteDTO cliente: lstCliente){
            System.out.println("|Nombre:" + cliente.getNombre() + " |Numero Identificación:" + cliente.getNumeroIdentificacion() + " | Tipo Identificación:" + cliente.getIdTiid() + "|");
        }
        System.out.println("---------------------------------------------");

    }

}
