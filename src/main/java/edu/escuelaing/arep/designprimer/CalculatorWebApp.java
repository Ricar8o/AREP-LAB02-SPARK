package edu.escuelaing.arep.designprimer;

import static spark.Spark.*;

import edu.escuelaing.arep.app.model.Calculator;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class CalculatorWebApp 
{
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        post("/getMean",(req, res) -> calculateMean(req, res) ) ;
        post("/getDeviation",(req, res) -> calculateDeviation(req, res) ) ;
       
    }
    /**
     * Este metodo recibe una peticion con los datos a los cuales les va a sacar la media.
     * @param req Request
     * @param res Response
     * @return El valor de la media de los datos.
     */
    private static Double calculateMean(Request req, Response res) {
        Calculator calculator = new Calculator();
        String cadena = req.body().substring(10,req.body().length()-2);
        String[] datos = cadena.split(",");
        calculator.convertir(datos);
        Double media = calculator.mean();
        return media;
    }

    /**
     * Este metodo recibe una peticion con los datos a los cuales les va a sacar la desviacion estandar..
     * @param req Request
     * @param res Response
     * @return El valor de la desviacion de los datos.
     */
    private static String calculateDeviation(Request req, Response res) {
        Calculator calculator = new Calculator();
        System.out.println(req.body());
        return "Deviation";
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
