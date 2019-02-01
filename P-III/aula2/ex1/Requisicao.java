package aula2.ex1;

public class Requisicao {
	private Cliente cliente;
	private Video video;
	private boolean devolvido;
	
	public Requisicao(Cliente cliente, Video video) {
		this.cliente = cliente;
		this.video = video;
		devolvido = false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Video getVideo() {
		return video;
	}
	
	public boolean is_devolvido() {
		return devolvido;
	}
	
	public void check_in() {
		devolvido = true;
	}
}
