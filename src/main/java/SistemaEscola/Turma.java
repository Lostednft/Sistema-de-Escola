package SistemaEscola;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


@Getter
@Setter

public class Turma {

    //Atributos
    private long codigoTurma;
    private Disciplina disciplina;
    private Set<Aluno> alunos = new HashSet<>();

    //Construtor
    public Turma(long codigoTurma, Disciplina disciplina) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
    }

    //Função privada para exibir todos os alunos da mesma disciplinas da Turma que foi criada.
    private void alunosPorDisciplina()
    {
        Map<Long, String> AlunosMesmaDisc = new LinkedHashMap<>();
        for(Aluno a : alunos)
        {
            if (a.getDisciplinasInscritas().contains(disciplina))
            {
                AlunosMesmaDisc.put(a.getMatricula(), a.getNome());
                System.out.println("Nome: " + a.getNome() + " - Matricula: " + a.getMatricula());
            }
        }
    }

    //Metodo para exibir todos os dados da Turma.
    public void exibirTurma()
    {
        System.out.println("codigo da Turma: " + getCodigoTurma());
        System.out.println("Disciplina: " + getDisciplina().getNome());
        System.out.println("Professor: " + getDisciplina().getProfessor().getNome());
        System.out.println("Alunos ~ ");
        alunosPorDisciplina();
    }
}
