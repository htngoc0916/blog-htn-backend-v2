package com.htn.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    void updateFromDto(D dto, @MappingTarget E entity);
}