/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoarchivos;

/**
 *
 * @author HP
 */
public class Convertir {

    private String moneda;
    private double valorMonetario;
    private double saldo;
    private String monedaAnterior;

    public Convertir(String moneda, double saldo, String monedaAnterior) {
        this.moneda = moneda;
        this.saldo = saldo;
        this.monedaAnterior = monedaAnterior;
    }
    
    public String getMonedaActual(){
        return moneda;
    }

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

    public double convertirMoneda() {
        if (monedaValor()) {
            saldo = saldo / valorMonetario;
            return saldo;
        }
        return saldo;
    }

    public String getNuevaMoneda() {
        if(monedaValor()){
            return moneda;
        }
        return monedaAnterior;
    }

    public boolean monedaExiste() {
        return habilitarMoneda() && habilitarMonedaA();
    }
}
