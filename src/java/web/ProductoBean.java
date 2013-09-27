/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.xml.ws.WebServiceRef;
import searchproducto.ProductoWebService_Service;

/**
 *
 * @author ClaudiaMontealegre
 */
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_9090/SearchProducto/ProductoWebService.wsdl")
    private ProductoWebService_Service service;
    List<String> listProductos;
    private String producto;

    /**
     * Creates a new instance of productoBean
     */
    public ProductoBean() {
    }
    
    
      public void listarProductos(){

        listProductos = search(producto);
    }

    private java.util.List<java.lang.String> search(java.lang.String search) {
        searchproducto.ProductoWebService port = service.getProductoWebServicePort();
        return port.search(search);
    }

    public List<String> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<String> listProductos) {
        this.listProductos = listProductos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
