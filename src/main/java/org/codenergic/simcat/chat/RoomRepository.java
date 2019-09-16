package org.codenergic.simcat.chat;

import java.util.Optional;

import org.codenergic.theskeleton.core.data.AuditingEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RoomRepository extends AuditingEntityRepository<RoomEntity> {
	Optional<RoomEntity> findByCreatorIdAndGroupAndMembersIdIn(String creatorId, boolean group, String... memberIds);
}
