/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camilo Marroquin
 */
@Stateless
public class ServicioCompraMock implements ServicioCompraMockLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public List<RegistroVenta> getComprasByUsuario(Usuario id) {
        return entityManager.createNamedQuery("RegistroVenta.findByIdUsuario", RegistroVenta.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
