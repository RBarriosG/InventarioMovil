package com.malfor.dominio;

public class Articulo {

    private long codigo;

    private String descripcion;

    private double precio;

    public Articulo(long codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }


}
