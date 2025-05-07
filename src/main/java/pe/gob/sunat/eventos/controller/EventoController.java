package pe.gob.sunat.eventos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.gob.sunat.eventos.entities.Evento;
import pe.gob.sunat.eventos.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // Crear evento (el código se genera automáticamente)
    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento creado = eventoService.registrar(evento);
        return ResponseEntity.ok(creado);
    }

    // Listar todos los eventos
    @GetMapping
    public ResponseEntity<List<Evento>> listarTodos() {
        return ResponseEntity.ok(eventoService.listar());
    }

    // Obtener un evento por código
    @GetMapping("/{codigo}")
    public ResponseEntity<Evento> obtenerEvento(@PathVariable String codigo) {
        return eventoService.obtenerPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un evento existente
    @PutMapping("/{codigo}")
    public ResponseEntity<Evento> actualizar(@PathVariable String codigo, @RequestBody Evento evento) {
        return eventoService.actualizar(codigo, evento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un evento
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable String codigo) {
        if (eventoService.eliminar(codigo)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}