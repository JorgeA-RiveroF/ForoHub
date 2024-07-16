package com.alura.API.domain.topico;

public record DatosListadoTopico(String título, String mensaje, String fechaCreacion, String status, String autor, String curso) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus().name(), topico.getAutor(), topico.getCurso().name());
    }
}
