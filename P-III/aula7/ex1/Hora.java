package aula7.ex1;

public class Hora implements Comparable{
    private int minutos;

    public Hora(int horas, int minutos) {
        if(horas >= 24 || horas < 0 || minutos >= 60 || minutos < 0) throw new IllegalArgumentException("Hora Inválida!");
        this.minutos = minutos + horas * 60;
    }

    public Hora(String s){
        try {
            String[] split = s.split(":");
            int h = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            if(h >= 24 || h < 0 || m >= 60 || m < 0) throw new Exception();
            minutos = m + h * 60;

        } catch (Exception e){
            throw new IllegalArgumentException("Hora Inválida!");
        }
    }

    public Hora(int minutos){
        if(minutos < 0) throw new IllegalArgumentException("Hora Inválida!");
        this.minutos = minutos;
    }

    public static Hora somarHoras(Hora a, Hora b){
        if(a == null) return b;
        if(b == null) return a;
        return new Hora(a.getMinutos() + b.getMinutos());
    }

    public int getMinutos() {
        return minutos;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Hora)) throw new IllegalArgumentException("Hora Inválida!");
        Hora h = (Hora) o;
        if(minutos < h.getMinutos()) return -1;
        if(minutos > h.getMinutos()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d",(int) (minutos / 60),minutos % 60);
    }
}
