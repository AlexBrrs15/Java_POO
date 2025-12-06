

public class Main {
    
    public static void main(String[] args) {
        
        Matriculador matriculador = new Matriculador();
         
            
         Disciplina dis1 = new Disciplina("MAT11", "Matemática", 2);
         Disciplina dis2 = new Disciplina("PORT22", "Português", 2);
         Disciplina dis3 = new Disciplina("GEO33", "Geografia", 2);
         
     
        
        matriculador.cadastrarDisciplina(dis1);
        matriculador.cadastrarDisciplina(dis2);
        matriculador.cadastrarDisciplina(dis3);
        
     
        Aluno aluno1 = new Aluno("Bia", "bia@gmail.com");
        Aluno aluno2 = new Aluno("Maria", "maria@gmail.com");
        Aluno aluno3 = new Aluno("joao", "joao@gamil.com");
        
        matriculador.cadastrarAluno(aluno1);
        matriculador.matricula(aluno1.getMatricula(), dis3.getCodigo());
     
        matriculador.cadastrarAluno(aluno2);
        matriculador.matricula(aluno2.getMatricula(), "GEO33");
     
        matriculador.cadastrarAluno(aluno3);
        matriculador.matricula(aluno3.getMatricula(), "GEO33");
     
        //Exibir relatorio
        matriculador.exibirRelatorioMatricula();

       
        
            
        
        
    }
    
}