import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String titulo;
    private int capacidadeMaxima;
    private List<Aluno> inscritos;
    
    public Disciplina(String codigo, String titulo, int capacidadeMaxima){
        this.codigo = codigo;
        this.titulo = titulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.inscritos = new ArrayList<>();
    }
    
    public boolean isLotada(){
        return inscritos.size() >=capacidadeMaxima;
    }
    
    public List<Aluno> getAlunos(){
        return new ArrayList<>(inscritos);
    }
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public int getCapacidadeMaxima(){
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }
    
    public List<Aluno> getInscritos(){
        return inscritos;
    }
    public void setInscritos(List<Aluno> inscritos){
        this.inscritos = inscritos;
    }
    
    
    
    
}