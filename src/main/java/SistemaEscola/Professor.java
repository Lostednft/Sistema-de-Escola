package SistemaEscola;


import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class Professor {
    //Atributos
    private String nome;
    private int codCredencial;
    private static Set<Integer> codCredencialList = new HashSet<>();

    //Construtor
    public Professor(String nome, Integer codCredencial) {
        this.nome = nome;
        this.codCredencial = validandoCredencial(codCredencial);
    }

    //Função de validação de Credencial para não conter Código de Credencial repetido.
    private Integer validandoCredencial(Integer numeroCredencial)
    {
       Integer existe = codCredencialList.stream().anyMatch(n -> n.equals(numeroCredencial)) ? 0 : numeroCredencial;

       if (existe.equals(0))
       {
           System.err.println("Esse codigo " + numeroCredencial + " da credencial ja existe, verifica se esta certo!");
       }

       codCredencialList.add(existe);
       return existe;

    }

    @Override
    public String toString() {
        return  "Nome = " + nome + " | " +
                "Códido da Credencial = " + codCredencial;
    }
}
