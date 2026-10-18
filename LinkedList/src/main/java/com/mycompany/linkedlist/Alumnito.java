/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedlist;

import java.util.Objects;

public class Alumnito {

    private String nombre;
    private int edad;
    private String carrera;
    private String id;
    private double calificacion;

    public Alumnito(String nombre, int edad, String id, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.calificacion = calificacion;
        this.carrera = "Sin asignar";
    }

    public Alumnito(String nombre, int edad, String carrera, String id, double calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.id = id;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumnito alumnito = (Alumnito) o;
        return Objects.equals(id, alumnito.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Alumnito{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}