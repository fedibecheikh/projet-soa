package com.fedi.equipe.equipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedi.equipe.equipe.entities.Equipe;
import com.fedi.equipe.equipe.entities.Ligue;
import com.fedi.equipe.equipe.repo.EquipeRepository;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe saveEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Equipe e) {
        equipeRepository.delete(e);
    }

    @Override
    public void deleteEquipeById(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe getEquipe(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public List<Equipe> findByNomEquipe(String nom) {
        return equipeRepository.findByNomEquipe(nom);
    }

    @Override
    public List<Equipe> findByNomEquipeContains(String nom) {
        return equipeRepository.findByNomEquipeContains(nom);
    }

    @Override
    public List<Equipe> findByNomBudget(String nom, Double budget) {
        return equipeRepository.findByNomBudget(nom, budget);
    }

    @Override
    public List<Equipe> findByLigue(Ligue ligue) {
        return equipeRepository.findByLigue(ligue);
    }

    @Override
    public List<Equipe> findByLigueIdLigue(Long id) {
        return equipeRepository.findByLigueIdLigue(id);
    }

    @Override
    public List<Equipe> findByOrderByNomEquipeAsc() {
        return equipeRepository.findByOrderByNomEquipeAsc();
    }
    
    @Override
    public List<Equipe> trierEquipesNomsBudget() {
        return equipeRepository.trierEquipesNomsBudget();
    }
}