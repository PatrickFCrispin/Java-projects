package calculoAnoBissexto;

public class CalculoAnoBissexto {
	
	public CalculoAnoBissexto() {
		
	}
	
	public static void anoBissexto(int ano) {
		
		if (ano % 4 == 0) {		//Se resto de 'ano / 4' for zero, então...			
			if (ano % 100 != 0) {
				System.out.println(ano + " é bissexto!");
			} else {
				if (ano % 400 == 0) {
					System.out.println(ano + " é bissexto!");
				} else {
					System.out.println(ano + " não é bissexto.");
				}
			}			
		} else {
			System.out.println(ano + " não é bissexto.");
		}
		
	}

}