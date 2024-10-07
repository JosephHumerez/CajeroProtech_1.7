/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoarchivos;

/**
 * Clase que maneja la conversión de monedas.
 * 
 * <p>Esta clase permite convertir un valor monetario de una moneda a otra,
 * utilizando tasas de conversión predefinidas.
 * 
 * @author Joseph Humerez
 * @version 1.0
 */
public class Convertir {

    private String moneda; // La moneda actual en la que se encuentra el saldo
    private double valorMonetario; // El valor monetario a convertir
    private double saldo; // El saldo del cliente que se va a convertir
    private String monedaAnterior; // La moneda anterior antes de la conversion

    /**
     * Constructor de la clase Convertir.
     * 
     * <p>Inicializa un nuevo objeto Convertir con los datos de moneda,
     * saldo y moneda anterior.
     * 
     * @param moneda La moneda actual.
     * @param saldo El saldo a convertir.
     * @param monedaAnterior La moneda previa a la conversión.
     */
    public Convertir(String moneda, double saldo, String monedaAnterior) {
        this.moneda = moneda;
        this.saldo = saldo;
        this.monedaAnterior = monedaAnterior;
    }
    
    /**
     * Obtiene la moneda actual.
     * 
     * @return La moneda actual.
     */
    public String getMonedaActual(){
        return moneda;
    }

    /**
     * Verifica si la moneda actual es válida.
     * 
     * @return {@code true} si la moneda es válida, {@code false} en caso contrario.
     */
    private boolean habilitarMoneda() {
        switch (moneda) {
            case "Dolar" -> {
                return true;
            }
            case "Euro" -> {
                return true;
            }
            case "Sol" -> {
                return true;
            }
            case "Real" -> {
                return true;
            }
            case "Yen" -> {
                return true;
            }
            case "Boliviano" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Verifica si la moneda anterior es válida.
     * 
     * @return {@code true} si la moneda anterior es válida, {@code false} en caso contrario.
     */
    private boolean habilitarMonedaA() {
        switch (monedaAnterior) {
            case "Dolar" -> {
                return true;
            }
            case "Euro" -> {
                return true;
            }
            case "Sol" -> {
                return true;
            }
            case "Real" -> {
                return true;
            }
            case "Yen" -> {
                return true;
            }
            case "Boliviano" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Asigna un valor monetario basado en la conversión de la moneda actual a la moneda anterior.
     * 
     * @return {@code true} si se pudo asignar un valor monetario, {@code false} en caso contrario.
     */
    private boolean monedaValor() {
        if (monedaExiste()) {
            if (moneda.equals("Dolar")) {
                switch (monedaAnterior) {
                    case "Dolar" -> {
                        valorMonetario = 1;
                        return true;
                    }
                    case "Sol" -> {
                        valorMonetario = 3.74;
                        return true;
                    }
                    case "Real" -> {
                        valorMonetario = 5.46;
                        return true;
                    }
                    case "Yen" -> {
                        valorMonetario = 148.72;
                        return true;
                    }
                    case "Boliviano" -> {
                        valorMonetario = 6.94;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            } else if (moneda.equals("Sol")) {
                switch (monedaAnterior) {
                    case "Dolar" -> {
                        valorMonetario = 0.27;
                        return true;
                    }
                    case "Sol" -> {
                        valorMonetario = 1;
                        return true;
                    }
                    case "Real" -> {
                        valorMonetario = 1.46;
                        return true;
                    }
                    case "Yen" -> {
                        valorMonetario = 39.77;
                        return true;
                    }
                    case "Boliviano" -> {
                        valorMonetario = 1.86;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            } else if (moneda.equals("Real")) {
                switch (monedaAnterior) {
                    case "Dolar" -> {
                        valorMonetario = 0.18;
                        return true;
                    }
                    case "Sol" -> {
                        valorMonetario = 0.69;
                        return true;
                    }
                    case "Real" -> {
                        valorMonetario = 1;
                        return true;
                    }
                    case "Yen" -> {
                        valorMonetario = 27.25;
                        return true;
                    }
                    case "Boliviano" -> {
                        valorMonetario = 1.27;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            } else if (moneda.equals("Yen")) {
                switch (monedaAnterior) {
                    case "Dolar" -> {
                        valorMonetario = 0.0067;
                        return true;
                    }
                    case "Sol" -> {
                        valorMonetario = 0.025;
                        return true;
                    }
                    case "Real" -> {
                        valorMonetario = 0.37;
                        return true;
                    }
                    case "Yen" -> {
                        valorMonetario = 1;
                        return true;
                    }
                    case "Boliviano" -> {
                        valorMonetario = 0.47;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            } else if (moneda.equals("Boliviano")) {
                switch (monedaAnterior) {
                    case "Dolar" -> {
                        valorMonetario = 0.14;
                        return true;
                    }
                    case "Sol" -> {
                        valorMonetario = 0.54;
                        return true;
                    }
                    case "Real" -> {
                        valorMonetario = 0.79;
                        return true;
                    }
                    case "Yen" -> {
                        valorMonetario = 21.45;
                        return true;
                    }
                    case "Boliviano" -> {
                        valorMonetario = 1;
                        return true;
                    }
                    default -> {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Convierte el saldo de la moneda actual a la nueva moneda.
     * 
     * @return El nuevo saldo después de la conversión.
     */
    public double convertirMoneda() {
        if (monedaValor()) {
            saldo = saldo / valorMonetario;
            return saldo;
        }
        return saldo;
    }

    /**
     * Obtiene la nueva moneda después de la conversión.
     * 
     * @return La nueva moneda si la conversión fue exitosa, de lo contrario, devuelve la moneda anterior.
     */
    public String getNuevaMoneda() {
        if(monedaValor()){
            return moneda;
        }
        return monedaAnterior;
    }

    /**
     * Verifica si la moneda actual y anterior son válidas.
     * 
     * @return {@code true} si ambas monedas existen, {@code false} en caso contrario.
     */
    public boolean monedaExiste() {
        return habilitarMoneda() && habilitarMonedaA();
    }
}
