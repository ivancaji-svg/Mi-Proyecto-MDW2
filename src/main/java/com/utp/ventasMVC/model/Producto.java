package com.utp.ventasMVC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    @Size(min = 3,max = 100)
    @Column(nullable = false,
            length =100 )
    private String nombre;
    @Positive(message = "Precio no valido")
    @Column(nullable = false)
    private Double precio;
    @Min(value=0 , message = "Stock no valido")
    @Column(nullable = false)
    private Integer stock;
    @Column(length = 200)
    private String image;
    @ManyToOne
    @OneToMany(mappedBy = "categoria")
    @JoinColumn(name = "id_categoria",nullable = false)
    private Categoria categoria;
}
