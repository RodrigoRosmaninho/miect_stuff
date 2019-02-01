package aula6.ex1;

import java.io.Serializable;

public class Node implements Comparable, Serializable {
    final private Prato prato;
    final private DiaSemana dia;
    private Node next;

    public Node(Prato prato, DiaSemana dia){
        this.prato = prato;
        this.dia = dia;
    }

    public Prato getPrato(){
        return prato;
    }

    public DiaSemana getDia(){
        return dia;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }

    public int compareTo(Object obj){
        if(obj instanceof Node) {
            Node n = (Node) obj;
            return dia.compareTo(n.getDia());
        }
        throw new IllegalArgumentException("Apenas se pode comparar um node com outros nodes");
    }

    public String toString(){
        return prato + ", dia " + dia;
    }

    public boolean equals(Object obj){
        if(obj instanceof Node){
            Node n = (Node) obj;
            return prato.equals(n.getPrato()) && dia.equals(n.getDia());
            // Não se verifica se 'next' é igual a 'n.next'
        }
        return false;
    }

    public Node clone(){
        return new Node(prato, dia);
    }

}