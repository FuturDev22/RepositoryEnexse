package com.example.testtechnique.Services;


import com.example.testtechnique.Entities.Agent;
import com.example.testtechnique.Repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImp implements IAgentServiceImp {
    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImp(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
@Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }
@Override
    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }
@Override
    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }
@Override
    public void deleteAgentById(Long id) {
        agentRepository.deleteById(id);
    }
    @Override
    public Optional<Agent> getAgentByName(String name) {
        return agentRepository.findByName(name);
    }

}
