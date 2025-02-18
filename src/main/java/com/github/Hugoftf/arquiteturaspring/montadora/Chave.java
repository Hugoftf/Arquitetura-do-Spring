package com.github.Hugoftf.arquiteturaspring.montadora;

public class Chave {

    private Montadora montadoraChave;
    private String tipoChave;

    public Montadora getMontadoraChave() {
        return montadoraChave;
    }

    public void setMontadoraChave(Montadora montadoraChave) {
        this.montadoraChave = montadoraChave;
    }

    public String getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }
}
