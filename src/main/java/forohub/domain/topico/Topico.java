package forohub.domain.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private String fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String respuestas;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha_creacion = datosRegistroTopico.fechaCreacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.respuestas = datosRegistroTopico.respuestas();

    }



    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
       if (datosActualizarTopico.titulo() != null) {
           this.titulo = datosActualizarTopico.titulo();
       }

       if (datosActualizarTopico.mensaje() != null){
        this.mensaje = datosActualizarTopico.mensaje();
       }

       if (datosActualizarTopico.status() != null){
        this.status = datosActualizarTopico.status();
       }

       if (datosActualizarTopico.autor() != null){
        this.autor = datosActualizarTopico.autor();
       }

       if (datosActualizarTopico.curso() != null){
        this.curso = datosActualizarTopico.curso();
       }
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }
}


