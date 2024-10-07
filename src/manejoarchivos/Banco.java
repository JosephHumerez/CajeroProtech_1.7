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

public class Banco {
    private List<Cliente> clientes;
    private final String clientesFile = "clientes.txt";

    public Banco() {
        clientes = new ArrayList<>();
        cargarClientes(); // Carga de clientes al iniciar
    }

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

    private boolean existeCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return true; // El cliente ya existe
            }
        }
        return false; // El cliente no existe
    }

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

    public Cliente autenticar(String username, String contraseña) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username) && cliente.getContraseña().equals(contraseña)) {
                return cliente; // Retorna el cliente autenticado
            }
        }
        return null; // Autenticación fallida
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}