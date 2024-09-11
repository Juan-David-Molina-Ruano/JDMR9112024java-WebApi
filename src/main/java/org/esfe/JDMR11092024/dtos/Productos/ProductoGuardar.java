package org.esfe.JDMR11092024.dtos.Productos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoGuardar implements Serializable {

    private String nombreJDMR;

    private BigDecimal precioJDMR;

    private String descripcionJDMR;
}
