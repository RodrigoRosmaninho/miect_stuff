package aula9.ex3;

import java.util.Iterator;

public class VetorPessoas {
    private VetorDinamico<Pessoa> vetor;

    public VetorPessoas() {
        vetor = new VetorDinamico();
    }

    public boolean addPessoa(Pessoa p){
        vetor.add(p);
        return true;
    }

    public boolean removePessoa(Pessoa p){
        return vetor.remove(p);
    }

    public int totalPessoas(){
        return vetor.size();
    }

    public VetorIterador iterator(){
        return new VetorIterador();
    }

    class VetorIterador implements Iterator<Pessoa> {
        private int index;

        public VetorIterador() {
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index < vetor.size() - 1;
        }

        @Override
        public Pessoa next() {
            return vetor.get(++index);
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public Pessoa previous() {
            return vetor.get(--index);
        }

        @Override
        public void remove() {
            vetor.remove(index);
        }
    }
}
