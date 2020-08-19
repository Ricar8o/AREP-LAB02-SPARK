package edu.escuelaing.arep.designprimer;
import static spark.Spark.*;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class CalculatorWebApp 
{
    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }
    
    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + "  First name:<br>"
                + "  <input type=\"text\" id=\"firstname\" name=\"firstname\" value=\"Mickey\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Add\" onclick=\"myFunction();return false;\">"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Submit\" >"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                
                + "<table style=\"width:30%\">"
                +   " <tr>"
                +        "<th>DATOS</th>"
                +   " </tr>"
                +    "<tbody id=\"datos\" name=\"datos\">"
                +    "</tbody>"
                + "</table>"


                + "<script>"
                + "function myFunction() {\n"
                + "var dato = document.getElementById(\"firstname\").value;\n"
                + "var fila = '<tr><td>' + dato  + '</td></tr>';\n"
                + "var tabla = document.getElementById(\"datos\");"
                + "tabla.innerHTML += fila;"
                + "}\n"
                + "</script>"

                + "</body>"
                + "</html>";
                
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        // return req.queryParams("firstname") + " " +
        //         req.queryParams("lastname");
        System.out.println(req.contentLength());
        return "Holaaa";
    }   
    
}
