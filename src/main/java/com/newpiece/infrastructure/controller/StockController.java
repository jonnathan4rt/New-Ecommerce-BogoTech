package com.newpiece.infrastructure.controller;
import com.newpiece.application.service.StockService;
import com.newpiece.application.service.ValidateStock;
import com.newpiece.domain.Product;
import com.newpiece.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show (@PathVariable Integer id, Model model){
        Product product = new Product();
        product.setId(id);
        List<Stock> stocks = stockService.getStockByProduct(product);
        model.addAttribute("stocks", stocks);
        model.addAttribute("idproduct", id);
        return "admin/stock/show";
    }

    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id);
        return "admin/stock/create";
    }
    @PostMapping("/save-unit-product")
    public String save(Stock stock, @RequestParam("idproduct") Integer idproduct){
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("inventario");
        Product product = new Product();
        product.setId(idproduct);
        stock.setProduct(product);
        stockService.saveStock( validateStock.calculateBalance(stock));
        return "redirect:/admin/products/show";
    }

}