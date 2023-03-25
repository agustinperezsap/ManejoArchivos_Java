package manejoarchivos;
//io significa input ouput

import java.io.*;

public class ManejoArchivos {
    //Creacion de archivo con permiso de escritura en la carpeta
    //

    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //escritura de un archivo pero sobrescribiendo lo que tenia 
    public static void escribirArchivos(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //anexar informacion o escritura a un archivo ya escrito 
    public static void anexarArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        //por inferrencia de tipo a la derecha del igual
        //podemos usar var para instancior un objeto
        var archivo = new File(nombreArchivo);

        try {
            //Buffered nos permite almacenar caractes a caracter
            // y por consiguente podemos leer lineas completas
            var entrada = new BufferedReader(new FileReader(archivo));//Abrimos un flujo
            
            var lectura = entrada.readLine();//leemos una linea 
            while (lectura != null) {//lee la linea entrada.readLine();
                System.out.println("lectura = " + lectura);//la imprime 
                lectura = entrada.readLine();//avanza a la siguiente linea
            }
            
            entrada.close();//cierre de flujo er
        } catch (FileNotFoundException ex) {

            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
