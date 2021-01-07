/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import productservice.Product;
import productservice.ProductService;
import productservice.ProductService_Service;

/**
 *
 * @author lehuy
 */
public class saysomethingbro {
    public static void main(String[] args) {
        ProductService_Service xxx = new ProductService_Service();
        ProductService xx = xxx.getProductServicePort();
        Product x = xx.getProduct("xxxxxx1234");
        x.setName("123456789JQK");
        x.setInportPrice((float) 123.12312);
        x.setExportPrice((float)234.234234);
        System.out.println(xx.insertProduct(x));
    }
}