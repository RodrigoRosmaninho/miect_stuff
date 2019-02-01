package aula4.ex1;

public class Disciplina {
	private String nome;
	private String area;
	private int ECTS;
	private Professor responsavel;
	private VetorDinamico<Estudante> alunos;
	
	public Disciplina(String nome, String area, int eCTS, Professor responsavel) {
		this.nome = nome;
		this.area = area;
		ECTS = eCTS;
		this.responsavel = responsavel;
		alunos = new VetorDinamico<Estudante>();
	}
	
	public boolean addAluno(Estudante e) {
		if(alunos.contains(e)) return false;
		alunos.add(e);
		return true;
	}
	
	public boolean delAluno(int nMec) {
		Estudante[] tmp = alunos.array(new Estudante[alunos.size()]);
		for(Estudante e : tmp) {
			if(e.nMec() == nMec) {
				alunos.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public boolean alunoInscrito(int nMec) {
		Estudante[] tmp = alunos.array(new Estudante[alunos.size()]);
		for(Estudante e : tmp) if(e.nMec() == nMec) return true;
		return false;
	}
	
	public int numAlunos() {
		return alunos.size();
	}
	
	@Override
	public String toString() {
		return "Disciplina: " + nome + " (" + ECTS + " ECTS) da Area de " + area + "\nResponsável: " + responsavel + "\nExistem " + numAlunos() + " Alunos Inscritos";
	}
	
	public Estudante[] getAlunos() {
		return alunos.array(new Estudante[alunos.size()]);
	}
	
	public Estudante[] getAlunos(String tipo) {
		VetorDinamico<Estudante> tmp = new VetorDinamico<Estudante>(); 
		for(Estudante e : getAlunos()) {
			if(e.getClass().getSimpleName().equals(tipo)) {
				tmp.add(e);
			}
		}
		return tmp.array(new Estudante[tmp.size()]);
	}
	
}
