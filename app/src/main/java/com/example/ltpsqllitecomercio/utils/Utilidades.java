package com.example.ltpsqllitecomercio.utils;

public class Utilidades {

    //contiene el listado de constantes globales al app
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_ID_FORMA_CONTACTO = "idFormaContacto";
    public static final Integer VERSION = 4;
    public static final String NOMBREBD = "bd_ltp_usuario";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO +
            " (" + CAMPO_ID + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, " +
            CAMPO_TELEFONO + " TEXT, " +
            CAMPO_ID_FORMA_CONTACTO + " INTEGER)";
    public static final String CREAR_TABLA_FORMA_CONTACTO = "CREATE TABLE formaContacto (idFormaContacto INTEGER, TipoContacto TEXT)";

    public static final String insert_FORMA_CONTACTO ="insert into formaContacto (idFormaContacto, TipoContacto) " +
            "values(1, 'WhatsApp'), (2, 'Instagram'), " +
            "(3, 'Facebook'), (4, 'Linkedin');";
}
