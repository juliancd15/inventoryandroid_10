package com.example.inventoryandroid_10;

import java.io.Serializable;

public class Producto implements Serializable {

    // atributos que va a llevar e objeto

    private String nombre;
    private String tipo;
    private int cantidad;
    private double precioUnidad;
    private double ventaUnidad;
    private double precioConjunto;

    public Producto(String nombre, String tipo, int cantidad, double precioUnidad, double ventaUnidad, double precioConjunto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.ventaUnidad = ventaUnidad;
        this.precioConjunto = precioConjunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getVentaUnidad() {
        return ventaUnidad;
    }

    public void setVentaUnidad(double ventaUnidad) {
        this.ventaUnidad = ventaUnidad;
    }

    public double getPrecioConjunto() {
        return precioConjunto;
    }

    public void setPrecioConjunto(double precioConjunto) {
        this.precioConjunto = precioConjunto;
    }
}
