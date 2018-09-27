package org.zayac.pom.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface SpecificationRepository extends JpaRepository<Specification, Long> {

    Specification findByName(@Param("name") String name);
}
