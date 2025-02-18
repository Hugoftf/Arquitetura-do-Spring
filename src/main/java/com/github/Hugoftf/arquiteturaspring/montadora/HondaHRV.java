package com.github.Hugoftf.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Carro{


    public HondaHRV(Motor motor) {
        super(motor);
        setCor(Color.BLACK);
        setModelo("ERP");
        setMontadora(Montadora.HONDA);
    }
}
