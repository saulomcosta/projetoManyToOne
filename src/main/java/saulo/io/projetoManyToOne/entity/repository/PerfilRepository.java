package saulo.io.projetoManyToOne.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saulo.io.projetoManyToOne.entity.Perfil;
import saulo.io.projetoManyToOne.enun.StatusPerfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	List<Perfil> findBystatusPerfil(StatusPerfil status);
}
