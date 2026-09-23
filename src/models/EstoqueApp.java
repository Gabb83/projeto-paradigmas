package models;

import models.exceptions.ProductIndisponivelException;
import models.exceptions.QuantidadeInvalidaException;

public class EstoqueApp {
  public static void main(String[] args) {
    try {
      Estoque estoque = new Estoque();

      ProdutoComum produtoC1 = new ProdutoComum("celular", 1200.00, 8);
      ProdutoComum produtoC2 = new ProdutoComum("fone", 80.00, 12);

      ProdutoPerecivel produtoP1 = new ProdutoPerecivel("cocada", 7.00, 10, 2);
      ProdutoPerecivel produtoP2 = new ProdutoPerecivel("café", 16.00, 40, 30);

      estoque.adicionarProduto(produtoC1);
      estoque.adicionarProduto(produtoC2);
      estoque.adicionarProduto(produtoP1);
      estoque.adicionarProduto(produtoP2);

      try {
        ProdutoComum produtoC3 = new ProdutoComum("mouse", 50.00, -5);
        estoque.adicionarProduto(produtoC3);
      } catch (QuantidadeInvalidaException e) {
        System.out.println("\nerro ao cadastrar produto: " + e.getMessage());
      }

      try {
        produtoC1.vender(3); 
        System.out.println("venda efetuada com sucesso. restam: " + produtoC1.getQuantidade());
        
        produtoC1.vender(10); 
      } catch (ProductIndisponivelException e) {
        System.out.println("erro ao realizar venda: " + e.getMessage());
      }

      System.out.printf("\nvalor total do estoque: R$ %.2f\n", estoque.calcularValorTotalEstoque());

    } catch (QuantidadeInvalidaException e) {
      System.out.println("erro na criação dos produtos iniciais: " + e.getMessage());
      
    } catch(Exception e) {
      System.out.println("erro genérico");
    } 
  }
}