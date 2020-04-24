package com.cesi.seatingplan.dto.customers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public interface IMapper<Model, DTO> {
    public ModelMapper getModelMapper();
    public DTO map(Model model, DTO dto);
}
