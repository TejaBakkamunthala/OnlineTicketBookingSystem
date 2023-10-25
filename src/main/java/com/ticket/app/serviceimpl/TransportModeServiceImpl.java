package com.ticket.app.serviceimpl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ticket.app.common.Pagination;
import com.ticket.app.entity.TransportMode;
import com.ticket.app.repository.TransportModeRepository;
import com.ticket.app.service.TransportModeService;


   
@Service
public class TransportModeServiceImpl implements  TransportModeService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransportModeRepository transportModeRepository;

    public Page<TransportMode> getListOfTransportModes(TransportMode searchedModeObject, Pagination pagination) {
        logger.info("Entering into getListOfTransportModes method");
        Page<TransportMode> listOfModesToBeReturned = transportModeRepository.findAll(
                searchCriteriaForTransportMode(searchedModeObject),
                pagination.getPageableInstance());
        return listOfModesToBeReturned;
    }

    public Specification<TransportMode> searchCriteriaForTransportMode(TransportMode modeObject) {
        logger.info("Entering into searchCriteriaForTransportMode method");
        return Specification.where(
                modeObject.getModeName() != null ? containsModeName(modeObject.getModeName()) : null)
                .and(modeObject.getModeId() > 0 ? containsModeId(modeObject.getModeId()) : null);
    }

    private Specification<TransportMode> containsModeName(String modeName) {
        return (mode, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(mode.get("modeName"), modeName);
    }

    private Specification<TransportMode> containsModeId(int modeId) {
        return (mode, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(mode.get("modeId"), modeId);
    }

    @Transactional
    public TransportMode saveOrUpdateTransportMode(TransportMode transportMode) {
        logger.info("Entering into saveOrUpdateTransportMode method");
        return transportModeRepository.saveAndFlush(transportMode);
    }

    public TransportMode getTransportModeById(int modeId) throws Exception {
        logger.info("Entering into getTransportModeById method");
        return transportModeRepository.findById((long) modeId)
                .orElseThrow(() -> new Exception("Transport mode for modeId = " + modeId + " not found"));
    }

    public void deleteTransportModeById(int modeId) throws Exception {
        logger.info("Entering into deleteTransportModeById method");

        if (!transportModeRepository.existsById((long) modeId)) {
            throw new Exception("Transport mode for modeId = " + modeId + " not found");
        }

        transportModeRepository.deleteById((long) modeId);
    }

	@Override
	public TransportMode getTransportModeById(Long modeId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
