package org.codenergic.simcat.user;

import org.codenergic.theskeleton.core.data.AuditingEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ContactRepository extends AuditingEntityRepository<ContactEntity> {
}
