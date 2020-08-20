package edu.escuelaing.arep.app.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * La clase Calculator se encarga de leer datos, guardarlos y realizar operaciones matematicas con ellos.
 * @author Andres Ricardo Martinez Diaz
 * @version 1.0
 */
public class Calculator {

	private LinkedList<Double> datos;

	private String ruta;

	/**
	 * Constructor
	 */
	public Calculator() {
		datos = new LinkedList<Double>();
	}

	/**
	 * Metodo que calcula la media extraida de los datos.
	 * @return Media de los datos
	 */
	public double mean() {
		Double suma = 0.0;
		for(int i =0; i< datos.size(); i++) {
			suma += datos.get(i);
		}
		Double media = suma / datos.size();
		return media;
	}
	/**
	 * Metodo que calcula la desviacion estandar extraida de los datos.
	 * @param media El valor de la media de los datos.
	 * @return Desviacion estandar de los datos.
	 */
	public double deviation(Double media) {
		Double total = 0.0;
		for(int i =0; i< datos.size(); i++) {
			Double diff = datos.get(i) - media;
			Double cuad = diff * diff;
			total += cuad;
		}

		Double desviacion = Math.sqrt(total/(datos.size()-1));
		return desviacion;
	}

	/**
	 * Metodo que cambia la ruta.
	 * @param ruta Nueva ruta del archivo a leer.
	 */
	public void cambiarRuta(String ruta) {
		this.ruta = ruta;
	}
	
	/**
	 * Metodo que lee los datos numericos de un archivo y los guarda en la lista.
	 * @throws IOException En caso de que el archivo no exista o se genere un error al leerlo.
	 */
	public void leerDatos() throws IOException, NumberFormatException{
		datos = new LinkedList<Double>();
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		String linea;
		while((linea=br.readLine())!=null){
			Double dato = Double.parseDouble(linea);
			datos.add(dato);
		}
		br.close();
	}

	/**
	 * Metodo que informa la media y la desviacion estandar de los datos.
	 */
	public void calcular(){
		Double media = mean();
		Double desviacion = deviation(media);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("La media y la desviacion son: " + df.format(media) + " y " + df.format(desviacion));
	}

	/**
	 * Metodo que pregunta en consola la direccion del archivo donde se encuantran los datos e informa el resultado.
	 */
	public void preguntar() {
		System.out.print ("Por favor introduzca la direccion del archivo con los datos: ");
        Scanner entrada = new Scanner (System.in);
		cambiarRuta( entrada.nextLine () );
		entrada.close();

		try {
			leerDatos();
			calcular();
		} catch (NumberFormatException e) {
			System.out.println("El archivo: "+ ruta + " tiene un dato que no pudo ser leido como numero | " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("El archivo: "+ ruta + " no existe");
		} catch (IOException e) {
			System.out.println("El archivo: "+ ruta + " no pudo ser leido.");
		}
		//System.out.println(this.datos);
		
	}

	/**
	 * Este medoto convierte un arreglo de cadenas a una lista enlazada.
	 * @param lista arreglo de cadenas con los datos.
	 */
	public void convertir(String[] lista){
		for(String dato : lista){
            Double num = Double.parseDouble(dato);
			datos.add(num);
			System.out.println(num);
        }
	}
}
