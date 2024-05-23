package SistemaEscola;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Disciplina {
    //Atributos
    private String nome;
    private int cargaHorarioTotal;
    private Professor professor;

    @Override
    public String toString() {
        return
                "Nome = " + nome + " |" +
                " CargaHorarioTolal = " + cargaHorarioTotal +  " |" +
                " Professor(a) = " + professor.getNome() +  " | ";
    }
}
