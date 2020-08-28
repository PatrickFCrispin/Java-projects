package ordenador;
public class Ordenador {
	
	public static void ordenar(Integer [] n) {	
		//Ordena��o em ordem crescente - 0 � 9
		int i = 0;
		while(i < n.length) {
			int j = 0;
			while(j < n.length - 1) {
				if (n[j] > n[j + 1]) {
					int maior = n[j];
	                n[j] = n[j + 1];
	                n[j + 1] = maior;
	            }
				j++;
			}
			i++;
		}
		
//		Ordena��o em ordem descrescente - 9 � 0
//		int i = 0;
//		while(i < n.length) {
//			int j = 0;
//			while(j < n.length - 1) {
//				if (n[j] < n[j + 1]) {
//					int menor = n[j];
//	                n[j] = n[j + 1];
//	                n[j + 1] = menor;
//	            }
//				j++;
//			}
//			i++;
//		}
		
		//Ao inv�s de usar while() poderia ter usado dois for, ou um for com while()
		//Abaixo outras maneiras de fazer:
		//UTILIZANDO FOR e WHILE
//		for (int i = 0; i < n.length; i++) {
//			int j = 0;
//			while(j < n.length - 1) {
//				if (n[j] > n[j + 1]) {
//					int maior = n[j];
//	                n[j] = n[j + 1];
//	                n[j + 1] = maior;
//	            }
//				j++;
//			}
//		}
		
		//UTILIZANDO DOIS FOR
//		for (int i = 0; i < n.length; i++) {
//			for (int j = 0; j < n.length - 1; j++) {
//				if (n[j] > n[j + 1]) {
//					int maior = n[j];
//	                n[j] = n[j + 1];
//	                n[j + 1] = maior;
//	            }
//			}
//		}
		
		for (i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
		
	}
	
}