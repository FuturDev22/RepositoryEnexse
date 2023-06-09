package com.example.testtechnique.Controllers;

import com.example.testtechnique.Entities.Agent;
import com.example.testtechnique.Services.IAgentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AgentController {
    private IAgentServiceImp iAgentServiceImp;

    @Autowired
    public AgentController(IAgentServiceImp iAgentServiceImp) {
        this.iAgentServiceImp = iAgentServiceImp;
    }

    @GetMapping("/agents")
    public List<Agent> getAllAgents() {
        return iAgentServiceImp.getAllAgents();
    }

    @GetMapping("/{id}")
    public Optional<Agent> getAgentById(@PathVariable Long id) {
        return iAgentServiceImp.getAgentById(id);
    }

    @PostMapping("/agent")
    public Agent saveAgent(@RequestBody Agent agent) {
        return iAgentServiceImp.saveAgent(agent);
    }

    @PutMapping("/{name}")
    public Agent updateAgentByName(@PathVariable String name, @RequestBody Agent agent) {
        Optional<Agent> existingAgent = iAgentServiceImp.getAgentByName(name);
        if (existingAgent.isPresent()) {
            Agent updatedAgent = existingAgent.get();
            updatedAgent.setOs(agent.getOs());
            updatedAgent.setLastKeepAlive(agent.getLastKeepAlive());
            updatedAgent.setIp(agent.getIp());
            updatedAgent.setVersion(agent.getVersion());
            updatedAgent.setStatus(agent.getStatus());
            updatedAgent.setDateAdd(agent.getDateAdd());

            return iAgentServiceImp.saveAgent(updatedAgent);
        } else {
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void deleteAgentById(@PathVariable Long id) {
        iAgentServiceImp.deleteAgentById(id);
    }
}
