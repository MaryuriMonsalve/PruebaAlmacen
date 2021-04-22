package com.example.prueba.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "item_factura")
public class ItemFacturaEntity {

    @Id
    @Column(name = "id_item", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column(name= "cantidad", nullable = false)
    private Integer Cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_producto")
    private ProductoEntity producto;


}
