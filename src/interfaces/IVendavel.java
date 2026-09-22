package interfaces;

import models.exceptions.ProductIndisponivelException;

public interface IVendavel {
  public void vender(int quantidade)
    throws ProductIndisponivelException;
}
