package models.exceptions;

public class ProductIndisponivelException extends EstoqueException{
  public ProductIndisponivelException(String mensagem) {
    super(mensagem);
  }
}
