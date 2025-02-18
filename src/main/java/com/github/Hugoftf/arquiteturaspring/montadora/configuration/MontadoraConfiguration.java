package com.github.Hugoftf.arquiteturaspring.montadora.configuration;

import com.github.Hugoftf.arquiteturaspring.montadora.Motor;
import com.github.Hugoftf.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor(){
        var motor =  new Motor();
        motor.setCavalos(120);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        motor.setCilindros(4);
        motor.setLitragem(2.0);
        motor.setModelo("XTO");
        return motor;
    }
}
