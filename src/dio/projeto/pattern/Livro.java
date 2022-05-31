package dio.projeto.pattern;

import java.io.File;

public class Livro {
	private Processamento processamentoObj;
	
	public void setProcessamento(Processamento processamento) {
		this.processamentoObj = processamento;
	}
	
	public void RenomeiaLivro(File arquivo) {
		processamentoObj.RenomeiaLivro(arquivo);
	}
}
