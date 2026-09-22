package models;

import interfaces.IVendavel;
import models.exceptions.ProductIndisponivelException;
import models.exceptions.QuantidadeInvalidaException;

public abstract class Product implements IVendavel {
  private String nome;
  private double preco;
  private int quantidade;

  Product(String nome, double preco, int quantidade) throws QuantidadeInvalidaException {
   if (quantidade < 0 || preco < 0) {
      throw new QuantidadeInvalidaException("Preço ou quantidade não podem ser negativos.");
    }
      
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public String getNome() { return this.nome; }
  public double getPreco() { return this.preco; }
  public int getQuantidade() { return this.quantidade; }

  abstract double calcularValorTotal();

  @Override 
  public void vender(int quantidadePedido) throws ProductIndisponivelException {
    if(quantidadePedido > this.quantidade) {
      throw new ProductIndisponivelException("quantidade indisponível");
    }

    this.quantidade -= quantidadePedido;
  }

  public String getDescricao() {
    return "nome do produto:" + getNome() +
           "valor do produto" + getPreco() +
           "quantidade de itens: " + getQuantidade();
  }
}
