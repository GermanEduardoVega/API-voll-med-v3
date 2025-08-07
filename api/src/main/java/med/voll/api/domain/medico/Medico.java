package med.voll.api.domain.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Entity(name = "Medico")    //Para que se genere la tabla en la base de datos
@Table(name = "medicos")
@Getter //metodos getter se generan en tiempo de compilacion
@NoArgsConstructor  //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@EqualsAndHashCode(of = "id")   //identifica que campos son iguales es decir que objetos si el id es igual
public class Medico {       //clase Medico publica con los atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que se genere el id por defecto en la base de datos
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)    //Para guardar el enum en la base de datos
    private Especialidad especialidad;
    @Embedded   //Embedded para guardar el objeto en la base de datos
    private Direccion direccion;

    public Medico(DatosRegistroMedico datos) {
        this.id = null;
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarInformaciones(@Valid DatosActualizacionMedico datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();   //si el nombre es null entonces no se actualiza
        }
        if (datos.telefono()!= null) {
            this.telefono = datos.telefono();
        }
        if (datos.direccion() != null) {
            this.direccion.actualizarDireccion(datos.direccion());

        }
    }

    public void eliminarInformacion() {
        this.activo = false;
    }
}
