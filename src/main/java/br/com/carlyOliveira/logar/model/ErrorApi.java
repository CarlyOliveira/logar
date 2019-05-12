package br.com.carlyOliveira.logar.model;

public class ErrorApi {
    
    private final String mensagem;
    private final String errorCode;

    public ErrorApi(String mensagem, String errorCode) {
        this.mensagem = mensagem;
        this.errorCode = errorCode;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public String getErrorCode() {
    	return this.errorCode;
    }
    
}
