import java.util.Scanner;

public class telaLoteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		sorteioNLoteria sorteio = new sorteioNLoteria();
		
		String iniciar = "S";
		int acertos = 0; 
		boolean apostar = true;
		int qtd2 = 0;
		int qtd = 0;
		//Sorteio dos números
		int sorteado = sorteio.numeroLoteria();
		
		System.out.println("Tabela de Valores");
		System.out.println(" 6 - R$ 2,50");
		System.out.println(" 7 - R$ 17,50");
		System.out.println(" 8 - R$ 70,00");
		System.out.println(" 9 - R$ 210,00");
		System.out.println(" 10 - R$ 525,00");
		
		//Continua fazendo apostas até o usuário digitar um valor desconhecido ou informar ('N')
		while(iniciar.equalsIgnoreCase("S")) {
			System.out.println("Começar uma aposta? 'S'im - 'N'ão");
			iniciar = sc.next();
			
			//Pega o tempo inicial
			double tempoInicio = 0;
			tempoInicio = System.currentTimeMillis();
			if (iniciar.equalsIgnoreCase("N")) {
				System.out.println("Ok, saindo");
				break;
				
			}else if (!(iniciar.equalsIgnoreCase("S"))) {
				System.out.println("Opção desconhecida. Finalizando.");
				break;
			}
			
			//While para tratamento de erro da aposta (somente entre 6 e 10)
			while(apostar){
				System.out.println("Quantos números deseja apostar? ");
				qtd = sc.nextInt();
				
				qtd2 = qtd;
				if (qtd > 10 || qtd < 6) {
					System.out.println("A aposta somente pode conter entre 6 e 10 números");
					System.out.println("Informe a quantidade de números novamente");
					apostar = true;
					
				}else {
					apostar = false;
				}
				
			}
			qtd2 = qtd;
			double valorTotal = 0;
			System.out.println(qtd + " números a sua escolha");
			switch (qtd) {
			case 6:
				System.out.println("Valor total a pagar = R$ 2,50");
				valorTotal = 2.50;
				break;
			case 7:
				System.out.println("Valor total a pagar = R$ 17,50");
				valorTotal = 17.50;
				break;
			case 8:
				System.out.println("Valor total a pagar = R$ 70,00");
				valorTotal = 70;
				break;
			case 9:
				System.out.println("Valor total a pagar = R$ 210,00");
				valorTotal = 210;
				break;
			case 10:
				System.out.println("Valor total a pagar = R$ 525,00 ");
				valorTotal = 525;
				break;

			}
			System.out.println("===================================\n");
	
			int[] numerosUser = new int[qtd2];
			int[] tentativasNums = new int[qtd2];
			int[] numerosLoteria = new int[qtd2];
			
			System.out.println("Informe seus números! ");
			
			for (int j = 0;j < numerosUser.length;) {
				System.out.println("Informe o " + (j+1) + " º número:");
				numerosUser[j] = sc.nextInt();
				//Analisa  se o valor está entre 0 e 60
				if (numerosUser[j] >= 0 && numerosUser[j] <= 60) {
					j++;
					
				}else {
					System.out.println("Valor não permitido - Min '0' - Max '60'");
					System.out.println("Informe novamente.");
				}
			}
			sorteado = sorteio.numeroLoteria();
			sorteado = -1;
			
			int tentativas = 0;
				int k = 0;
				acertos = 0;
				
				//Verifica se o valor do usuário é correspondente ao sorteado
				//Caso não, ele sorteia até encontrar.
				while(acertos <= 6) {
					tentativas++;
					if (numerosUser[k] == sorteado && acertos < 6) {					
						tentativasNums[k] += 1;
						numerosLoteria[acertos] = sorteado;
						acertos++;
						k++;
						if (acertos > 6) {
							acertos = 6;

						}
					}else {
						tentativasNums[k] += 1;
						sorteado = sorteio.numeroLoteria();
						
					}
					if (acertos == 6) {
						break;
						
					}
				}
				
				if (acertos == 6) {
					System.out.println("Parabéns! Você ficou muito rico!");
					System.out.println("Seus números: ");
					for (int j = 0; j < 6; j++) {
						System.out.println((j+1) + "º: " + numerosUser[j]);
						System.out.println("Para encontrar o número " + numerosUser[j] + " foram feitas " + tentativasNums[j] + " tentativas");
					}				
				}
				System.out.println("===============================\n");
				System.out.println("Números da loteria");
				for (int i = 0; i < 6; i++) {
					System.out.println((i+1) + " º: " + numerosLoteria[i]);
					
				}
				System.out.println("Tentativas: "+ tentativas);
				System.out.println("================================================");
				System.out.println("Para ganhar a loteria seria necessário R$ " + (valorTotal*tentativas));
				System.out.println("=================================================");
				// pega o tempo final e diminui pelo inicial;
				System.out.println("Tempo de execução em segundos: " + (System.currentTimeMillis()-tempoInicio)/1000);
				System.out.println("Tempo de execução em minutos: " + ((System.currentTimeMillis()-tempoInicio)/1000)/60);
			}	
	}
}
