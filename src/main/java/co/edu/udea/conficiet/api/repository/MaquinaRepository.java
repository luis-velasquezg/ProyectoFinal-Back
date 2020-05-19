package co.edu.udea.conficiet.api.repository;

import co.edu.udea.conficiet.api.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
// public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User>

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, String> {
//    Maquina findMaquinaByEstadoEquals(String estado);

}
