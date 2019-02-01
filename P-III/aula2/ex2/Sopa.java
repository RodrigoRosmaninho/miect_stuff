package aula2.ex2;

public class Sopa {
	private char[][] sopa;
	private String[] alvos;
	private String[] res;
	private int res_index;
	private static String[] dirs = {"right", "left", "up", "down", "upright", "upleft", "downright", "downleft"};
	
	public Sopa(char[][] sopa, String[] alvos) {
		this.sopa = sopa;
		this.alvos = alvos;
		res = new String[alvos.length];
		res_index = 0;
	}
	
	public String[] start() {
		iterar(0,0);
		return res;
	}
	
	public void iterar(int l, int c) {
		int i = 1;
		for(String s : alvos) {
			if(Character.toUpperCase(sopa[l][c]) == Character.toUpperCase(s.charAt(0))) {
				int dir = verificar_direcoes(l,c,s);
				if(dir != 0) {
					res[res_index++] = String.format("%10s %d,%d       %s", s,l+1,c+1,dirs[dir-1]);
					break;
				}
			}
		}
		
		if(res_index == alvos.length) return;
		if(c == sopa.length - 1) {
			if(l == sopa.length - 1) return;
			iterar(l+1,0);
		}
		else iterar(l,c+1);
	}
	
	public int verificar_direcoes(int l, int c, String palavra) {
		int i = 1;
		for(; i <= 8; i++) {
			if(verificar_direcao(l,c,i,1,palavra)) return i;
		}
		return 0;
	}
	
	public boolean verificar_direcao(int l, int c, int dir, int index, String palavra) {
		int linha, coluna;
		switch(dir) {
			case 1: // RIGHT
				linha = l;
				coluna = c + 1;
				break;
			case 2: // LEFT
				linha = l;
				coluna = c - 1;
				break;
			case 3: // UP
				linha = l - 1;
				coluna = c;
				break;
			case 4: // DOWN
				linha = l + 1;
				coluna = c;
				break;
			case 5: // UPRIGHT
				linha = l - 1;
				coluna = c + 1;
				break;
			case 6: // UPLEFT
				linha = l - 1;
				coluna = c - 1;
				break;
			case 7: // DOWNRIGHT
				linha = l + 1;
				coluna = c + 1;
				break;
			case 8: // DOWNLEFT
				linha = l + 1;
				coluna = c - 1;
				break;
			default:
				linha = -1;
				coluna = -1;
				break;
		}
		
		if(linha < 0 || coluna < 0 || linha >= sopa.length || coluna >= sopa.length) return false;
		if(Character.toUpperCase(sopa[linha][coluna]) == Character.toUpperCase(palavra.charAt(index))) {
			if(index == palavra.length() - 1) return true;
			return verificar_direcao(linha,coluna,dir,++index,palavra);
		}
		return false;
		
	}
	
}
