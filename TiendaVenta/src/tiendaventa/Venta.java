/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaventa;

import java.util.Random;

/**
 * Clase que gestiona las ventas de productos y calcula los resultados.
 *
 * @author samu0
 */
public class Venta {

    private Producto[] productos;
    private Random random;

    // Constructor que recibe los nombres de los productos
    public Venta(String[] nombresProductos) {
        productos = new Producto[nombresProductos.length];
        random = new Random();

        // Crear los productos
        for (int i = 0; i < nombresProductos.length; i++) {
            productos[i] = new Producto(nombresProductos[i]);
        }
    }

    /**
     * Genera ventas aleatorias para cada producto por cada día de la semana.
     */
    public void generarVentas() {
        // Asignación de ventas aleatorias para cada producto (0-9)
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < 7; j++) {
                // Genera una venta aleatoria entre 0 y 9
                int ventaDia = random.nextInt(10);
                productos[i].setVentas(j, ventaDia);
            }
        }
    }

    /**
     * Calcula el total de ventas por producto.
     *
     * @return Un arreglo con los totales de ventas por producto.
     */
    public double[] obtenerTotalesPorProducto() {
        double[] totales = new double[productos.length];

        for (int i = 0; i < productos.length; i++) {
            double total = 0;
            for (int j = 0; j < 7; j++) {
                total += productos[i].getVentas(j);
            }
            totales[i] = total;
        }

        return totales;
    }

    /**
     * Encuentra el día con las mayores ventas totales.
     *
     * @return El nombre del día con mayores ventas totales.
     */
    public String obtenerDiaConMasVentas() {
        double[] ventasPorDia = new double[7];

        // Acumulamos las ventas por cada día
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < productos.length; i++) {
                ventasPorDia[j] += productos[i].getVentas(j);
            }
        }

        // Identificamos el día con las mayores ventas
        int diaMayorVenta = 0;
        for (int j = 1; j < ventasPorDia.length; j++) {
            if (ventasPorDia[j] > ventasPorDia[diaMayorVenta]) {
                diaMayorVenta = j;
            }
        }

        // Retornar el nombre del día con más ventas (lunes = 0, martes = 1, etc.)
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return dias[diaMayorVenta];
    }

    /**
     * Encuentra el producto más vendido.
     *
     * @return El nombre del producto más vendido con su total de ventas.
     */
    public String obtenerProductoMasVendido() {
        double maxVentas = 0;
        int indiceProductoMasVendido = 0;

        // Encontramos el producto con más ventas
        for (int i = 0; i < productos.length; i++) {
            double totalVentasProducto = 0;
            for (int j = 0; j < 7; j++) {
                totalVentasProducto += productos[i].getVentas(j);
            }

            if (totalVentasProducto > maxVentas) {
                maxVentas = totalVentasProducto;
                indiceProductoMasVendido = i;
            }
        }

        return productos[indiceProductoMasVendido].getNombre() + " con " + maxVentas + " unidades.";
    }
}
