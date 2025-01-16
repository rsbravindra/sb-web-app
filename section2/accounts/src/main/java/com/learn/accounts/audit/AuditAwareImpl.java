package com.learn.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    /**
     * The method returns an Optional containing the username of the currently logged in user.
     * If the user is not logged in, the method returns an empty Optional.
     * @return an Optional containing the username of the currently logged in user
     */
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }
}
