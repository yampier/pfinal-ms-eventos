package pe.gob.sunat.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.sunat.eventos.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, String> { 
	long countByCodigoEventoStartingWith(String prefijo); // para contar por día
}