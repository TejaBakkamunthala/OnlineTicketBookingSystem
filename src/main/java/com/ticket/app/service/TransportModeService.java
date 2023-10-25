package com.ticket.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ticket.app.common.Pagination;
import com.ticket.app.entity.TransportMode;

public interface TransportModeService {



	Page<TransportMode> getListOfTransportModes(TransportMode searchedTransportMode, Pagination pagination);

	TransportMode getTransportModeById(Long modeId);
}
