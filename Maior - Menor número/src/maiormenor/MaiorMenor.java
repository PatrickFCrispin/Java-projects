package maiormenor;

public class MaiorMenor {
	
	public MaiorMenor() {
		
	}
	
	public void maior(int a, int b, int c) {
		int maior;
		if (a >= b && a >= c) {
			maior = a;
		} else if (b >= a && b >= c) {
			maior = b;
		} else {
			maior = c;
		}
		
		System.out.println("O maior n�mero �: " + maior);
	}
	
	public void menor(int a, int b, int c) {
		int menor;
		if (a <= b && a <= c) {
			menor = a;
		} else if (b <= a && b <= c) {
			menor = b;
		} else {
			menor = c;
		}
		
		System.out.println("O menor n�mero �: " + menor);
	}

}
