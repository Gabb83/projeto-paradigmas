package models;

import models.exceptions.QuantidadeInvalidaException;

public class ProdutoComum extends Product{
  
  public ProdutoComum(String nome, double preco, int quantidade) throws  QuantidadeInvalidaException {
    super(nome, preco, quantidade);
  }

  @Override
  public double calcularValorTotal() {
    return this.getPreco() * this.getQuantidade();
  }
}