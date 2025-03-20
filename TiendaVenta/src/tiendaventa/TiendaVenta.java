/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaventa;

import javax.swing.JOptionPane;

/**
 *
 * @author samu0
 */
public class TiendaVenta {

    /**
     * Metodo que ejecuta el programa
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Nombres de los productos en la tienda
        String[] productos = {"Arroz", "Azúcar", "Leche"};

        // Crear una instancia de Venta con los productos
        Venta venta = new Venta(productos);

        // Generar ventas aleatorias
        venta.generarVentas();

        // Obtener los totales por producto
        double[] totalesPorProducto = venta.obtenerTotalesPorProducto();

        // Crear el mensaje de resultados
        String mensaje = "Total de ventas por producto:\n";

        for (int i = 0; i < productos.length; i++) {
            mensaje += productos[i] + ": " + totalesPorProducto[i] + "\n";
        }

        // Día con mayores ventas
        mensaje += "\nEl día con mayores ventas fue " + venta.obtenerDiaConMasVentas() + ".";

        // Producto más vendido
        mensaje += "\nEl producto más vendido fue " + venta.obtenerProductoMasVendido() + ".";

        // Mostrar el resultado en un cuadro de mensaje
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
