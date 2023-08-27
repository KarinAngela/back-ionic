package ionic.back.repositorios;

import ionic.back.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    public List<Chamado> findAllByIdUsuario(Integer id_usuario);
}
