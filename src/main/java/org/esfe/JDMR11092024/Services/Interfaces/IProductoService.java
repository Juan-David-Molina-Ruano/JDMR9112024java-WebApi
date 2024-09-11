package org.esfe.JDMR11092024.Services.Interfaces;

import java.util.List;

import org.esfe.JDMR11092024.dtos.Productos.ProductoGuardar;
import org.esfe.JDMR11092024.dtos.Productos.ProductoModificar;
import org.esfe.JDMR11092024.dtos.Productos.ProductoSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductoService {

    public List<ProductoSalida> obtenerProductos();

    Page<ProductoSalida> obtenerProductosPaginados(Pageable pageable);

    ProductoSalida obtenerProductoPorId(Integer id);

    ProductoSalida guardarProducto(ProductoGuardar productoGuardar);

    ProductoSalida editar(ProductoModificar productoModificar);

    void eliminarPorId(Integer id);
}
