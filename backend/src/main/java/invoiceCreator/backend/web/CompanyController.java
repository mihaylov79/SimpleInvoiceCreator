package invoiceCreator.backend.web;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.service.CompanyServiceImpl;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.dto.CreateCompanyRequest;
import invoiceCreator.backend.web.mapper.DTOMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:5174")
@RequestMapping("/api/v1.0/companies")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

//    @GetMapping("/new-company")
//    public ResponseEntity<CreateCompanyRequest>addNewCompany(){
//        return ResponseEntity.ok(new CreateCompanyRequest());
//    }

    @PostMapping("/new-company")
    public ResponseEntity<String> addNewCompany(@Valid @RequestBody CreateCompanyRequest request){

            companyService.createNewCompany(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Фирмата е създадена успешно!");
    }

    @GetMapping("/edit/{companyId}")
    public ResponseEntity<CompanyEditRequest>getCompanyDetails(@PathVariable UUID companyId){
        Company company = companyService.getCompanyById(companyId);
        CompanyEditRequest filledForm = DTOMapper.mapCompanyToEditRequest(company);
        return ResponseEntity.ok(filledForm);
    }

    @PutMapping("/edit/{companyId}")
    public ResponseEntity<Void>editCompanyDetails(@PathVariable UUID companyId,
                                                  @Valid @RequestBody CompanyEditRequest editRequest){

        companyService.editCompanyProfile(companyId,editRequest);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Company>> showCompanyList(){
        List<Company> allCompanies= companyService.showAllCompanies();
        return ResponseEntity.ok(allCompanies);
    }
}
