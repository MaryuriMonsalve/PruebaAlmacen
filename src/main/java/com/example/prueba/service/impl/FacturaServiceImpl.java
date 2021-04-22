package com.example.prueba.service.impl;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.dto.mapper.FacturaConverter;
import com.example.prueba.exception.PruebaException;
import com.example.prueba.model.FacturaEntity;
import com.example.prueba.model.ItemFacturaEntity;
import com.example.prueba.repository.ClienteRepository;
import com.example.prueba.repository.FacturaRepository;
import com.example.prueba.repository.ItemFacturaRepository;
import com.example.prueba.repository.ProductoRepository;
import com.example.prueba.service.FacturaService;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FacturaServiceImpl implements FacturaService {

   public FacturaRepository facturaRepository;
   public ClienteRepository clienteRepository;
   public ProductoRepository productoRepository;
   public ItemFacturaRepository itemFacturaRepository;
   public FacturaConverter facturaConverter;

   public FacturaServiceImpl(FacturaRepository facturaRepository, ClienteRepository clienteRepository,
                             ProductoRepository productoRepository, FacturaConverter facturaConverter,
                             ItemFacturaRepository itemFacturaRepository){
      this.facturaRepository=facturaRepository;
      this.clienteRepository=clienteRepository;
      this.productoRepository=productoRepository;
      this.facturaConverter=facturaConverter;
      this.itemFacturaRepository= itemFacturaRepository;


   }

    @Override
    public FacturaDto agregarPedido(FacturaDto factura) throws PruebaException {
        AtomicReference<Double> totalProducto = new AtomicReference<>(0.0);


        LocalDateTime now = LocalDateTime.now();
        factura.setHoraRegistro(now);
        FacturaEntity f= facturaConverter.toEntity(factura);



        Double suma= 0.0;
        for (ItemFacturaEntity fac: f.getItem()) {
            suma += (fac.getProducto().getPrecio() * fac.getCantidad());
            totalProducto.set(suma) ;
        }

        factura.setSubtotal(totalProducto.get());

        factura.setIva(totalProducto.get() * 0.019);
        factura.setTotal(factura.getIva()+ totalProducto.get());

        if(totalProducto.get() >100000){
           factura.setDomicilio(new Double(0));
        }else if(totalProducto.get() >70000) {
            factura.setDomicilio(  new Double(5000));
            factura.setTotal(factura.getIva()+ factura.getSubtotal() +factura.getDomicilio());
        }
        else{
           throw new PruebaException("El valor del pedido debe ser mínimo de 70000");
        }
         facturaRepository.save(f);

        factura.setNumFactura(f.getIdFactura());
         return factura;
    }

    @Override
    public FacturaDto editarPedido(FacturaDto factura) throws PruebaException {

        FacturaEntity existe = facturaRepository.findById(factura.getNumFactura()).get();

        if (existe != null) {

            LocalDateTime fechaEdicion = LocalDateTime.now();
            LocalDateTime fechaRegistro = existe.getCreateAt();
            LocalDateTime diferenciaMax = fechaRegistro.plusHours(5);
            Double newTotal = 0.0;
            FacturaEntity fact= facturaConverter.toEntity(factura);
            FacturaDto dtoEdit=facturaConverter.toDto(existe);


            if (fechaEdicion.isBefore(diferenciaMax)) {

                for (ItemFacturaEntity fac: fact.getItem()) {
                    newTotal += (fac.getProducto().getPrecio() * fac.getCantidad());
                }
                if(newTotal>=existe.getSubtotal()){
                    factura.setNumFactura(existe.getIdFactura());
                    factura.setCliente(dtoEdit.getCliente());
                    factura.setProductos(dtoEdit.getProductos());
                    factura.setSubtotal(newTotal);
                    factura.setIva(newTotal*0.19);
                    factura.setHoraRegistro(fechaEdicion);

                    if(newTotal >100000){
                        factura.setDomicilio(new Double(0));
                    }else if(newTotal >70000) {
                        factura.setDomicilio(  new Double(5000));
                        factura.setTotal(factura.getIva()+ factura.getSubtotal() +factura.getDomicilio());

                    }
                    else{
                        throw new PruebaException("El valor del pedido debe ser mínimo de 70000");
                    }


                    FacturaEntity f = facturaConverter.toEntity(factura);
                    f.setIdFactura(existe.getIdFactura());
                    facturaRepository.save(f);

                }
            } else {
                throw new PruebaException("No puede editar, han pasado más de 5 horas desde que registró el pedido");
            }

            return factura;
        }
        throw new PruebaException("No existe el numero de factura seleccionado");
    }

    @Override
    public Double eliminarPedido(Long idFactura) throws PruebaException {

       FacturaEntity existe= facturaRepository.findById(idFactura).get();
       LocalDateTime now= LocalDateTime.now();
       LocalDateTime registro = existe.getCreateAt();
       LocalDateTime diferencia= registro.plusHours(12);
       Double newTotal=0.0;

       if(now.isBefore(diferencia)){
           facturaRepository.deleteById(idFactura);
        }
       else{
           newTotal= existe.getTotal()*0.10;
           facturaRepository.deleteById(idFactura);
       }
       return newTotal;
    }


}
