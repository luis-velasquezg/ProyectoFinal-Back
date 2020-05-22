package co.edu.udea.conficiet.api.repository;

import co.edu.udea.conficiet.api.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;

// import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
// public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User>

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, String> {
    Maquina findMaquinaById(int id);

    void deleteMaquinaById(int id);
}
