import java.util.ArrayList;
import java.util.List;


public class Matriculador {
    private List<Disciplina> ofertas;
    private List<Aluno> alunos;
    private int geradorMatricula = 1;
    
    public Matriculador(){
        this.ofertas = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }
    
    public void cadastrarDisciplina(Disciplina d){
        if (d == null){
            System.out.println("Disciplina inválida (null).");
        return;
        }
        
        for(Disciplina existente: ofertas){
            if(existente.getCodigo().equals(d.getCodigo())){
                System.out.println("Código já esta cadastrado: "+d.getCodigo());
                return;
            }
        }
        ofertas.add(d);
        System.out.println("Disciplina de " + d.getTitulo() + " cadastrada com sucesso!\n");
    }
    
    public void cadastrarAluno(Aluno a){
        if(a==null){
            System.out.println("Aluno ivalido.");
            return;
        }
        geradorMatricula++;
        a.setMatricula(geradorMatricula);
        
        alunos.add(a);
        System.out.println("Aluno cadastrado com sucesso.");
    }
    
    public Aluno buscarAluno(int matricula){
        for(Aluno a : alunos){
            if(a.getMatricula()==matricula){
                return a;
            }
        }
        return null;
    }
    
    public boolean matricula(int matricula, String codigoDisciplina){
        Aluno aluno = buscarAluno(matricula);
        if(aluno == null){
            System.out.println("Aluno não encontrado");
            return false;
        }
        Disciplina disciplina = null;
        for(Disciplina disciplinaProcurar: ofertas){
            if(disciplinaProcurar.getCodigo().equals(codigoDisciplina)){
               disciplina = disciplinaProcurar; 
                break;
            }
        }
        if(disciplina == null){
            System.out.println("Disciplina não encontrada");
            return false;
        }
        
        if(disciplina.isLotada()){
            System.out.println(aluno.getNome() + " não há vagas disponíveis na disciplina "+ disciplina.getCodigo());
            return false;
        }
        
        for(Aluno listInscrito : disciplina.getInscritos()){
            if(listInscrito.getMatricula() == matricula){
                System.out.println("Aluno já esta inscrito nessa disciplina");
                return false;
            }
        }
        
        disciplina.getInscritos().add(aluno);
        System.out.println("Matricula realizado com sucesso para o aluno(a) " + aluno.getNome() + " em " + disciplina.getTitulo()+"\n");
        return true;
    }
    
    public List<Aluno> listarInscritos(String codigoDisciplina){
        for (Disciplina listaCodigo: ofertas){
            if(listaCodigo.getCodigo().equals(codigoDisciplina)){
                return new ArrayList<>(listaCodigo.getInscritos());
            }
        }
        return new ArrayList<>();
    }
    
    public void exibirRelatorioMatricula(){
    System.out.println("\n=========== RELATÓRIO DE MATRÍCULAS ===========");

    if (ofertas.isEmpty()){
        System.out.println("Não há disciplinas cadastradas.");
        return;
    }

    for(Disciplina disciplinaRelatorio : ofertas){
        System.out.println("\nDisciplina: " + disciplinaRelatorio.getTitulo() + " (" + disciplinaRelatorio.getCodigo() + ")");
        System.out.println("Capacidade: " + disciplinaRelatorio.getCapacidadeMaxima() + " | Inscritos: " + disciplinaRelatorio.getInscritos().size());
        System.out.printf("%-10s | %s\n", "Nome", "Matricula");
        System.out.println("-------------------");
        
        if(disciplinaRelatorio.getInscritos().isEmpty()){
            System.out.println("  Nenhum aluno inscrito.");
        } else {
            for(Aluno a : disciplinaRelatorio.getInscritos()){
                
                System.out.printf("%-10s | %d\n", a.getNome(), a.getMatricula());
            }
        }
    }
    System.out.println("\n===============================================\n");
}

    
    
    
}