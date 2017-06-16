package healthchecker.domain.repository;

import healthchecker.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 1004w455 on 2017. 6. 17..
 */
@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {
}
