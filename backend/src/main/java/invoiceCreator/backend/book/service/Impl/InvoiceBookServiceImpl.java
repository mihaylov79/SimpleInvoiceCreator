package invoiceCreator.backend.book.service.Impl;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.book.repository.InvoiceBookRepository;
import invoiceCreator.backend.book.service.InvoiceBookService;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.user.service.UserService;
import invoiceCreator.backend.web.dto.CreateBookRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceBookServiceImpl implements InvoiceBookService {

    private final InvoiceBookRepository repository;
    private final UserService userService;

    public InvoiceBookServiceImpl(InvoiceBookRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }


    @Override
    public void createBook(CreateBookRequest bookRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User currentUser = userService.getUserByUsername(userName);
        Company company = currentUser.getActiveCompany();
        String generatedBookN = suggestBookN(company);

        Optional<InvoiceBook>existingN = repository.findByBookN(generatedBookN);

        if (existingN.isPresent()){
            generatedBookN = suggestBookN(company);
        }

        InvoiceBook book = InvoiceBook.builder()
                .bookN(generatedBookN)
                .description(bookRequest.getDescription())
                .company(company)
                .active(true)
                .build();
        try {
            repository.save(book);
        } catch (DataIntegrityViolationException e) {
            generatedBookN = suggestBookN(company);
            book = book.toBuilder()
                    .bookN(generatedBookN)
                    .build();

            try {
                repository.save(book);
            } catch (DataIntegrityViolationException ex) {
                throw new IllegalStateException("Неуспешно генериране на уникален номер на книга. Опитай по-късно.");
            }

        }


    }

    @Override
    public void editBookDescription(String Description) {

    }

    @Override
    public void markBookAsInactive() {

    }

    @Override
    public void markBookAsActive() {

    }

    @Override
    public List<InvoiceBook> getCompanyBooksList(Company company) {
        return repository.findAllByCompany(company, Sort.by(Sort.Order.by("bookN")));

    }

    @Override
    public String suggestBookN(Company company){
        List<InvoiceBook>companyBooks = getCompanyBooksList(company);
        int maxN = companyBooks.stream()
                .filter(c -> c.getBookN().matches("\\d+"))
                .map(c -> Integer.parseInt(c.getBookN()))
                .max(Integer::compareTo).orElse(0);

        return String.format("%03d",maxN +1);
    }
}
