package invoiceCreator.backend.web;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.service.CompanyServiceImpl;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.mapper.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
