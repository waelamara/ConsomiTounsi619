package tn.esprit.spring.Repository.Rayon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import tn.esprit.spring.Model.Rayon.*;

public interface RayonRepository extends JpaRepository <Rayon, Long>   {
	
	@Query(value = "SELECT * FROM Rayon WHERE nom_rayon LIKE ?1%", nativeQuery = true)
	public List<Rayon> findRayonbyName(String string);

}
