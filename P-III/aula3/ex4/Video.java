package aula3.ex4;

public class Video {
	private int VID;
	private String titulo;
	private String categoria;
	private int min_idade;
	private int stock;
	private int total_reqs;
	private double rating_medio;
	private double rating_total;
	
	public Video() {}

	public Video(int vID, String titulo, String categoria, int min_idade, int stock) {
		VID = vID;
		this.titulo = titulo;
		this.categoria = categoria;
		this.min_idade = min_idade;
		this.stock = stock;
		total_reqs = 0;
		rating_medio = 0.0;
		rating_total = 0.0;
	}
	
	public boolean disponivel() {
		return stock > 0; 
	}
	
	public void check_in(double rating) {
		stock++;
		total_reqs++;
		rating_total += rating;
		rating_medio = rating_total / (double) total_reqs;
	}
	
	public void check_out() {
		stock--;
	}

	public int getVID() {
		return VID;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getMin_idade() {
		return min_idade;
	}

	public int getStock() {
		return stock;
	}

	public int getTotal_reqs() {
		return total_reqs;
	}

	public double getRating_medio() {
		return rating_medio;
	}

	public double getRating_total() {
		return rating_total;
	}
	
	public void deleteStock() {
		stock = 0;
	}
	
	public static String getClassEtaria(int idade) {
		switch(idade) {
			case 1:
				return "ALL";
			case 2:
				return "M8";
			case 3:
				return "M12";
			case 4:
				return "M16";
			case 5:
				return "M18";
			default:
				return "ERR";
		}
	}
	
	public String toString() {
		if(disponivel()) return "#" + VID + " - " + titulo + " - " + categoria + " - " + rating_medio + " - " + stock + " cópia(s) disponíveis - " + getClassEtaria(min_idade);
		return "#" + VID + " - " + titulo + " - " + categoria + " - " + rating_medio + " - Indisponível - " + getClassEtaria(min_idade);
	}
}
