package com.gestiontickets.core_api.utils;

import com.gestiontickets.core_api.entities.Category;
import com.gestiontickets.core_api.entities.Role;
import com.gestiontickets.core_api.repositories.CategoryRepository;
import com.gestiontickets.core_api.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // ¡Importante! Esto le dice a Spring: "Carga esta clase al inicio"
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;

    // Inyección de dependencias por constructor (Best Practice)
    public DataSeeder(RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        cargarRoles();
        cargarCategorias();
    }

    private void cargarRoles() {
        // Validación: Solo crea datos si la tabla está vacía
        if (roleRepository.count() == 0) {
            crearRol("ADMIN", "Administrador total del sistema");
            crearRol("AGENT", "Agente de soporte técnico");
            crearRol("USER", "Usuario final / Empleado");
            System.out.println("✅ Roles creados exitosamente");
        }
    }

    private void cargarCategorias() {
        if (categoryRepository.count() == 0) {
            crearCategoria("HARDWARE");
            crearCategoria("SOFTWARE");
            crearCategoria("REDES");
            crearCategoria("ACCESOS");
            System.out.println("✅ Categorías creadas exitosamente");
        }
    }

    // Métodos auxiliares para no repetir código
    private void crearRol(String name, String description) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        roleRepository.save(role);
    }

    private void crearCategoria(String name) {
        Category category = new Category();
        category.setName(name);
        category.setActive(true);
        categoryRepository.save(category);
    }
}