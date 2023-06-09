package com.example.testtechnique.Services;

import com.example.testtechnique.Entities.Agent;

import java.util.List;
import java.util.Optional;

public interface IAgentServiceImp {
    List<Agent> getAllAgents();

    Optional<Agent> getAgentById(Long id);

    Agent saveAgent(Agent agent);

    void deleteAgentById(Long id);

    Optional<Agent> getAgentByName(String name);
}
