package com.example.exam.controller;

import com.example.exam.entity.Product;
import com.example.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showProduct(Model model){
        List<Product> listProduct = (List<Product>) productService.getAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "list";
    }

    @RequestMapping(value = "addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("product") Product product,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        } else {
            productService.saveProduct(product);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/sellProduct", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Integer productId, Model model) {
        Optional<Product> productEdit = productService.findProductById(productId);
        productEdit.ifPresent(product -> model.addAttribute("product", product));
        return "editProduct";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer productId, Model model) {
        productService.deleteProduct(productId);
        return "redirect:/";
    }
}
