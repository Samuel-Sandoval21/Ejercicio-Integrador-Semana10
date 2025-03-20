/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaventa;

/**
 *
 * @author samu0
 */
public class Producto {

    private String nombre;
    private double[] ventasPorDia; // Ventas por cada día de la semana (7 días)

    // Constructor para inicializar el nombre y el arreglo de ventas
    public Producto(String nombre) {
        this.nombre = nombre;
        this.ventasPorDia = new double[7]; // 7 días de la semana
    }

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para obtener las ventas en un día específico
    public double getVentas(int dia) {
        if (dia >= 0 && dia < 7) {
            return ventasPorDia[dia];
        }
        return 0;
    }

    // Método para establecer las ventas de un día específico
    public void setVentas(int dia, double ventas) {
        if (dia >= 0 && dia < 7) {
            ventasPorDia[dia] = ventas;
        }
    }
}
