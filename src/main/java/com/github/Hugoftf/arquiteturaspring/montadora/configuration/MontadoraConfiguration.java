package com.github.Hugoftf.arquiteturaspring.montadora.configuration;

import com.github.Hugoftf.arquiteturaspring.montadora.Motor;
import com.github.Hugoftf.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        var motor =  new Motor();
        motor.setCavalos(120);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        motor.setCilindros(4);
        motor.setLitragem(2.0);
        motor.setModelo("XTO");
        return motor;
    }

    @Primary
    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor =  new Motor();
        motor.setCavalos(128);
        motor.setTipoMotor(TipoMotor.TURBO);
        motor.setCilindros(6);
        motor.setLitragem(4.0);
        motor.setModelo("XTO-Turbo");
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor =  new Motor();
        motor.setCavalos(110);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        motor.setCilindros(3);
        motor.setLitragem(1.0);
        motor.setModelo("XTO-Eltrico");
        return motor;
    }
}
