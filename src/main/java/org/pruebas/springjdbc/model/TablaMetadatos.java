package org.pruebas.springjdbc.model;

public class TablaMetadatos {

    private String nombreCampo;
    private String tipoCampo;
    private int tipoCodigo;
    private int tamanyo;

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public int getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(int tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    @Override
    public String toString() {
        return "TablaMetadatos{" +
                "nombreCampo='" + nombreCampo + '\'' +
                ", tipoCampo='" + tipoCampo + '\'' +
                ", tipoCodigo=" + tipoCodigo +
                ", tamanyo=" + tamanyo +
                '}';
    }
}
