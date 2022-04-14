/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Andres
 */
@Stateless
public class ServicioOfertaMock implements IServicioOfertaMockLocal {

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    public ServicioOfertaMock() {
        this.persistencia = new ServicioPersistenciaMock();
    }

    @Override
    public void agregarOferta(Oferta oferta) {
        try {
            persistencia.create(oferta);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioOfertaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Oferta> mostrarOfertas() {
        return persistencia.findAll(Oferta.class);
    }

}
