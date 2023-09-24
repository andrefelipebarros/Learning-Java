package ALIPE.primeirospassos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosApplication.class, args);

		//agora com Spring não utilizaremos mais "new" faremos o Spring prover o mecanismo
		
		//Calculadora calculadora = new Calculadora();
		//System.out.println("A Soma é: " + calculadora.somar(2,4));

	}
}
	
