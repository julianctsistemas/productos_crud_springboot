package com.example.crud_web.controlador;
import com.example.crud_web.modelo.Producto;
import com.example.crud_web.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepositorio.findAll());
        return "productos";
    }

    @GetMapping("/registroProducto")
    public String registroProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "registroProducto";

    }

    @PostMapping("/registroProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoRepositorio.save(producto);
        return "redirect:/productos";
    }

    @PostMapping(value = "/modificarProducto")
    public String actualizarProducto(@ModelAttribute Producto producto) {
        productoRepositorio.save(producto);
        return "redirect:/productos";
    }

    @GetMapping(value = "/modificarProducto/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
         model.addAttribute("producto", productoRepositorio.findById(id));
        return "modificarProducto";
    }
    @PostMapping(value = "/eliminar")
    public String eliminarProducto(@ModelAttribute Producto producto) {
           productoRepositorio.deleteById(producto.getId());
        return "redirect:/productos";
    }

}








