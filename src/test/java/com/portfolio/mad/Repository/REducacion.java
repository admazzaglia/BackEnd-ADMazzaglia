package com.portfolio.mad.Repository;

import com.portfolio.mad.Entity.Educacion;
import java.time.Year;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
        public Optional<Educacion> findByNombreE(String nombreE);
        public boolean existsByNombreE(String nombreE);

    public Optional<Educacion> findByDesdeE(Year desdeE);

    public Optional<Educacion> findByHastaE(Year hastaE);
}
