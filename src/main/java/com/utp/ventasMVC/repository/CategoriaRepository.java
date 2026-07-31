package com.utp.ventasMVC.repository;

import com.utp.ventasMVC.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
