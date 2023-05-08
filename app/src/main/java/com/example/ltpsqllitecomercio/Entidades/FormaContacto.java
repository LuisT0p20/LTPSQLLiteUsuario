package com.example.ltpsqllitecomercio.Entidades;

public class FormaContacto {
    private String idFormaContacto;
    private String TipoContacto;

    public FormaContacto() {
        this.idFormaContacto = "0";
        TipoContacto = "nnn";
    }

    public FormaContacto(String idFormaContacto, String tipoContacto) {
        this.idFormaContacto = idFormaContacto;
        TipoContacto = tipoContacto;
    }

    public String getIdFormaContacto() {
        return idFormaContacto;
    }

    public void setIdFormaContacto(String idFormaContacto) {
        this.idFormaContacto = idFormaContacto;
    }

    public String getTipoContacto() {
        return TipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        TipoContacto = tipoContacto;
    }

    @Override
    public String toString() {
        return "FormaContacto{" +
                "idFormaContacto='" + idFormaContacto + '\'' +
                ", TipoContacto='" + TipoContacto + '\'' +
                '}';
    }
}
