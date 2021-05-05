package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class StockService{
  
  @Autowired
  StockRepository stockRepository;
  
  /**
   * レコードを全件取得する。
   * @return
   */
  public List<Stock> findAllStockData(){
    
    return stockRepository.findAll();
  }

public void insert(Stock stock) {
	// TODO Auto-generated method stub
	stockRepository.save(stock);
}

}
