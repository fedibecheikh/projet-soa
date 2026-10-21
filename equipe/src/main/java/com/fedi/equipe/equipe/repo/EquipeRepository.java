package com.fedi.equipe.equipe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedi.equipe.equipe.entities.Equipe;
import com.fedi.equipe.equipe.entities.Ligue;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    List<Equipe> findByNomEquipe(String nom);

    List<Equipe> findByNomEquipeContains(String nom);

    @Query("select e from Equipe e where e.nomEquipe like %:nom and e.budget > :budget")
    List<Equipe> findByNomBudget(@Param("nom") String nom, @Param("budget") Double budget);

    List<Equipe> findByNomEquipeAndBudget(String nom, double budget);

    List<Equipe> findByLigue(Ligue ligue);

    List<Equipe> findByLigueIdLigue(Long id);

    List<Equipe> findByOrderByNomEquipeAsc();

    @Query("select e from Equipe e order by e.nomEquipe ASC, e.budget DESC")
    List<Equipe> trierEquipesNomsBudget();
}
