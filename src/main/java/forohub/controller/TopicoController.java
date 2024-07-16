package forohub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.alura.challenge.forohub.domain.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {


    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private PagedResourcesAssembler<DatosListadoTopico> pagedResourcesAssembler;



    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        // Verificar si el tópico ya existe
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje());
        if (existente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El tópico ya existe");
        }

        // Guardar el nuevo tópico
        topicoRepository.save(new Topico(datosRegistroTopico));
        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico registrado con éxito");
    }



    @GetMapping

    public ResponseEntity<PagedModel<EntityModel<DatosListadoTopico>>> listadoTopico(@PageableDefault(size = 5) Pageable paginacion) {
        Page<DatosListadoTopico> page = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        PagedModel<EntityModel<DatosListadoTopico>> pagedModel = pagedResourcesAssembler.toModel(page);
        return ResponseEntity.ok(pagedModel);


   //Lo hice así porque me daba este mensaje: 	For a stable JSON structure, please use Spring Data's PagedModel (globally via @EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO))
        //	or Spring HATEOAS and Spring Data's PagedResourcesAssembler as documented in https://docs.spring.io/spring-data/commons/reference/repositories/core-extensions.html#core.web.pageables.
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DatosListadoTopico>> detalleTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            DatosListadoTopico datosListadoTopico = new DatosListadoTopico(optionalTopico.get());
            return ResponseEntity.ok(EntityModel.of(datosListadoTopico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional

    public ResponseEntity<String> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        // Verificar si el tópico con el ID existe
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado");
        }

        // Verificar si hay un tópico duplicado
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(datosActualizarTopico.titulo(), datosActualizarTopico.mensaje());
        if (existente.isPresent() && !existente.get().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El tópico ya existe con el mismo título y mensaje");
        }


        Topico topico = optionalTopico.get();
        topico.actualizarDatos(datosActualizarTopico);
        topicoRepository.save(topico); // Asegurarse de guardar los cambios
        return ResponseEntity.ok("Tópico actualizado con éxito");}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado");
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.ok("Tópico eliminado con éxito");
    }
}
