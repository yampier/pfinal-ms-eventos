package pe.gob.sunat.eventos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sunat.eventos.entities.Evento;
import pe.gob.sunat.eventos.repository.EventoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    // Utilizamos un contador para incrementar el código secuencial
    private AtomicInteger secuencial = new AtomicInteger(1);

    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Registrar evento con código generado
    @Override
    @Transactional
    public Evento registrar(Evento evento) {
        // Generar código evento
        String codigoEvento = generarCodigoEvento();
        evento.setCodigoEvento(codigoEvento);
        return eventoRepository.save(evento);
    }

    // Listar todos los eventos
    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    // Obtener evento por código
    @Override
    public Optional<Evento> obtenerPorCodigo(String codigo) {
        return eventoRepository.findById(codigo);
    }

    // Actualizar evento
    @Override
    @Transactional
    public Optional<Evento> actualizar(String codigo, Evento evento) {
        if (eventoRepository.existsById(codigo)) {
            evento.setCodigoEvento(codigo); // Aseguramos que el código no se cambie
            return Optional.of(eventoRepository.save(evento));
        }
        return Optional.empty();
    }

    // Eliminar evento por código
    @Override
    @Transactional
    public boolean eliminar(String codigo) {
        if (eventoRepository.existsById(codigo)) {
            eventoRepository.deleteById(codigo);
            return true;
        }
        return false;
    }

    // Método para generar el código de evento en formato EVTyyyyMMddNNN
    private String generarCodigoEvento() {
        String fecha = LocalDate.now().toString().replace("-", "");
        int numSecuencial = secuencial.getAndIncrement();
        return "EVT" + fecha + String.format("%03d", numSecuencial);
    }
}