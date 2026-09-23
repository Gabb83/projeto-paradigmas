package models;

import java.util.ArrayList;
import java.util.List;

import models.exceptions.ProductIndisponivelException;

public class Estoque {
  private List<Product> produtos;
  
  Estoque() {
    this.produtos = new ArrayList<>();
  }

  public void adicionarProduto(Product novoProduto) {
    if(novoProduto != null) {
      this.produtos.add(novoProduto);
      System.out.println("novo produto adicionado: " + novoProduto.getNome());
    }
  }

  public void venderProduto(int indice, int quantidade) throws ProductIndisponivelException {
    if(indice < 0 || indice >= this.produtos.size()) {
      throw new IndexOutOfBoundsException("índice de produto inválido");
    }

    Product produto = this.produtos.get(indice);
    produto.vender(quantidade);
  }

  public double calcularValorTotalEstoque() {
    double valorTotal = 0.0;

    for(Product produto : this.produtos) {
      valorTotal += produto.calcularValorTotal();
    }

    return valorTotal;
  }


  public List<Product> getProdutos() {
    return this.produtos;
  }
}
