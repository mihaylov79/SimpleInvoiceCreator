package invoiceCreator.backend.web;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.service.CompanyServiceImpl;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.mapper.DTOMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1.0/companies/")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
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
}
