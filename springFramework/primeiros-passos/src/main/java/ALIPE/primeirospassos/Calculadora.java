package ALIPE.primeirospassos;

import org.springframework.stereotype.Component;

//indicando que essa class é um componente
@Component
public class Calculadora {
    public int somar(int n1, int n2){
        return n1 + n2;
    }
}
