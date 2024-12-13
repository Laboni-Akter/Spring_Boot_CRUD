package com.product.controller;

import com.product.entity.products;
import com.product.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productrepo;
    @GetMapping("/")
    public String index(Model m)
    {
        List<products> list = productrepo.findAll();
        m.addAttribute("allproducts",list);
        return "index";
    }
    @GetMapping("/add-form")
    public String add()
    {
        return "add";
    }
    @GetMapping("/edit-form/{id}")
    public String edit(@PathVariable Long id, Model m)
    {
        Optional<products> item = productrepo.findById(id);
        m.addAttribute("item",item);
        return "edit";
    }
    @PostMapping("/save_product")
    public String saveproduct(@ModelAttribute products product, Model m)
    {
        productrepo.save(product);
       m.addAttribute("msg","Product saved successfully");
        return "add";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute products item)
    {
        productrepo.save(item);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String update(@PathVariable Long id)
    {
        productrepo.deleteById(id);
        return "redirect:/";
    }
}