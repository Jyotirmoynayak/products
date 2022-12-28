package com.app.product.service;

import com.app.product.entities.Product;
import com.app.product.repository.ProductRepository;
import com.app.product.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProductsTest() {
        List<Product> productList = getMockedProducts();
        when(productRepository.findAll()).thenReturn(productList);
        Assert.assertEquals(2, productService.getAllProducts().size());
    }

    @Test
    public void saveProductsTest() {
        when(productRepository.saveAll(getMockedProducts())).thenReturn(getMockedProducts());
        Assert.assertEquals(2, productService.saveProducts(getMockedProducts()).size());
    }

    @Test
    public void updateProductTest() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("TV");
        product.setPrice(45000.00);
        when(productRepository.findById(product.getProductId())).thenReturn(Optional.ofNullable(product));
        Assert.assertEquals(null, productService.updateProduct(product));
    }

//    @Test
//    public void updateProductTestNull() {
//        Product product = new Product();
//        product.setProductId(999);
//        product.setName("TV");
//        product.setPrice(45000.00);
//        when(productRepository.findById(product.getProductId())).thenReturn(null);
//        Assert.assertEquals(null, productService.updateProduct(product));
//    }

    private List<Product> getMockedProducts() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setName("TV");
        product1.setPrice(45000.00);
        productList.add(product1);
        Product product2 = new Product();
        product2.setProductId(1);
        product2.setName("Sofa");
        product2.setPrice(25000.50);
        productList.add(product2);
        return productList;
    }
}
