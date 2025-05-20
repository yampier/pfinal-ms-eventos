package pe.gob.sunat.eventos.service;

import java.util.List;
import java.util.Optional;

import pe.gob.sunat.eventos.entities.Evento;

public interface EventoService {
    Evento registrar(Evento evento);
    Optional<Evento> obtenerPorCodigo(String codigo);
    List<Evento> listar();
    Optional<Evento> actualizar(String codigo, Evento evento);
    boolean eliminar(String codigo);
}