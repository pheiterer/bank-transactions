package bank.transactions.domain.transactions.subclass;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class Terms {
    @Embedded
    private InterestSettings interestSettings;

    @Embedded
    private OverdraftInterestSettings overdraftInterestSettings;

    @Embedded
    private OverdraftSettings overdraftSettings;

}
