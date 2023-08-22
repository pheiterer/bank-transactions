package bank.transactions.request;

import lombok.Data;

@Data
public
class TermsRequest {

    private InterestSettingsRequest interestSettings;


    private OverdraftInterestSettingsRequest overdraftInterestSettings;


    private OverdraftSettingsRequest overdraftSettings;

}
