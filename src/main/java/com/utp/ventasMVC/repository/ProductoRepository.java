package com.utp.ventasMVC.repository;

import com.utp.ventasMVC.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
