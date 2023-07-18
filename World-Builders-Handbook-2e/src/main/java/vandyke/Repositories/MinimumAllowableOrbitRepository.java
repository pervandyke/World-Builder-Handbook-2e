package vandyke.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vandyke.Reference.MinimumAllowableOrbit;

@Repository
public interface MinimumAllowableOrbitRepository extends JpaRepository<MinimumAllowableOrbit, String> {
    MinimumAllowableOrbit findByStarType(String starType);

}