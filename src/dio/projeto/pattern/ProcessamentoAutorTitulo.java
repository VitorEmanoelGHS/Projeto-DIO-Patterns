package dio.projeto.pattern;

import java.io.File;

public class ProcessamentoAutorTitulo implements Processamento {
	@Override
	public void RenomeiaLivro(File livro) {
		String nomeLivro = livro.getName();
		
		/* Três strings: autor, título, e extensão */
		String autor = nomeLivro.substring(0, nomeLivro.indexOf("-") - 1);
		String titulo = nomeLivro.substring(nomeLivro.indexOf("-") + 2, nomeLivro.length());
		String extensao = nomeLivro.substring(nomeLivro.length() - 4, nomeLivro.length());
		
		/* Se o nome do autor estiver invertido (ex: Picasso, Rodrigo)
		 * NOTA: O programa irá funcionar de forma anômala para arquivos
		 * com mais de um autor no título (os sites costumam variar entre
		 * ponto-e-vírgula e variados para a seccionação)
		 *  */
		if (autor.contains(",")) {
			autor = autor.substring(autor.indexOf(",") + 2, autor.length())
					+ " " + autor.substring(0, autor.indexOf(","));
		}
		
		/* Se o nome da editora, ou algo descartável, vier após travessão
		 * no título do livro... */
		if (titulo.contains("-")) {
			titulo = titulo.substring(0, titulo.indexOf("-")) + extensao;
		}
		
		/* Renomeia o arquivo livro para um arquivo com o o nome modfiicado */
		File livro2 = new File("./src/dio/projeto/pattern/Livros/" + autor + " - " + titulo);
		
		livro.renameTo(livro2);
	}
	
}
