package com.example.ltpsqllitecomercio.Entidades;

public class Usuario {
    private Integer id;
    private String nombre;
    private String telefono;
    private int idFormaContacto;

    public Usuario() {
        this.id = 0;
        nombre = "nnn";
        this.telefono = "00000";
        this.idFormaContacto = 0;
    }

    public Usuario(Integer id, String nombre, String telefono, int idFormaContacto) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.idFormaContacto = idFormaContacto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdFormaContacto() {
        return idFormaContacto;
    }

    public void setIdFormaContacto(int idFormaContacto) {
        this.idFormaContacto = idFormaContacto;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", idFormaContacto=" + idFormaContacto +
                '}';
    }
}
