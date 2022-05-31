package dio.projeto.pattern;

import java.io.File;

/*
 * 
 * Esse programa basicamente irá renomear um arquivo (presumivelmente um
 * livro) para o formato {Autor} - {Titulo} {Serie}.
 * Se {Autor} estiver como {Sobrenome, Nome}, então o programa irá
 * transformar a string em {Nome Sobrenome}.
 * 
 */

public class RenomeiaLivro {
	public static void main(String args[]) {
		File folder = new File("./src/dio/projeto/pattern/Livros");
		File[] listOfFiles = folder.listFiles();
		
		Processamento autorTitulo = new ProcessamentoAutorTitulo();
		Processamento autorTituloSerie = new ProcessamentoAutorTituloSerie();
		Livro livro = new Livro();

		for (int i = 0; i < listOfFiles.length; i++) {
			String nomeDoLivroPc = listOfFiles[i].getName();
			
			/* Se houver uma vírgula no nome do arquivo (e do autor) até o travessão */
			if (nomeDoLivroPc.substring(0, nomeDoLivroPc.indexOf("-")).contains(",")) {
				/* Se houverem parênteses na primeira metade do nome do arquivo */
				if (nomeDoLivroPc.substring(0, nomeDoLivroPc.indexOf("-")).contains(")")) {
					livro.setProcessamento(autorTituloSerie);
					livro.RenomeiaLivro(listOfFiles[i]);
				} else {
					livro.setProcessamento(autorTitulo);
					livro.RenomeiaLivro(listOfFiles[i]);
				}
			}
		}
	}
}
