package SistemaEscola;

public class Main {
    public static void main(String[] args) {

        //TODO: ESSE É UM PROJETO PESSOAL QUE AINDA NÃO ESTA FINALIZADO MAS COM BASTANTE PRATICA DE POO.

        //Criando Professores com os parametros(Nome, CodCredencial).
        System.out.println(" \n~~~~~~~~~~ PROFESSORES ~~~~~~~~~~");
        Professor p1 = new Professor("Paulo", 54252);
        Professor p2 = new Professor("Maria", 23113);
        Professor p3 = new Professor("Joaquin", 53414);
        Professor p4 = new Professor("Janaina", 53414);

        //Demostrando a lista de Professores criados.
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        //Criando disciplinas com os parametros(Nome, CargaHorariaTotal, Professor)
        Disciplina matematica = new Disciplina("Matemática", 80, p1);
        Disciplina ciencia = new Disciplina("Ciencia", 65, p2);
        Disciplina portugues = new Disciplina("Portugues", 70, p3);
        Disciplina historia = new Disciplina("Historia", 55,p4);


        System.out.println(" \n~~~~~~~~~~ ALUNOS ~~~~~~~~~~");

        //Criando Alunos que contem com os parametros(Nome, Matricula, horasAssistidasTotal)
        Aluno a1 = new Aluno("Pedro", 123123L, 120);
        a1.getDisciplinasInscritas().add(matematica);
        a1.getDisciplinasInscritas().add(ciencia);
        System.out.print(a1);
        a1.alunoFormando();
        System.out.println(" ");

        Aluno a2 = new Aluno("Fabiana", 543223L, 101);
        a2.getDisciplinasInscritas().add(portugues);
        a2.getDisciplinasInscritas().add(matematica);
        System.out.print(a2);
        a2.alunoFormando();
        System.out.println(" ");

        Aluno a3 = new Aluno("Ester", 123123L, 75);
        a3.getDisciplinasInscritas().add(historia);
        a3.getDisciplinasInscritas().add(matematica);
        System.out.print(a3);
        a3.alunoFormando();

        System.out.println(" \n~~~~~~~~~~ TURMAS ~~~~~~~~~~");
        //Criando uma Turma de Alunos e com Disciplina e Professores com os parametros(CodigoTurma, Disciplina)
        Turma t1 = new Turma(1413213L, matematica);
        t1.getAlunos().add(a1);
        t1.getAlunos().add(a2);
        t1.exibirTurma();
        System.out.println(" ");


        //Criando uma Escola que contem Alunos, Turma, Profesores e Disciplinas com os paramentros(Nome da Escola)
        Escola escola = new Escola("Aurelino Leal");
        escola.getAlunosMatriculados().add(a1);
        escola.getAlunosMatriculados().add(a2);
        escola.getAlunosMatriculados().add(a3);
        System.out.println("~~~~~~~~~~ ALUNOS FORMADOS ~~~~~~~~~~\n" + escola.alunosFormados());
        System.out.println("~~~~~~~~~~ ALUNOS CURSANDO ~~~~~~~~~~\n" + escola.alunosCursando());
        System.out.println("~~~~~~~~~~ MELHOR ALUNO ~~~~~~~~~~\n" + escola.melhorAluno());


    }
}