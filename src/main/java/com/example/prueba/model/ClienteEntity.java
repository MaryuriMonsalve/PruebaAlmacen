package com.example.prueba.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="cliente")
public class ClienteEntity {

    @Id
    @Column(name = "id_cliente", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name= "Cedula", nullable = false, length = 15)
    private String cedula;

    @Column(name= "direccion", length = 60)
    private String direccion;

    /*
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
    private List<FacturaEntity> factura;

    public ClienteEntity() {factura = new ArrayList<FacturaEntity>();}

     */

}
