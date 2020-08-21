package edu.escuelaing.arep.designprimer;

import static spark.Spark.*;

import edu.escuelaing.arep.app.model.Calculator;
import spark.Request;
import spark.Response;

/**
 * CalculatorWebApp provee la API para consultar la media y la desviacion estandar a partir de un conjunto de datos.
 * @author Ricardo Martinez
 * @version 1.0
 */ 
public class CalculatorWebApp 
{
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        post("/getMean-Deviation",(req, res) -> calculate(req, res) ) ;
       
    }
    /**
     * Este metodo recibe una peticion con los datos a los cuales les va a sacar la media.
     * @param req Request
     * @param res Response
     * @return El valor de la media y la desviacion estandar de los datos, separados por una linea.
     */
    private static String calculate(Request req, Response res) {
        Calculator calculator = new Calculator();
        String cadena = req.body().substring(10,req.body().length()-2);
        String[] datos = cadena.split(",");
        calculator.convertir(datos);
        Double media = calculator.mean();
        Double desviacion = calculator.deviation(media);
        return media + "-" + desviacion;
    }


    /**
     * This method reads the default port as specified by the PORT variable in the
     * environment.
     *
     * Heroku provides the port automatically so you need this to run the project on
     * Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    
}
