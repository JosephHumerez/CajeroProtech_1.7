/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoarchivos;

/**
 *
 * @author HP
 */
public class Cliente {

    private String nombre;
    private String username;
    private String contraseña;
    private double saldo;
    private String moneda;
    private Convertir convertir;

    public Cliente(String nombre, String username, String contraseña, double saldo, String moneda) {
        this.nombre = nombre;
        this.username = username;
        this.contraseña = contraseña;
        this.saldo = saldo;
        this.moneda = moneda;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad; // Actualiza el saldo en memoria
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad; // Actualiza el saldo en memoria
            return true;
        }
        return false;
    }

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
