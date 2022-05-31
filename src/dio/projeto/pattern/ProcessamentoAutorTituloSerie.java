package dio.projeto.pattern;

import java.io.File;

public class ProcessamentoAutorTituloSerie implements Processamento {
	@Override
	public void RenomeiaLivro(File livro) {
		String nomeLivro = livro.getName();
		
		String serie = "";
		String autor = nomeLivro.substring(0, nomeLivro.indexOf("-") - 1);
		String titulo = nomeLivro.substring(nomeLivro.indexOf("-") + 2, nomeLivro.length());
		String extensao = nomeLivro.substring(nomeLivro.length() - 4, nomeLivro.length());
		
		if (autor.contains("(") || autor.contains(")")) {
			serie = autor.substring(autor.indexOf("("), autor.indexOf(")") + 1);
			autor = autor.substring(autor.indexOf(")") + 2, autor.length());
		}
		
		if (autor.contains(",")) {
			autor = autor.substring(autor.indexOf(",") + 2, autor.length())
					+ " " + autor.substring(0, autor.indexOf(","));
		}
		
		if (titulo.contains("-")) {
			titulo = titulo.substring(0, titulo.indexOf("-")) + " " + serie + extensao;
		}
		
		File livro2 = new File("./src/dio/projeto/pattern/Livros/" + autor + " - " + titulo);
		
		livro.renameTo(livro2);
	}
	
}
