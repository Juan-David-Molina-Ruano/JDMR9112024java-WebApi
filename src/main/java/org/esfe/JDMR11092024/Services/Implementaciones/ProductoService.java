package org.esfe.JDMR11092024.Services.Implementaciones;

import java.util.List;
import java.util.stream.Collectors;

import org.esfe.JDMR11092024.Models.ProductoJDMR;
import org.esfe.JDMR11092024.Repositorios.IProductoRepository;
import org.esfe.JDMR11092024.Services.Interfaces.IProductoService;
import org.esfe.JDMR11092024.dtos.Productos.ProductoGuardar;
import org.esfe.JDMR11092024.dtos.Productos.ProductoModificar;
import org.esfe.JDMR11092024.dtos.Productos.ProductoSalida;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoSalida> obtenerProductos() {
        
        List<ProductoJDMR> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductoSalida> obtenerProductosPaginados(Pageable pageable) {
        
        Page<ProductoJDMR> page = productoRepository.findAll(pageable);

        List<ProductoSalida> productoDto = page.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productoDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductoSalida obtenerProductoPorId(Integer id) {
        return modelMapper.map(productoRepository.findById(id).get(), ProductoSalida.class);
    }

    @Override
    public ProductoSalida guardarProducto(ProductoGuardar productoGuardar) {
        ProductoJDMR producto = productoRepository.save(modelMapper.map(productoGuardar, ProductoJDMR.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public ProductoSalida editar(ProductoModificar productoModificar) {
        ProductoJDMR producto = productoRepository.save(modelMapper.map(productoModificar, ProductoJDMR.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }

}
