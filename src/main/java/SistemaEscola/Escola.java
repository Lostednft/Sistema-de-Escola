package SistemaEscola;

import lombok.Getter;
import lombok.Setter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class Escola {
    //Atributos
    private String nomeEscola;
    private Set<Aluno> alunosMatriculados = new HashSet<>();
    private Set<Professor> professoresContratados = new HashSet<>();
    private Set<Disciplina> disciplinasDisponiveis = new HashSet<>();
    private Set<Turma> turmas = new HashSet<>();

    //Construtor
    public Escola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    //Lista de Alunos Formados.
    public Set<Aluno> alunosFormados()
    {
        return alunosMatriculados.stream()
                .filter(Aluno::isFormado)
                .collect(Collectors.toSet());
    }

    //Lista de Alunos que ainda estão cursando e não alcançou a meta de Horas Assistidas.
    public Set<Aluno> alunosCursando ()
    {
        return alunosMatriculados.stream()
                .filter(alunosMatriculados -> !alunosMatriculados.isFormado())
                .collect(Collectors.toSet());
    }

    //O Aluno com mais Horas Assistidas.
    public Aluno melhorAluno()
    {
        return alunosMatriculados.stream()
                .max(Comparator.comparingDouble(Aluno::getHorasAssistidasTotal))
                .orElse(null);
    }
}
