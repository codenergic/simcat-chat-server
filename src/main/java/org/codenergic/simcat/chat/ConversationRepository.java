package org.codenergic.simcat.chat;

import org.codenergic.theskeleton.core.data.AuditingEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ConversationRepository extends AuditingEntityRepository<ConversationEntity> {
}
