package saulo.io.projetoManyToOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import saulo.io.projetoManyToOne.entity.Perfil;
import saulo.io.projetoManyToOne.entity.Usuario;
import saulo.io.projetoManyToOne.entity.repository.PerfilRepository;
import saulo.io.projetoManyToOne.entity.repository.UsuarioRepository;
import saulo.io.projetoManyToOne.enun.StatusPerfil;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Perfil perfil = new Perfil();
		perfil.setNome("Admin");
		perfil.setStatusPerfil(StatusPerfil.ATIVO);
		Perfil perfil2 = new Perfil();
		perfil2.setNome("Aluno");
		perfil2.setStatusPerfil(StatusPerfil.INATIVO);

		perfilRepository.save(perfil);
		perfilRepository.save(perfil2);

		Usuario usuario = new Usuario();
		usuario.setNome("Saulo");
		usuario.setEmail("saulo@");
		usuario.setPerfil(perfil);

		usuarioRepository.save(usuario);

		usuario = new Usuario();
		usuario.setNome("Pedro");
		usuario.setEmail("pedro@");
		usuario.setPerfil(perfil);

		usuarioRepository.save(usuario);

		usuario = new Usuario();
		usuario.setNome("Maria");
		usuario.setEmail("maria@");
		usuario.setPerfil(perfil2);

		usuarioRepository.save(usuario);

		usuario = new Usuario();
		usuario.setNome("Matilde");
		usuario.setEmail("mat@");
		usuario.setPerfil(perfil2);

		usuarioRepository.save(usuario);

		usuario = new Usuario();
		usuario.setNome("Mateus");
		usuario.setEmail("mateus@");
		usuario.setPerfil(perfil2);

		usuarioRepository.save(usuario);

		List<Perfil> status = this.perfilRepository.findBystatusPerfil(StatusPerfil.ATIVO);

		for (Perfil perfil3 : status) {
			System.out.println(perfil3.getNome());
		}

	}

}
