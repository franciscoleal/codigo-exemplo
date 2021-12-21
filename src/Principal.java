import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		GlobalSales();
	}
	
	public static void GlobalSales() throws Exception{
		
		String nome = "";
		String ano = "";
		Double globalSales = 0.0;
		String linha = "";
		List<VendasJogos> lista = new ArrayList<>(); 
		String text = "";
		
		
		
//		aqui eu leio o arquivo e guardo no objeto scanner
		Scanner scanner = new Scanner(new File("C:\\tmp\\saida\\vgsales.csv"));
//		pulo o cabeçalho
		scanner.nextLine();
//		
		while(scanner.hasNextLine()) {
			linha = scanner.nextLine();
			String[] vect = linha.split(",");
			globalSales = Double.parseDouble(vect[10]);
			ano = vect[3];
			nome = vect[1];
			lista.add(new VendasJogos(nome, ano, globalSales));
		}
		
		PrintWriter salvar = new PrintWriter(new File("nomes.txt"));
		
		
		for(VendasJogos linhas : lista) {
			
			text = linhas.getAno().replaceAll("[^0-9.]", "");
			if(text.length() == 4) {
				int jogosLancadosAposAno = 2000;
				int listInt = Integer.parseInt(text);
				if (listInt > jogosLancadosAposAno && linhas.getGlobalSales() > 2f ) {
//					System.out.println(valor.getName() + " : " + valor.getGlobalSales());
					System.out.println("Após o ano 2000: " + linhas.getNome());
					salvar.println(linhas.getNome());
				}
			}
//			System.out.println(linhas.getNome() + linhas.getAno() + linhas.globalSales);
			
		}
		salvar.close();
		
	}
}
