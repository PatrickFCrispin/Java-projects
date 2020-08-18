package calculoAnoBissexto;

public class CalculoAnoBissexto {
	
	public CalculoAnoBissexto() {
		
	}
	
	public static void anoBissexto(int ano) {
		
		if (ano % 4 == 0) {		//Se resto de 'ano / 4' for zero, ent�o...			
			if (ano % 100 != 0) {
				System.out.println(ano + " � bissexto!");
			} else {
				if (ano % 400 == 0) {
					System.out.println(ano + " � bissexto!");
				} else {
					System.out.println(ano + " n�o � bissexto.");
				}
			}			
		} else {
			System.out.println(ano + " n�o � bissexto.");
		}
		
	}

}