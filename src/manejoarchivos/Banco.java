/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoarchivos;

/**
 *
 * @author HP
 */
import java.io.*;
import java.util.*;

/**
 * Clase que representa un banco, encargado de gestionar una lista de clientes.
 * 
 * <p>Esta clase almacena los clientes en una lista y permite cargar los clientes desde
 * un archivo al momento de inicializar la clase.
 * 
 * @author Joseph Humerez
 * @version 1.0
 */
public class Banco {
    /**
     * Lista que almacena a los clientes del banco.
     */
    private List<Cliente> clientes;
    /**
     * Nombre del archivo que contiene los datos de los clientes.
     */
    private final String clientesFile = "clientes.txt";

    /**
     * Constructor de la clase Banco.
     * 
     * <p>Inicializa la lista de clientes y carga los datos desde el archivo
     * de clientes al momento de crear una instancia del banco.
     */
    public Banco() {
        clientes = new ArrayList<>();
        cargarClientes(); // Carga de clientes al iniciar
    }

    /**
 * Método que carga los datos de los clientes desde el archivo especificado.
 * 
 * <p>Lee el archivo de texto que contiene los datos de los clientes, separa la información
 * por comas y crea una instancia de {@link Cliente} para cada línea en el archivo. Los clientes
 * cargados son almacenados en la lista de clientes.
 * 
 * <p>En caso de que el archivo no exista o no se pueda leer, se muestra un mensaje de error
 * y se creará un archivo nuevo al registrar un cliente.
 * 
 * @author Joseph Humerez
 */
    private void cargarClientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(clientesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String nombre = datos[0];
                String username = datos[1];
                String contraseña = datos[2];
                double saldo = Double.parseDouble(datos[3]);
                String moneda = datos[4];
                clientes.add(new Cliente(nombre, username, contraseña, saldo, moneda));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de clientes. Se creará uno nuevo al registrar.");
        }
    }

 /**
 * Registra un nuevo cliente en el banco si el nombre no está ya registrado.
 * 
 * <p>Este método verifica si el cliente con el nombre proporcionado ya existe.
 * Si no existe, crea un nuevo cliente con un saldo inicial de 0, lo agrega
 * a la lista de clientes y guarda la lista actualizada en el archivo.
 * 
 * @param nombre El nombre del cliente.
 * @param username El nombre de usuario del cliente.
 * @param contraseña La contraseña del cliente.
 * @param moneda La moneda que el cliente utilizará.
 * @return {@code true} si el cliente se registró exitosamente, {@code false} si el nombre ya está registrado.
 * 
 * @author Joseph Humerez
 */
    public boolean registrarCliente(String nombre, String username, String contraseña, String moneda) {
        if (existeCliente(nombre)) {
            return false; // Nombre ya registrado
        }

        double saldoInicial = 0; // No establecer un saldo inicial
        Cliente nuevoCliente = new Cliente(nombre, username, contraseña, saldoInicial, moneda);
        clientes.add(nuevoCliente);
        guardarClientes(); // Guardar clientes después de agregar
        return true; // Registro exitoso
    }

 /**
 * Verifica si un cliente con el nombre dado ya está registrado en el banco.
 * 
 * <p>Este método recorre la lista de clientes y compara el nombre proporcionado
 * con el nombre de cada cliente existente. Si encuentra una coincidencia, devuelve
 * {@code true}, indicando que el cliente ya está registrado.
 * 
 * @param nombre El nombre del cliente que se quiere verificar.
 * @return {@code true} si el cliente ya existe, {@code false} si no está registrado.
 * 
 * @author Joseph Humerez
 */
    private boolean existeCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return true; // El cliente ya existe
            }
        }
        return false; // El cliente no existe
    }

 /**
 * Guarda la lista de clientes en un archivo de texto.
 * 
 * <p>Este método escribe los datos de cada cliente en el archivo de clientes, 
 * separando cada campo (nombre, username, contraseña, saldo y moneda) por comas.
 * Cada cliente se guarda en una nueva línea en el archivo.
 * 
 * <p>Si ocurre un error durante el proceso de escritura, se muestra un mensaje
 * indicando que hubo un error al guardar los clientes.
 * 
 * @author Joseph Humerez
 */
    public void guardarClientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientesFile))) {
            for (Cliente cliente : clientes) {
                // Guarda el nombre, username, contraseña, saldo y moneda en el archivo
                bw.write(cliente.getNombre() + "," + cliente.getUsername() + "," + cliente.getContraseña() + "," 
                        + cliente.getSaldo() + "," + cliente.getMoneda());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes.");
        }
    }

/**
 * Autentica un cliente utilizando su nombre de usuario y contraseña.
 * 
 * <p>Este método recorre la lista de clientes y busca un cliente cuyo nombre de usuario
 * y contraseña coincidan con los proporcionados. Si encuentra una coincidencia, devuelve
 * la instancia del cliente autenticado.
 * 
 * @param username El nombre de usuario del cliente.
 * @param contraseña La contraseña del cliente.
 * @return El objeto {@link Cliente} si la autenticación es exitosa, o {@code null} si falla.
 * 
 * @author Joseph Humerez
 */
    public Cliente autenticar(String username, String contraseña) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username) && cliente.getContraseña().equals(contraseña)) {
                return cliente; // Retorna el cliente autenticado
            }
        }
        return null; // Autenticación fallida
    }

 /**
 * Obtiene la lista de clientes del banco.
 * 
 * <p>Este método devuelve la lista completa de clientes registrados en el banco.
 * 
 * @return Una lista de objetos {@link Cliente} que representan a los clientes del banco.
 * 
 * @author Joseph Humerez
 */
    public List<Cliente> getClientes() {
        return clientes;
    }
}