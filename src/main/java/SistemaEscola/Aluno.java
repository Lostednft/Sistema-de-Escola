package SistemaEscola;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Aluno {
    //Atributos
    private String nome;
    private Long matricula;
    private Set<Disciplina> disciplinasInscritas = new HashSet<>();
    private boolean formado;
    private double horasAssistidasTotal;

    //Lista Criada com intuito de validar caso tenha numero de matrícula repetida.
    private static Set<Long> matriculasLista = new HashSet<>();

    //Metodo Construtor
    public Aluno(String nome, Long matri, double horasAssistidasTotal) {
        this.nome = nome;
        this.horasAssistidasTotal = horasAssistidasTotal;
        this.formado = false;
        this.matricula = validacaoMatricula(matri, nome);
    }

    //Metodo de exibir as disciplinas que o Aluno se inscreveu
    public void alunoDisciplinas() {
        System.out.println(disciplinasInscritas);
    }

    /**Metodo criado com o STREAM API para exibir os Alunos que conseguiram alcançar mais de
     * 70% de Horas Assistidas da media de todas Aulas.
     */
    public void alunoFormando()
    {
        double mediaHora = disciplinasInscritas.stream()
                .mapToDouble(Disciplina::getCargaHorarioTotal)
                .sum() * 0.7;

        if (horasAssistidasTotal < mediaHora)
        {
            System.out.println("Infelizmente vc não teve horas assistidas suficiente para se forma, precisava de " + mediaHora + " e a sua media foi " + horasAssistidasTotal);
        }
        else
        {
            formado=true;
            System.out.println("Parabens vc concluiu os seus estudos e conseguiu se formar!! Media Necessaria: " + mediaHora + " Sua Media: " + horasAssistidasTotal);
        }
    }

    //Uma Função para Validar a matricula para não ocorre de ter 2 objetos com a mesma matrícula.
    public Long validacaoMatricula(Long numeroMatricula, String nome)
    {

        if (matriculasLista.contains(numeroMatricula)) {
            System.err.printf("A Matrícula de %s com os numeros %d já esta registrada na lista, por favor ajusta a numeração!%n", nome, numeroMatricula);
            return 0L;
        }
        else {
            matriculasLista.add(numeroMatricula);
            return numeroMatricula;
        }
    }

    @Override
    public String toString() {
        return
                "Nome = " + nome +
                "\nMatricula = " + matricula +
                "\nDisciplinas = " + disciplinasInscritas +
                "\nFormado = " + formado +
                "\nHorasAssistidasTotal = " + horasAssistidasTotal + "\n\n";
    }
}

