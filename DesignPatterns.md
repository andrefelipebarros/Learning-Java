
# Design Patterns em Java

Design Patterns (Padrões de Design) são soluções reutilizáveis para problemas comuns encontrados no desenvolvimento de software. Eles ajudam a criar códigos mais organizados, legíveis e fáceis de manter. A seguir, vamos explorar alguns dos principais padrões de design em Java.

---

## 1. **Singleton**

### O que é?
O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a essa instância.

### Exemplo:
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Como funciona?
A classe `Singleton` tem um método estático `getInstance()` que retorna a mesma instância toda vez que é chamado.

---

## 2. **Factory**

### O que é?
O padrão Factory permite criar objetos sem especificar a classe exata do objeto que será criado. Ele delega a criação do objeto para uma classe-fábrica.

### Exemplo:
```java
interface Animal {
    void fazerSom();
}

class Cachorro implements Animal {
    public void fazerSom() {
        System.out.println("Au Au");
    }
}

class Gato implements Animal {
    public void fazerSom() {
        System.out.println("Miau");
    }
}

class AnimalFactory {
    public static Animal criarAnimal(String tipo) {
        if (tipo.equals("Cachorro")) {
            return new Cachorro();
        } else if (tipo.equals("Gato")) {
            return new Gato();
        }
        return null;
    }
}
```

### Como funciona?
A classe `AnimalFactory` cria instâncias de `Cachorro` ou `Gato` dependendo da entrada, sem que o código cliente precise se preocupar com a implementação.

---

## 3. **Observer**

### O que é?
O padrão Observer define uma dependência um-para-muitos entre objetos, para que quando um objeto mudar seu estado, todos os objetos dependentes sejam notificados.

### Exemplo:
```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " recebeu a mensagem: " + message);
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        
        subject.notifyObservers("Evento importante!");
    }
}
```

### Como funciona?
Quando o `Subject` muda, ele notifica todos os `Observers` registrados. Cada `Observer` atualiza seu estado de acordo.

---

## 4. **Strategy**

### O que é?
O padrão Strategy permite que você altere o comportamento de um objeto em tempo de execução, encapsulando algoritmos em classes separadas.

### Exemplo:
```java
interface Comportamento {
    void executar();
}

class ComportamentoA implements Comportamento {
    public void executar() {
        System.out.println("Comportamento A");
    }
}

class ComportamentoB implements Comportamento {
    public void executar() {
        System.out.println("Comportamento B");
    }
}

class Contexto {
    private Comportamento comportamento;

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void executarComportamento() {
        comportamento.executar();
    }
}

public class Main {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();
        
        contexto.setComportamento(new ComportamentoA());
        contexto.executarComportamento(); // Saída: Comportamento A
        
        contexto.setComportamento(new ComportamentoB());
        contexto.executarComportamento(); // Saída: Comportamento B
    }
}
```

### Como funciona?
O `Contexto` pode trocar de comportamento dinamicamente, permitindo mudar a lógica do programa sem modificar a classe principal.

---

## 5. **Decorator**

### O que é?
O padrão Decorator permite adicionar funcionalidades a objetos dinamicamente, sem alterar a classe original.

### Exemplo:
```java
interface Forma {
    void desenhar();
}

class Circulo implements Forma {
    public void desenhar() {
        System.out.println("Desenhando um círculo");
    }
}

class DecoradorForma implements Forma {
    protected Forma forma;

    public DecoradorForma(Forma forma) {
        this.forma = forma;
    }

    public void desenhar() {
        forma.desenhar();
    }
}

class DecoradorCor extends DecoradorForma {
    public DecoradorCor(Forma forma) {
        super(forma);
    }

    public void desenhar() {
        super.desenhar();
        System.out.println("Adicionando cor ao círculo");
    }
}

public class Main {
    public static void main(String[] args) {
        Forma forma = new Circulo();
        Forma formaDecorada = new DecoradorCor(forma);
        formaDecorada.desenhar();
    }
}
```

### Como funciona?
O `DecoradorCor` adiciona um comportamento extra ao objeto `Forma` sem modificar a classe original.

---

## 6. **Adapter**

### O que é?
O padrão Adapter permite que classes com interfaces incompatíveis trabalhem juntas.

### Exemplo:
```java
interface Alvo {
    void fazerRequisicao();
}

class SistemaAntigo {
    public void requisicaoAntiga() {
        System.out.println("Requisição antiga");
    }
}

class Adapter implements Alvo {
    private SistemaAntigo sistemaAntigo;

    public Adapter(SistemaAntigo sistemaAntigo) {
        this.sistemaAntigo = sistemaAntigo;
    }

    public void fazerRequisicao() {
        sistemaAntigo.requisicaoAntiga();
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaAntigo sistemaAntigo = new SistemaAntigo();
        Alvo alvo = new Adapter(sistemaAntigo);
        alvo.fazerRequisicao(); // Saída: Requisição antiga
    }
}
```

### Como funciona?
O `Adapter` "adapta" a interface do sistema antigo para que ele funcione com o novo sistema.

---

## 7. **Facade**

### O que é?
O padrão Facade fornece uma interface simplificada para um conjunto de interfaces mais complexas.

### Exemplo:
```java
class SubSistemaA {
    public void operacaoA() {
        System.out.println("Operação A");
    }
}

class SubSistemaB {
    public void operacaoB() {
        System.out.println("Operação B");
    }
}

class Facade {
    private SubSistemaA sistemaA = new SubSistemaA();
    private SubSistemaB sistemaB = new SubSistemaB();

    public void operacaoFacade() {
        sistemaA.operacaoA();
        sistemaB.operacaoB();
    }
}

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operacaoFacade(); // Saída: Operação A, Operação B
    }
}
```

### Como funciona?
O `Facade` simplifica a interação com sistemas complexos, oferecendo uma interface única para o cliente.

---

## 8. **Proxy**

### O que é?
O padrão Proxy fornece um objeto substituto que controla o acesso ao objeto real.

### Exemplo:
```java
interface Servico {
    void realizarAcao();
}

class ServicoReal implements Servico {
    public void realizarAcao() {
        System.out.println("Ação realizada");
    }
}

class Proxy implements Servico {
    private ServicoReal servicoReal;

    public void realizarAcao() {
        if (servicoReal == null) {
            servicoReal = new ServicoReal();
        }
        servicoReal.realizarAcao();
    }
}

public class Main {
    public static void main(String[] args) {
        Servico proxy = new Proxy();
        proxy.realizarAcao(); // Saída: Ação realizada
    }
}
```

### Como funciona?
O `Proxy` controla o acesso ao `ServicoReal`, podendo realizar ações adicionais antes ou depois da execução do serviço.

---

Esses são apenas alguns dos padrões de design mais comuns em Java. Cada um tem seu uso específico e pode ser muito útil para organizar seu código e torná-lo mais reutilizável.
