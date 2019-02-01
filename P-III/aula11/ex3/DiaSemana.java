package aula11.ex3;

import java.io.Serializable;

public enum DiaSemana implements Serializable {
    Segunda, Terça, Quarta, Quinta, Sexta, Sabado, Domingo;

    public static DiaSemana rand(){
        return DiaSemana.values()[(int) (Math.random() * 7)];
    }
}