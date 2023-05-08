package com.example.ltpsqllitecomercio.utils;

public class Utilidades {

    //contiene el listado de constantes globales al app
    //tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_ID_FORMA_CONTACTO = "idFormaContacto";
    //tabla forma contacto
    public static final String TABLA_FORMA_CONTACTO = "formaContacto";
    public static final String CAMPO_ID_FORMACONTACTO = "idFormaContacto";
    public static final String CAMPO_TIPO_FORMACONTACTO = "TipoContacto";
    public static final Integer VERSION = 5;
    public static final String NOMBREBD = "bd_ltp_usuario";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO +
            " (" + CAMPO_ID + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, " +
            CAMPO_TELEFONO + " TEXT, " +
            CAMPO_ID_FORMA_CONTACTO + " TEXT)";
    public static final String CREAR_TABLA_FORMA_CONTACTO = "CREATE TABLE " + TABLA_FORMA_CONTACTO + " (" + CAMPO_ID_FORMACONTACTO + " TEXT, " +  CAMPO_TIPO_FORMACONTACTO + " TEXT)";

    public static final String insert_FORMA_CONTACTO ="INSERT INTO " + TABLA_FORMA_CONTACTO + " (" + CAMPO_ID_FORMACONTACTO + ", " + CAMPO_TIPO_FORMACONTACTO + ") " +
            "values('1', 'WhatsApp'), ('2', 'Instagram'), " +
            "('3', 'Facebook'), ('4', 'Linkedin');";
}
