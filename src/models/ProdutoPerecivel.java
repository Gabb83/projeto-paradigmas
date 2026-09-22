package models;

import models.exceptions.QuantidadeInvalidaException;

public class ProdutoPerecivel extends Product{
  private int diasParaVencer;

  public ProdutoPerecivel(String nome, double preco, int quantidade, int diasParaVencer) throws  QuantidadeInvalidaException {
    super(nome, preco, quantidade);
    this.diasParaVencer = diasParaVencer;
  }

  public int getDiasParaVencer() { return this.diasParaVencer; }

  @Override
  public double calcularValorTotal() {
    if(this.diasParaVencer <= 3) {
      return (this.getPreco()*this.getQuantidade())*0.2;
    } 

    return this.getPreco() * this.getQuantidade();
  }

  @Override 
  public String getDescricao() {
    return super.getDescricao() + 
            "dias para vencer: " + getDiasParaVencer();
  }
}
