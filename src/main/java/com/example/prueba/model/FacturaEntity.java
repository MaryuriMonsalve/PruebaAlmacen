package com.example.prueba.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name="factura")
public class FacturaEntity {

    @Id
    @Column(name = "id_factura", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name= "iva", length = 15)
    private Double iva;

    @Column(name= "domicilio", length = 60)
    private Double domicilio;

    @Column(name= "subtotal", length = 60)
    private Double subtotal;

    @Column(name= "total", length = 60)
    private Double total;

    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinColumn(name="id_item")
    private List<ItemFacturaEntity> item;

    public FacturaEntity() {
        this.item = new ArrayList<ItemFacturaEntity>();
    }



}
