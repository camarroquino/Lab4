/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Usuario.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa un usuario del sistema
 * 
 */
@XmlRootElement
    @NamedQueries({
        @NamedQuery(name="Usuario.FindByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.contraseña = :contraseña")
    })

@Entity
public class Usuario
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Nombre del usuario
     */
    @Column(name = "LOGIN")
    private String login;

    /**
     * Contraseña del usuario
     */
     @Column(name = "CONTRASEÑA")
    private String contraseña;

    /**
     * Tipo de usuario
     */
    private TipoUsuario tipoUsuario;

    /**
     * Nombres y apellidos del usuario
     */
    private String nombreCompleto;

    /**
     * Número de documento de identidad
     */
    private long documento;

    /**
     * Tipo de documento
     */
    private TipoDocumento tipoDocumento;

    /**
     * Número del teléfono local
     */
    private long telefonoLocal;

    /*
     * Número del teléfono celular
     */
    private long telefonoCelular;

    /**
     * Ciudad de residencia del usuario
     */
    @ManyToOne
    private Ciudad ciudad;

    /**
     * Dirección de residencia del usuario
     */
    private String direccion;

    /**
     * Profesión del usuario
     */
    @Enumerated(EnumType.STRING)
    private Profesion profesion;

    /**
     * Correo electrónico del usuario
     */
    private String correo;

    /**
     * Indica si el mueble fue seleccionado
     */
    
    private boolean seleccion;

    /**
     * Devuelve un lista con todos las compras del usuario
     */
    @OneToMany(mappedBy = "comprador")
    private List<RegistroVenta>compras;
    @Id
    private Long id;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
    public Usuario()
    {

    }

    /**
     * Constructor de la clase con argumentos
     * @param nombre Nombre del usuario
     * @param contraseña Constraseña del usuario
     * @param tipo Tipo de usuario
     */
    public Usuario(String login, String contrasena, TipoUsuario tipoUsuario)
    {
        this.login = login;
        this.contraseña = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.compras=new ArrayList<RegistroVenta>();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el nombre de usuario
     * @return nombre Nombre del usuario
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Modifica el nombre del usuario
     * @param nombre Nuevo nombre de usuario
     */
    public void setLogin(String nombre)
    {
        this.login = nombre;
    }

    /**
     * Devuelve la contraseña del usuario
     * @return contraseña Contraseña del usuario
     */
    public String getContraseña()
    {
        return contraseña;
    }

    /**
     * Modifica la contraseña del usuario
     * @param contraseña Nueva contraseña
     */
    public void setContraseña(String contrasena)
    {
        this.contraseña = contrasena;
    }

    /**
     * Devuelve el tipo de usuario
     * @return tipo Tipo de usuario
     */
    public TipoUsuario getTipoUsuario()
    {
        return tipoUsuario;
    }

    /**
     * Modifica el tipo de usuario
     * @param tipo Nuevo tipo de usuario
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Devuelve la ciudad de residencia del usuario
     * @return ciudad Ciudad de residencia del cliente
     */
    public Ciudad getCiudad()
    {
        return ciudad;
    }

    /**
     * Modifica la ciudad de residencia del usuario
     * @param ciudad Nueva ciudad de residencia
     */
    public void setCiudad(Ciudad ciudad)
    {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve el correo electrónico del usuario
     * @return correo Correo electrónico del usuario
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * Modifica el correo electrónico del usuario
     * @param correo Nuevo correo electrónico
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * Devuelve la dirección de residencia del usuario
     * @return direccion Dirección de residencia del usuario
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * Modifica la dirección del usuario
     * @param direccion Nueva dirección del usuario
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * Devuelve el número de identificación del usuario
     * @return documento Número de identificación del usuario
     */
    public long getDocumento()
    {
        return documento;
    }

    /**
     * Modifica el número de identificación del usuario
     * @param documento Número de identificación
     */
    public void setDocumento(long documento)
    {
        this.documento = documento;
    }

    /**
     * Devuelve el nombre completo del usuario
     * @return nombreCompleto Nombre completo del usuario
     */
    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    /**
     * Modifica el nombre de un usuario
     * @param nombreCompleto Nuevo nombre del usuario
     */
    public void setNombreCompleto(String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve la profesión del usuario
     * @return profesion Profesión del usuario
     */
    public Profesion getProfesion()
    {
        return profesion;
    }

    /**
     * Modifica la profesión del usuario
     * @param profesion Nueva profesión
     */
    public void setProfesion(Profesion profesion)
    {
        this.profesion = profesion;
    }

    /**
     * Devuelve el número teléfono celular del usuario
     * @return telefonoCelular Número de teléfono celular del cliente
     */
    public long getTelefonoCelular()
    {
        return telefonoCelular;
    }

    /**
     * Modifica el número de teléfono celular del usuario
     * @param telefonoCelular Nuevo número de teléfono
     */
    public void setTelefonoCelular(long telefonoCelular)
    {
        this.telefonoCelular = telefonoCelular;
    }

    /**
     * Devuelve el número de teléfono local
     * @return telefonoLocal Número de teléfono local
     */
    public long getTelefonoLocal()
    {
        return telefonoLocal;
    }

    /**
     * Modifica el número del teléfono local del usuario
     * @param telefonoLocal Nuevo número de teléfono
     */
    public void setTelefonoLocal(long telefonoLocal)
    {
        this.telefonoLocal = telefonoLocal;
    }

    /**
     * Devuelve el tipo de documento que tiene un usuario
     * @return tipoDocumento Tipo de documento del usuario
     */
    public TipoDocumento getTipoDocumento()
    {
        return tipoDocumento;
    }

    /**
     * Modifica el tipo de documento del usuario
     * @param tipoDocumento Nuevo tipo de documento
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento)
    {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Devuelve las compras realizadas por un cliente
     * @return compras Lista con las compras realizadas por el cliente
     */
    public List<RegistroVenta> getCompras()
    {
        return compras;
    }

    /**
     * Modifica las compras realizadas por un cliente
     * @param compras Nueva lista de compras
     */
    public void setCompras(List<RegistroVenta> compras)
    {
        this.compras = compras;
    }

    /**
     * Agrega un registro de venta al usuario
     * @param registro Nuevo registro de venta
     */
    public void agregarRegistro(RegistroVenta registro)
    {
        compras.add(registro);
    }

    /**
     * El usuario se encuentra seleccionado
     * @return selección Estado del usuario
     */
    public boolean isSeleccion() {
        return seleccion;
    }

    /**
     * Modifica el estado de selección del usuario
     * @param seleccion Nuevo estado
     */
    public void setSeleccion(boolean seleccion)
    {
        this.seleccion = seleccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
