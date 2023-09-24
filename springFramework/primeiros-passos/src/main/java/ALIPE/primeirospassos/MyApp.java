package ALIPE.primeirospassos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//transformamos em um componente
@Component
//implementamos o CommandLineRunner
public class MyApp implements CommandLineRunner {
    //criamos uma injeção ao Spring com a nova class calculadora
    @Autowired
    private Calculadora calculadora;

    @Autowired
    private HelloWorld mundo;

    // soberscrever um método(caso eu queira futuramente mudar o nome mudará para todos com extensão)
    @Override
    public void run(String... args) throws Exception {
        System.out.println("A Soma é: " + calculadora.somar(2,4));
        mundo.Hello();
    }

}
