package com.newpiece.application.service;

import com.newpiece.application.repository.ProductRepository;
import com.newpiece.domain.Product;
import com.newpiece.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Product> getProducts(){
        return  productRepository.getProducts();
    }

    public Iterable<Product> getProductsByUser(User user){
        return productRepository.getProductsByUser(user);
    }

    public Product getProductById(Integer id){
        return  productRepository.getProductById(id);
    }

    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if(product.getId()==null){
            User user = new User();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile));
            return   productRepository.saveProduct(product);
        }else{
            Product productDB= productRepository.getProductById(product.getId());
            log.info("product : {}", productDB);
            //sino se carga la imagen toma la que se le guardó al registro
            if(multipartFile.isEmpty()){
                product.setImage(productDB.getImage());
            }else{//guarda la que se le envía actualmente
                //antes se elimina pero si no es por defecto
                if (!productDB.getImage().equals("default.jpg")){
                    uploadFile.delete(productDB.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return  productRepository.saveProduct(product);
        }

    }

    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }



}