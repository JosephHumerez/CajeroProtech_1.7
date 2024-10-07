/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoarchivos;

/**
 *
 * @author HP
 */

/**
 * Clase que representa un cliente del banco.
 * 
 * <p>Esta clase almacena la información básica de un cliente, incluyendo
 * su nombre, nombre de usuario, contraseña, saldo y moneda.
 * 
 * @author Joseph Humerez
 * @version 1.0
 */
public class Cliente {

    private String nombre; // El nombre del cliente
    private String username; // El nombre de usuario del cliente
    private String contraseña; // La contraseña del cliente
    private double saldo; // El saldo actual del cliente 
    private String moneda; // La moneda que el cliente utiliza
    private Convertir convertir; // Objeto para cnovertir monedas

    /**
     * Constructor de la clase Cliente.
     * 
     * <p>Inicializa un nuevo cliente con los datos proporcionados.
     * 
     * @param nombre El nombre del cliente.
     * @param username El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     * @param saldo El saldo inicial del cliente.
     * @param moneda La moneda que el cliente utilizará.
     */
    public Cliente(String nombre, String username, String contraseña, double saldo, String moneda) {
        this.nombre = nombre;
        this.username = username;
        this.contraseña = contraseña;
        this.saldo = saldo;
        this.moneda = moneda;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Obtiene el saldo del cliente.
     * 
     * @return El saldo actual del cliente.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene la moneda del cliente.
     * 
     * @return La moneda utilizada por el cliente.
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Deposita una cantidad en el saldo del cliente.
     * 
     * <p>Si la cantidad es mayor que cero, se suma al saldo actual.
     * 
     * @param cantidad La cantidad a depositar.
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad; // Actualiza el saldo en memoria
        }
    }

    /**
     * Retira una cantidad del saldo del cliente.
     * 
     * <p>Si la cantidad es válida y menor o igual al saldo actual,
     * se resta del saldo. 
     * 
     * @param cantidad La cantidad a retirar.
     * @return {@code true} si la operación fue exitosa, {@code false} en caso contrario.
     */
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad; // Actualiza el saldo en memoria
            return true;
        }
        return false;
    }

    /**
     * Convierte una cantidad de moneda de un tipo a otro.
     * 
     * <p>Si la cantidad es mayor que cero y la moneda existe, se actualiza el saldo
     * con el nuevo monto convertido.
     * 
     * @param mon La moneda actual.
     * @param cantidad La cantidad a convertir.
     * @param monA La moneda a la que se desea convertir.
     * @return {@code true} si la conversión fue exitosa, {@code false} en caso contrario.
     */
    public boolean convertir(String mon, double cantidad, String monA) {
        if (cantidad > 0) {
            convertir = new Convertir(mon, cantidad, monA);
            if (convertir.monedaExiste()) {
                saldo = convertir.convertirMoneda();//actualiza el saldo
                moneda = convertir.getMonedaActual();
                return true;
            }
            return false;
        }

        return false;
    }
}
