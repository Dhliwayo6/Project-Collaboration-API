package com.example.Project.Collaboaration.API.project;

import com.example.Project.Collaboaration.API.project.model.Project;
import com.example.Project.Collaboaration.API.project.model.ProjectDTO;
import com.example.Project.Collaboaration.API.project.services.CreateProjectService;
import com.example.Project.Collaboaration.API.project.services.GetProjectsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final GetProjectsService getProjectsService;
//    private final GetProductsService getProductsService;
//    private final UpdateProductService updateProductService;
//    private final DeleteProductService deleteProductService;
//    private final GetProductService getProductService;
//    private final SearchProductService searchProductService;


    public ProjectController(CreateProjectService createProjectService, GetProjectsService getProjectsService) {
        this.createProjectService = createProjectService;
        this.getProjectsService = getProjectsService;
    }

    @PostMapping("/project")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody Project project){
        return createProjectService.execute(project);
    }

    @GetMapping("projects")
    public ResponseEntity<List<ProjectDTO>> getProducts(){
        return getProjectsService.execute(null);
    }
//
//    //new get mapping to find by id
//
//    @GetMapping("/product/{id}")
//    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
//        return getProductService.execute(id);
//    }
//
//    //Search functionality request
//
//    @GetMapping("/product/search")
//    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String name) {
//        return searchProductService.execute(name);
//    }
//
//    @PutMapping("/product/{id}")
//    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){
//        return updateProductService.execute(new UpdateProductCommand(id, product));
//    }
//
//    @DeleteMapping("/product/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
//        return deleteProductService.execute(id);
//    }

}

