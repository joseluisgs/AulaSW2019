
package org.me.aulaservicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuario_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="alumno_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminar", propOrder = {
    "usuarioId",
    "alumnoId"
})
public class Eliminar {

    @XmlElement(name = "usuario_id")
    protected int usuarioId;
    @XmlElement(name = "alumno_id")
    protected int alumnoId;

    /**
     * Obtiene el valor de la propiedad usuarioId.
     * 
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * Define el valor de la propiedad usuarioId.
     * 
     */
    public void setUsuarioId(int value) {
        this.usuarioId = value;
    }

    /**
     * Obtiene el valor de la propiedad alumnoId.
     * 
     */
    public int getAlumnoId() {
        return alumnoId;
    }

    /**
     * Define el valor de la propiedad alumnoId.
     * 
     */
    public void setAlumnoId(int value) {
        this.alumnoId = value;
    }

}
