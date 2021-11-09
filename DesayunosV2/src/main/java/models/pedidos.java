package models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author AlejandroVicenteJarn
 */
@Entity
@Table(name="pedidos")
public class pedidos implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="cliente")
    private String cliente;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="estado")
    private String estado;
    @Column (name="carta_id")
    int cartaId;
    

    public pedidos() {
        
    }

    public pedidos(Integer id, String cliente, Date fecha, String estado, int cartaId) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.cartaId = cartaId;
    }

    public pedidos(int i, String nombre, String estado, int cartaId, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCartaId() {
        return cartaId;
    }

    public void setCartaId(int cartaId) {
        this.cartaId = cartaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "pedidios{" + "id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", estado=" + estado + ", cartaId=" + cartaId + '}';
    }
}