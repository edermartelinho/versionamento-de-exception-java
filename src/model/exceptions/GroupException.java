package model.exceptions;

public class GroupException extends RuntimeException {
	
	//Essa clase por ser serial deve ter um numero de versao foi usada a padrao
    //Classe serial signifa que os obj podem ser convertidos em bit e assim trafegar em rede
	//gravados em arquivos
	
	private static final long serialVersionUID = 1L;
	
	//O construtor recebe um string como argumento e passar para o constr. da super classe
    //para permitir que possa instancia a exception personalizada passando uma mensagem
	
	public GroupException(String msg) {
		super(msg);
	}
}
